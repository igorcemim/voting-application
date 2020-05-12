package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.VoteResponse;
import br.com.igorc.voting.domain.Vote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VoteResponseConverter {
    public List<VoteResponse> convert(List<Vote> votes) {
        return Optional.ofNullable(votes)
                .map(this::convertList)
                .orElse(new ArrayList<>());
    }

    private List<VoteResponse> convertList(List<Vote> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public VoteResponse convert(Vote vote) {
        return null;
    }
}
