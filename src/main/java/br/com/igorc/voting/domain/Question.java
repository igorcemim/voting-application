package br.com.igorc.voting.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Pauta
 */
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class Question {
    private Long id;
    private String description;
}
