package br.com.igorc.voting.api.v1.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class QuestionCreateRequest {
    @Schema(title = "Descrição", description = "Descrição da pauta.")
    @NotEmpty(message = "O campo Descrição é obrigatório.")
    private String description;
}
