package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.VoteRequest;
import br.com.igorc.voting.domain.Associate;
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
public class VoteConverter {

    private AssociateConverter associateConverter;

    public List<Vote> convert(List<VoteEntity> votes) {
        return Optional.ofNullable(votes)
                .map(this::convertList)
                .orElse(new ArrayList<>());
    }

    private List<Vote> convertList(List<VoteEntity> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Vote convert(VoteEntity vote) {
        return new Vote(
                vote.getId(),
                vote.getVote(),
                associateConverter.convert(vote.getAssociate())
        );
    }

    public Vote convert(VoteRequest request) {
        return new Vote(null, request.getVote(), new Associate(request.getAssociateId(), null));
    }
}
