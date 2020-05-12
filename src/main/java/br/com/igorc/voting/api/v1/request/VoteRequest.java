package br.com.igorc.voting.api.v1.request;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteRequest {
    private VoteEnumeration vote;
    private Long associateId;
}
