package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.QuestionConverter;
import br.com.igorc.voting.converter.QuestionEntityConverter;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import br.com.igorc.voting.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService extends AbstractService<Question, QuestionEntity, Long> {

    private QuestionRepository repository;

    private QuestionEntityConverter questionEntityConverter;

    private QuestionConverter questionConverter;

    @Override
    protected QuestionEntity convertToEntity(Question domain) {
        return questionEntityConverter.convert(domain);
    }

    @Override
    protected Question convertToDomain(QuestionEntity entity) {
        return questionConverter.convert(entity);
    }

    @Override
    protected JpaRepository<QuestionEntity, Long> getRepository() {
        return repository;
    }

}
