package br.com.igorc.voting.enumeration;

import lombok.Getter;

@Getter
public enum VoteEnumeration {
    YES("Yes"), NO("No");

    private final String value;

    VoteEnumeration(String value) {
        this.value = value;
    }

}
