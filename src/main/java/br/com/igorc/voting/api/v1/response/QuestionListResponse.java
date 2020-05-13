package br.com.igorc.voting.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionListResponse implements ListResponse<QuestionResponse> {
    private List<QuestionResponse> content;
    private Integer currentPage;
    private Integer lastPage;
}
