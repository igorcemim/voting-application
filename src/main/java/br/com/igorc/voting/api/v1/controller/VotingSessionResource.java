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
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/voting-session")
public class VotingSessionResource {

	private VotingSessionService service;

	private VotingSessionConverter votingSessionConverter;

	private VotingSessionCreateResponseConverter createResponseConverter;

	private VotingSessionListResponseConverter listResponseConverter;

	private VoteConverter voteConverter;

	@PostMapping
	public VotingSessionCreateResponse create(@RequestBody @Valid VotingSessionCreateRequest request) {
		VotingSession votingSession = votingSessionConverter.convert(request);
		VotingSession created = service.create(votingSession);
		return createResponseConverter.convert(created);
	}

	@GetMapping
	public VotingSessionListResponse list(
			@ApiParam(name = "page", value = "Número da página.") @RequestParam(defaultValue = "0") int page
	) {
		return listResponseConverter.convert(service.list(page));
	}

	@PostMapping("/{id}/vote")
	public void vote(@PathVariable("id") Long votingSessionId, @RequestBody @Valid VoteRequest request) {
		Vote vote = voteConverter.convert(request);
		service.vote(votingSessionId, vote);
	}

}