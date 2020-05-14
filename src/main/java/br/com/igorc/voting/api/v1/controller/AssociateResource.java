package br.com.igorc.voting.api.v1.controller;

import br.com.igorc.voting.api.v1.request.AssociateCreateRequest;
import br.com.igorc.voting.api.v1.response.AssociateCreateResponse;
import br.com.igorc.voting.api.v1.response.AssociateListResponse;
import br.com.igorc.voting.converter.AssociateConverter;
import br.com.igorc.voting.converter.AssociateCreateResponseConverter;
import br.com.igorc.voting.converter.AssociateListResponseConverter;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.service.AssociateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Associados")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/associates")
public class AssociateResource {

	private AssociateService service;

	private AssociateConverter associateConverter;

	private AssociateCreateResponseConverter associateCreateResponseConverter;

	private AssociateListResponseConverter associateListResponseConverter;

	@Operation(summary = "Criar associado.")
	@PostMapping
	public AssociateCreateResponse create(@RequestBody @Valid AssociateCreateRequest request) {
		Associate associate = associateConverter.convert(request);
		Associate createdAssociate = service.create(associate);
		return associateCreateResponseConverter.convert(createdAssociate);
	}

	@Operation(summary = "Listar associados.")
	@GetMapping
	@Parameter(name = "page", description = "Número da página.")
	public AssociateListResponse list(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
		return associateListResponseConverter.convert(service.list(page));
	}

}
