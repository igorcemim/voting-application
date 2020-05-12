package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.VotingSessionConverter;
import br.com.igorc.voting.domain.VotingSession;
import br.com.igorc.voting.entity.VotingSessionEntity;
import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import br.com.igorc.voting.exception.BusinessException;
import br.com.igorc.voting.messaging.producer.VotingSessionProducer;
import br.com.igorc.voting.repository.VotingSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CloseSessionService {

    private VotingSessionRepository repository;
    private VotingSessionConverter votingSessionConverter;
    private VotingSessionProducer votingSessionProducer;

    /**
     * Contabiliza os votos e encerra a sessão de votação, disparando um evento com o resultado.
     */
    @Transactional
    public void close(Long id) {
        VotingSessionEntity votingSessionEntity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Falha ao fechar sessão de votação. Não foi possível encontrar a sessão."));
        votingSessionEntity.setStatus(VotingStatusEnumeration.CLOSED);
        repository.save(votingSessionEntity);
        VotingSession votingSessionUpdated = votingSessionConverter.convert(votingSessionEntity);
        votingSessionProducer.sendResult(votingSessionUpdated);
    }

}
