package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.VotingSession;
import br.com.igorc.voting.entity.VotingSessionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotingSessionEntityConverter {

    private QuestionEntityConverter questionEntityConverter;
    private VoteEntityConverter voteEntityConverter;

    public VotingSessionEntity convert(VotingSession domain) {
        return new VotingSessionEntity(
                domain.getId(),
                questionEntityConverter.convert(domain.getQuestion()),
                domain.getDuration(),
                voteEntityConverter.convert(domain.getVotes()),
                domain.getVotesYes(),
                domain.getVotesNo(),
                domain.getStatus()
        );
    }

}
