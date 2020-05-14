package br.com.igorc.voting.api.v1.controller;

import br.com.igorc.voting.api.v1.request.QuestionCreateRequest;
import br.com.igorc.voting.api.v1.response.QuestionCreateResponse;
import br.com.igorc.voting.api.v1.response.QuestionListResponse;
import br.com.igorc.voting.converter.QuestionConverter;
import br.com.igorc.voting.converter.QuestionCreateResponseConverter;
import br.com.igorc.voting.converter.QuestionListResponseConverter;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Pautas")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/questions")
public class QuestionResource {

	private QuestionService service;

	private QuestionConverter questionConverter;

	private QuestionCreateResponseConverter createResponseConverter;

	private QuestionListResponseConverter questionListResponseConverter;

	@Operation(summary = "Criar pauta.")
	@PostMapping
	public QuestionCreateResponse create(@RequestBody @Valid QuestionCreateRequest request) {
		Question question = questionConverter.convert(request);
		Question created = service.create(question);
		return createResponseConverter.convert(created);
	}

	@Operation(summary = "Listar pautas.")
	@GetMapping
	@Parameter(name = "page", description = "Número da página.")
	public QuestionListResponse list(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
		return questionListResponseConverter.convert(service.list(page));
	}

}
