package br.com.igorc.voting.api.v1.controller;

import br.com.igorc.voting.api.v1.request.VoteRequest;
import br.com.igorc.voting.api.v1.request.VotingSessionCreateRequest;
import br.com.igorc.voting.api.v1.response.VotingSessionCreateResponse;
import br.com.igorc.voting.api.v1.response.VotingSessionListResponse;
import br.com.igorc.voting.converter.VoteConverter;
import br.com.igorc.voting.converter.VotingSessionConverter;
import br.com.igorc.voting.converter.VotingSessionCreateResponseConverter;
import br.com.igorc.voting.converter.VotingSessionListResponseConverter;
import br.com.igorc.voting.domain.Vote;
import br.com.igorc.voting.domain.VotingSession;
import br.com.igorc.voting.service.VotingSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Sessões de votação")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/voting-session")
public class VotingSessionResource {

	private VotingSessionService service;

	private VotingSessionConverter votingSessionConverter;

	private VotingSessionCreateResponseConverter createResponseConverter;

	private VotingSessionListResponseConverter listResponseConverter;

	private VoteConverter voteConverter;

	@Operation(summary = "Criar sessão de votação.")
	@PostMapping
	public VotingSessionCreateResponse create(@RequestBody @Valid VotingSessionCreateRequest request) {
		VotingSession votingSession = votingSessionConverter.convert(request);
		VotingSession created = service.create(votingSession);
		return createResponseConverter.convert(created);
	}

	@Operation(summary = "Listar sessões de votação.")
	@Parameter(name = "page", description = "Número da página.")
	@GetMapping
	public VotingSessionListResponse list(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
		return listResponseConverter.convert(service.list(page));
	}

	@Operation(summary = "Votar em uma sessão de votação aberta.")
	@Parameter(name = "id", description = "Código da sessão de votação.")
	@PostMapping("/{id}/vote")
	public void vote(@PathVariable("id") Long votingSessionId, @RequestBody @Valid VoteRequest request) {
		Vote vote = voteConverter.convert(request);
		service.vote(votingSessionId, vote);
	}

}