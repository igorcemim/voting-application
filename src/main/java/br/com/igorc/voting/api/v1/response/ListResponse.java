package br.com.igorc.voting.api.v1.response;

import java.util.List;

public interface ListResponse<T> {
    List<T> getContent();
    Integer getCurrentPage();
    Integer getLastPage();
}
