package br.com.igorc.voting.api.v1.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class VotingSessionCreateRequest {
    @Schema(title = "Pauta", description = "Código da pauta a ser votada.")
    @NotNull(message = "O campo Associado é obrigatório.")
    private Long questionId;
    @Schema(title = "Duração", description = "Duração da sessão de votação.")
    @NotNull(message = "O campo Duração é obrigatório.")
    @Min(value = 1, message = "A duração mínima é de 1 minuto.")
    @Max(value = 60, message = "A duração máxima é de 60 minutos.")
    private Integer duration;
}
