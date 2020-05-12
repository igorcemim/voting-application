package br.com.igorc.voting.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Associado
 */
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class Associate {
    private Long id;
    private String cpf;
}
