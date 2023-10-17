package org.demo.simple.hand;

import lombok.Getter;
import lombok.Setter;
import org.demo.simple.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
public class Hand {

    private List<Card> cards;

    public Hand(int newHandSize) {
        cards = new ArrayList<>(newHandSize);
    }

    public String toString() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(" "));
    }
}
