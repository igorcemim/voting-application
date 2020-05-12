package br.com.igorc.voting.service;

import br.com.igorc.voting.entity.EntityId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public abstract class AbstractService<D, E extends EntityId<ID>, ID> {

    private final Integer PAGE_SIZE = 10;

    public D create(D domain) {
        E entity = convertToEntity(domain);
        getRepository().save(entity);
        return convertToDomain(entity);
    }

    public Optional<D> find(ID id) {
        return getRepository()
                .findById(id)
                .map(e -> convertToDomain(e));
    }

    public Page<D> list(int page) {
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
        return getRepository().findAll(pageRequest).map(e -> convertToDomain(e));
    }

    abstract protected E convertToEntity(D domain);

    protected abstract D convertToDomain(E entity);

    abstract protected PagingAndSortingRepository<E, ID> getRepository();
}
