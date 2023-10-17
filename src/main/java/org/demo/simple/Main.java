package org.demo.simple;

import org.demo.simple.dealer.Dealer;
import org.demo.simple.hand.Hand;

/**
 * Simple 5 card poker game
 *
 * @author  RichDev76
 * @version 1.0
 * @since   2023-10-10
 */
public class Main {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        System.out.println("Dealer is shuffling...");
        dealer.shuffle();
        Hand hand = dealer.dealHand();
        System.out.printf("Your hand : %s%n", hand.toString());
        System.out.printf("You have : %s%n%n", dealer.evaluateHand(hand));
    }
}