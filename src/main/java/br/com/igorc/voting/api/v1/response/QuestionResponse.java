package br.com.igorc.voting.api.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResponse {
    @Schema(title = "Código", description = "Código da pauta.")
    private Long id;
    @Schema(title = "Descrição", description = "Descrição da pauta.")
    private String description;
}
