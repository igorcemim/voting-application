package br.com.igorc.voting.api.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociateResponse {
    @Schema(title = "ID", description = "Código do associado.")
    private Long id;
    @Schema(title = "CPF", description = "CPF do associado.")
    private String cpf;
}
