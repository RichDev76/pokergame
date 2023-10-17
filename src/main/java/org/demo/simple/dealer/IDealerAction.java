package org.demo.simple.dealer;

import org.demo.simple.hand.Hand;

public interface IDealerAction {

    void shuffle();

    Hand dealHand();

    String evaluateHand(Hand hand);
}
