package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.VotingSessionCreateResponse;
import br.com.igorc.voting.domain.VotingSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class VotingSessionCreateResponseConverter {

    private QuestionListResponseConverter questionListResponseConverter;

    public VotingSessionCreateResponse convert(VotingSession created) {
        return new VotingSessionCreateResponse(
                created.getId(),
                questionListResponseConverter.convertElement(created.getQuestion()),
                created.getDuration(),
                new ArrayList<>(),
                created.getVotesYes(),
                created.getVotesNo(),
                created.getStatus()
        );
    }
}
