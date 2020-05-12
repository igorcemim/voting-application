package br.com.igorc.voting.api.v1.response;

import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class VotingSessionCreateResponse {
    private Long id;

    private QuestionResponse question;

    private Integer duration;

    private List<VoteResponse> votes = new ArrayList<>();

    private Long votesYes;

    private Long votesNo;

    private VotingStatusEnumeration status;
}
