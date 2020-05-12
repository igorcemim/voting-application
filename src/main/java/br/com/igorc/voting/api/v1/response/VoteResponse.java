package br.com.igorc.voting.api.v1.response;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteResponse {
    private Long id;
    private VoteEnumeration vote;
    private AssociateResponse associate;
}
