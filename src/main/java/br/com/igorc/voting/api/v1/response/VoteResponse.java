package br.com.igorc.voting.api.v1.response;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteResponse {
    @Schema(title = "Código", description = "Código do voto.")
    private Long id;
    @Schema(title = "Voto", description = "Valor do voto (Sim/Não).")
    private VoteEnumeration vote;
    private AssociateResponse associate;
}
