package org.demo.simple.dealer;

import lombok.Getter;
import lombok.Setter;
import org.demo.simple.card.Card;
import org.demo.simple.card.Deck;
import org.demo.simple.hand.Hand;
import org.demo.simple.hand.HandEvaluationEngine;

import java.util.List;

@Getter
@Setter

public class Dealer implements IDealerAction {

    private static final int DEFAULT_HAND_SIZE = 5;
    private Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    @Override
    public void shuffle() {
        deck.shuffle();
    }

    @Override
    public Hand dealHand() {
        return dealHand(DEFAULT_HAND_SIZE);
    }

    @Override
    public Hand dealHand(int handSize) {
        Hand hand = new Hand(handSize);
        List<Card> cards = hand.getCards();
        for (int i = 0; i < handSize; i++) {
            cards.add(deck.getCards().remove(0));
        }
        return hand;
    }

    @Override
    public String evaluateHand(Hand hand) {
        return HandEvaluationEngine.evaluateHand(hand).getValue();
    }
}
