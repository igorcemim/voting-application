package br.com.igorc.voting.messaging.listener;

import br.com.igorc.voting.domain.VotingSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class VotingSessionListener {

	private ObjectMapper objectMapper;

    /**
     * Simulando um outro microserviço ou sistema consumindo a mensagem de resultado.
     */
	@JmsListener(destination = "voting-session-result", containerFactory = "defaultContainerFactory")
	public void receiveMessage(VotingSession message) {
		try {
			log.info("Resultado da votação recebido: " + objectMapper.writeValueAsString(message));
		} catch (JsonProcessingException e) {
			log.error("Falha ao converter para JSON.", e);
		}
	}

}
