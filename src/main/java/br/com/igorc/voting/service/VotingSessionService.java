package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.VoteEntityConverter;
import br.com.igorc.voting.converter.VotingSessionConverter;
import br.com.igorc.voting.converter.VotingSessionEntityConverter;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.domain.Vote;
import br.com.igorc.voting.domain.VotingSession;
import br.com.igorc.voting.entity.VoteEntity;
import br.com.igorc.voting.entity.VotingSessionEntity;
import br.com.igorc.voting.exception.BusinessException;
import br.com.igorc.voting.exception.NotFoundException;
import br.com.igorc.voting.job.CloseVotingSessionJob;
import br.com.igorc.voting.repository.VoteRepository;
import br.com.igorc.voting.repository.VotingSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class VotingSessionService extends AbstractService<VotingSession, VotingSessionEntity, Long> {

    private VotingSessionRepository repository;
    private VotingSessionEntityConverter votingSessionEntityConverter;
    private VotingSessionConverter votingSessionConverter;
    private TaskScheduler taskScheduler;
    private VoteEntityConverter voteEntityConverter;
    private VoteRepository voteRepository;
    private CloseSessionService closeSessionService;
    private QuestionService questionService;

    @Override
    protected VotingSessionEntity convertToEntity(VotingSession domain) {
        return votingSessionEntityConverter.convert(domain);
    }

    @Override
    protected VotingSession convertToDomain(VotingSessionEntity entity) {
        return votingSessionConverter.convert(entity);
    }

    @Override
    protected JpaRepository<VotingSessionEntity, Long> getRepository() {
        return repository;
    }

    @Override
    public VotingSession create(VotingSession domain) {
        domain = validateAndFill(domain);
        domain = super.create(domain);
        scheduleClosing(domain);
        return domain;
    }

    /**
     * Valida e carrega as entidades relacionadas.
     */
    private VotingSession validateAndFill(VotingSession domain) {
        /**
         * Valida a existência das entidades relacionadas.
         */
        Question question = questionService.find(domain.getQuestion().getId())
                .orElseThrow(() -> new BusinessException("A pauta informada não existe."));
        /**
         * Carrega o domínio com as entidades relacionadas.
         */
        domain = new VotingSession(
                domain.getId(),
                question,
                domain.getDuration(),
                domain.getVotes(),
                domain.getStatus()
        );
        return domain;
    }

    /**
     * Agenda a tarefa de fechamento da sessão de votação.
     */
    private void scheduleClosing(VotingSession domain) {
        Instant instant = calculateClosingTime(domain.getDuration());
        taskScheduler.schedule(new CloseVotingSessionJob(domain.getId(), closeSessionService), instant);
    }

    private Instant calculateClosingTime(Integer duration) {
        return Instant.now().plusSeconds(duration * 60);
    }

    /**
     * Contabiliza um voto em uma sessão de votação.
     */
    public void vote(Long votingSessionId, Vote vote) {
        VotingSessionEntity votingSessionEntity = repository.findById(votingSessionId)
                .orElseThrow(() -> new NotFoundException("Sessão de votação não encontrada."));
        VotingSession votingSession = convertToDomain(votingSessionEntity);

        if (votingSession.isClosed()) {
            throw new BusinessException("A sessão de votação está fechada.");
        }

        if (votingSession.hasAssociateVoted(vote.getAssociate())) {
            throw new BusinessException("O associado informado já votou na sessão.");
        }

        VoteEntity voteEntity = voteEntityConverter.convert(vote);
        voteRepository.save(voteEntity);
        votingSessionEntity.getVotes().add(voteEntity);
        repository.save(votingSessionEntity);
    }

}
