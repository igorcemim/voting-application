package br.com.igorc.voting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "voting_session")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotingSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voting_session_seq")
    @SequenceGenerator(name = "voting_session_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    private QuestionEntity question;

    @Column(nullable = false)
    private Integer duration;

    @ManyToMany
    private List<VoteEntity> votes = new ArrayList<>();

    @Column
    private Long votesYes;

    @Column
    private Long votesNo;
}
