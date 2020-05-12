package br.com.igorc.voting.domain;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Sessão de votação
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class VotingSession {

    private Long id;
    /**
     * Pauta em votação.
     */
    private Question question;
    /**
     * Duração da sessão em minutos.
     */
    private Integer duration;
    /**
     * Lista de votos.
     */
    private List<Vote> votes;
    /**
     * Status da sessão (Aberta/Fechada).
     */
    private VotingStatusEnumeration status;

    /**
     * Verifica se o associado informado já votou.
     * @return verdadeiro caso o associado informado já tenha votado.
     */
    public Boolean hasAssociateVoted(Associate associate) {
        long associatePreviousVotes = votes.stream()
                .filter(v -> associate.getId().equals(v.getAssociate().getId()))
                .count();

        return associatePreviousVotes > 0;
    }

    /**
     * @return quantidade de votos "Sim".
     */
    public Long getVotesYes() {
        return votes.stream()
                .filter(v -> VoteEnumeration.YES.equals(v.getVote()))
                .count();
    }

    /**
     * @return quantidade de votos "Não".
     */
    public Long getVotesNo() {
        return votes.stream()
                .filter(v -> VoteEnumeration.NO.equals(v.getVote()))
                .count();
    }

    public Boolean isClosed() {
        return VotingStatusEnumeration.CLOSED.equals(status);
    }

}
