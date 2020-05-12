package br.com.igorc.voting.converter;

import org.springframework.data.domain.Page;

import java.util.List;

abstract class ListResponseConverter<R, I, O> {

    public R convert(Page<I> page) {
        List<O> associates = page.map(e -> convertElement(e)).getContent();
        int lastPage = getLastPage(page);
        int currentPage = getCurrentPage(page);
        return createResponse(associates, currentPage, lastPage);
    }

    protected int getLastPage(Page<?> page) {
        return page.getTotalPages() > 0 ? page.getTotalPages() - 1 : 0;
    }

    protected int getCurrentPage(Page<?> page) {
        return page.getNumber();
    }

    abstract protected R createResponse(List<O> content, int currentPage, int lastPage);

    abstract protected O convertElement(I element);

}
