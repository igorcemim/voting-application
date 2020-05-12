package br.com.igorc.voting.enumeration;

import lombok.Getter;

@Getter
public enum VotingStatusEnumeration {
    OPEN("Open"), CLOSED("Closed");

    private final String description;

    VotingStatusEnumeration(String description) {
        this.description = description;
    }
}
