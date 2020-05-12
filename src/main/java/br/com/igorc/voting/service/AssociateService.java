package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.AssociateConverter;
import br.com.igorc.voting.converter.AssociateEntityConverter;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import br.com.igorc.voting.repository.AssociateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociateService extends AbstractService<Associate, AssociateEntity, Long> {

    private AssociateRepository repository;

    private AssociateEntityConverter associateEntityConverter;

    private AssociateConverter associateConverter;

    @Override
    protected AssociateEntity convertToEntity(Associate domain) {
        return associateEntityConverter.convert(domain);
    }

    @Override
    protected Associate convertToDomain(AssociateEntity entity) {
        return associateConverter.convert(entity);
    }

    @Override
    protected JpaRepository<AssociateEntity, Long> getRepository() {
        return repository;
    }

}
