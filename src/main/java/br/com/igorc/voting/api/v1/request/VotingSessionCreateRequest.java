package br.com.igorc.voting.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VotingSessionCreateRequest {
    private Long questionId;
    private Integer duration;
}
