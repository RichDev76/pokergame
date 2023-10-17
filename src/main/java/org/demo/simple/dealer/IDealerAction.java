package org.demo.simple.dealer;

import org.demo.simple.hand.Hand;

public interface IDealerAction {

    /**
     * This method randomly shuffles a deck of cards.
     *
     * @return void.
     */
    void shuffle();

    /**
     * This method draws a default hand made up of 5 cards
     *
     * @return Hand (default 5 cards).
     * @see Hand
     */
    Hand dealHand();

    /**
     * This method draws a hand made up of 5 cards
     *
     * @param handSize the number of cards to be dealt for the hand.
     * @return Hand (consists of handSize cards).
     * @see Hand
     */
    Hand dealHand(int handSize);

    /**
     * This method evaluates a Hand and returns a string representation of the hand rank
     *
     * @param hand the hand to be evaluated.
     * @return String (the string representation of the rank of the hand).
     * @see org.demo.simple.card.Rank
     */
    String evaluateHand(Hand hand);
}
