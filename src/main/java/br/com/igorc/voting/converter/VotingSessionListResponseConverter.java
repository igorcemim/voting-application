package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.VotingSessionListResponse;
import br.com.igorc.voting.api.v1.response.VotingSessionResponse;
import br.com.igorc.voting.domain.VotingSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VotingSessionListResponseConverter extends ListResponseConverter<VotingSessionListResponse, VotingSession, VotingSessionResponse> {

    private VoteResponseConverter voteResponseConverter;

    private QuestionListResponseConverter questionListResponseConverter;

    @Override
    protected VotingSessionListResponse createResponse(List<VotingSessionResponse> content, int currentPage, int lastPage) {
        return new VotingSessionListResponse(content, currentPage, lastPage);
    }

    @Override
    protected VotingSessionResponse convertElement(VotingSession element) {
        return new VotingSessionResponse(
                element.getId(),
                questionListResponseConverter.convertElement(element.getQuestion()),
                element.getDuration(),
                voteResponseConverter.convert(element.getVotes()),
                element.getVotesYes(),
                element.getVotesNo(),
                element.getStatus()
        );
    }
}
