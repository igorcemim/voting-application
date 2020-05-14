package br.com.igorc.voting.api.v1.request;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class VoteRequest {
    @Schema(title = "Voto", description = "Voto do associado.")
    @NotNull(message = "O campo Voto é obrigatório.")
    private VoteEnumeration vote;
    @Schema(title = "Associado", description = "Código do associado.")
    @NotNull(message = "O campo Associado é obrigatório.")
    private Long associateId;
}
