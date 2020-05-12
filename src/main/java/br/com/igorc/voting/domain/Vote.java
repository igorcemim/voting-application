package br.com.igorc.voting.domain;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Voto
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Vote {
    private Long id;
    private VoteEnumeration vote;
    private Associate associate;
}
