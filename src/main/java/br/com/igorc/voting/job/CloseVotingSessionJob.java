package br.com.igorc.voting.job;

import br.com.igorc.voting.service.CloseSessionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CloseVotingSessionJob implements Runnable {

    private Long votingSessionId;
    private CloseSessionService service;

    /**
     * Chama o método da camada de serviço responsável por encerrar a sessão de votação.
     */
    @Override
    public void run() {
        service.close(votingSessionId);
    }

}
