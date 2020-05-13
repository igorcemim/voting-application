package br.com.igorc.voting.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VotingSessionListResponse implements ListResponse<VotingSessionResponse> {
    private List<VotingSessionResponse> content;
    private Integer currentPage;
    private Integer lastPage;
}
