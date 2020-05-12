package br.com.igorc.voting.entity;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "vote")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity implements EntityId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
    @SequenceGenerator(name = "vote_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    private AssociateEntity associate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoteEnumeration vote;
}
