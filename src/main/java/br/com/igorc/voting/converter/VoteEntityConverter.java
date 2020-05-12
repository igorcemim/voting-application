package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.Vote;
import br.com.igorc.voting.entity.VoteEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VoteEntityConverter {

    private AssociateEntityConverter associateEntityConverter;

    public List<VoteEntity> convert(List<Vote> votes) {
        return Optional.ofNullable(votes)
                .map(list -> convertList(list))
                .orElse(new ArrayList<>());
    }

    private List<VoteEntity> convertList(List<Vote> list) {
        return list.stream()
                .map(v -> convert(v))
                .collect(Collectors.toList());
    }

    public VoteEntity convert(Vote vote) {
        return new VoteEntity(
                vote.getId(),
                associateEntityConverter.convert(vote.getAssociate()),
                vote.getVote()
        );
    }

}
