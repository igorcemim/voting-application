package br.com.igorc.voting.repository;

import br.com.igorc.voting.entity.VotingSessionEntity;
import br.com.igorc.voting.enumeration.VotingStatusEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotingSessionRepository extends JpaRepository<VotingSessionEntity, Long> {
    List<VotingSessionEntity> findAllByStatus(VotingStatusEnumeration status);
}
