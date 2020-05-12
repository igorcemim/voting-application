package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.VotingSessionCreateRequest;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.domain.VotingSession;
import br.com.igorc.voting.entity.VotingSessionEntity;
import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class VotingSessionConverter {

    private VoteConverter voteConverter;
    private QuestionConverter questionConverter;

    public VotingSession convert(VotingSessionEntity entity) {
        return new VotingSession(
                entity.getId(),
                questionConverter.convert(entity.getQuestion()),
                entity.getDuration(),
                voteConverter.convert(entity.getVotes()),
                entity.getStatus()
        );
    }

    public VotingSession convert(VotingSessionCreateRequest request) {
        return new VotingSession(
                null,
                new Question(request.getQuestionId(), null),
                request.getDuration(),
                new ArrayList<>(),
                VotingStatusEnumeration.OPEN
        );
    }
}
