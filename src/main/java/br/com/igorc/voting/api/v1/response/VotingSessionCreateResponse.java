package br.com.igorc.voting.api.v1.response;

import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class VotingSessionCreateResponse {
    @Schema(title = "Código", description = "Código da sessão de votação.")
    private Long id;

    private QuestionResponse question;

    @Schema(title = "Duração", description = "Duração da sessão de votação em minutos.")
    private Integer duration;

    private List<VoteResponse> votes = new ArrayList<>();

    @Schema(title = "Votos \"Sim\"", description = "Quantidade de votos \"Sim\".")
    private Long votesYes;

    @Schema(title = "Votos \"Não\"", description = "Quantidade de votos \"Não\".")
    private Long votesNo;

    @Schema(title = "Status", description = "Status da sessão de votação.")
    private VotingStatusEnumeration status;
}
