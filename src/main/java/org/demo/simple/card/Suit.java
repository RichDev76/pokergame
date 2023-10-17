package org.demo.simple.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Suit {
    SPADE('♠'),
    HEART('❤'),
    DIAMOND('♦'),
    CLUB('♣');

    private final char value;

    public String toString() {
        return String.valueOf(value);
    }
}
