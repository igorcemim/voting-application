package br.com.igorc.voting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity implements EntityId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String description;
}
