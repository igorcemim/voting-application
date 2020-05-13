package br.com.igorc.voting.api.v1.request;

import br.com.caelum.stella.bean.validation.CPF;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AssociateCreateRequest {
    @Schema(title = "CPF", description = "CPF do associado.")
    @NotEmpty(message = "O campo CPF é obrigatório.")
    @CPF(message = "O campo CPF deve conter um número válido.")
    private String cpf;
}
