package br.com.igorc.voting.api.v1.request;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteRequest {
    @Schema(title = "Voto", description = "Voto do associado.")
    private VoteEnumeration vote;
    @Schema(title = "Associado", description = "Código do associado.")
    private Long associateId;
}
