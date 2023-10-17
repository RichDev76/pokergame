package org.demo.simple.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Deck {

    public static final int DECK_SIZE = 52;
    private final List<Card> cards;

    public Deck() {
        this(DECK_SIZE);
    }

    public Deck(int deckSize) {
        validateDeckSize(deckSize);
        cards = new ArrayList<>(deckSize);
        initialiseDeck();
    }

    private static void validateDeckSize(int deckSize) {
        if(deckSize != 52){
            throw new IllegalArgumentException("Currently only a 52 card deck is supported.");
        }
    }

    private void initialiseDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
