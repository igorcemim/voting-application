package br.com.igorc.voting.messaging.producer;

import br.com.igorc.voting.domain.VotingSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class VotingSessionProducer {

    private JmsTemplate jmsTemplate;

    /**
     * Envia a mensagem com o resultado da votação.
     */
    public void sendResult(VotingSession domain) {
        String destination = "voting-session-result";
        jmsTemplate.convertAndSend(destination, domain);
        log.info("Enviando para {} a mensagem: {}", destination, domain);
    }

}
