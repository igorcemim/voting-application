package br.com.igorc.voting.api.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public interface ListResponse<T> {
    List<T> getContent();
    @Schema(description = "Página atual da lista.")
    Integer getCurrentPage();
    @Schema(description = "Última página da lista.")
    Integer getLastPage();
}
