package br.com.igorc.voting.api.v1.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VotingSessionCreateRequest {
    @Schema(title = "Pauta", description = "Código da pauta a ser votada.")
    private Long questionId;
    @Schema(title = "Duração", description = "Duração da sessão de votação.")
    private Integer duration;
}
