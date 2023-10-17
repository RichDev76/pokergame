import org.demo.simple.card.Card;
import org.demo.simple.card.Rank;
import org.demo.simple.card.Suit;
import org.demo.simple.dealer.Dealer;
import org.demo.simple.hand.Hand;
import org.demo.simple.hand.HandRankingCategory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class HandEvaluationTest {

    private static Hand getHand(Card... cards) {
        Hand hand = getHand(5);
        List<Card> cardsInHand = hand.getCards();
        cardsInHand.addAll(Arrays.asList(cards));
        hand.setCards(cardsInHand);
        return hand;
    }

    private static Dealer getDealer() {
        return new Dealer();
    }

    private static Hand getHand(int handSize) {
        return new Hand(handSize);
    }

    @Test
    public void testStraightFlush() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.HEART, Rank.TEN),
                new Card(Suit.HEART, Rank.NINE), new Card(Suit.HEART, Rank.EIGHT), new Card(Suit.HEART, Rank.SEVEN));

        assertSame(HandRankingCategory.STRAIGHT_FLUSH.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.ACE), new Card(Suit.HEART, Rank.KING),
                new Card(Suit.HEART, Rank.QUEEN), new Card(Suit.HEART, Rank.JACK), new Card(Suit.HEART, Rank.TEN));

        assertSame(HandRankingCategory.STRAIGHT_FLUSH.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.ACE), new Card(Suit.HEART, Rank.TWO),
                new Card(Suit.HEART, Rank.THREE), new Card(Suit.HEART, Rank.FOUR), new Card(Suit.HEART, Rank.FIVE));

        assertSame(HandRankingCategory.STRAIGHT_FLUSH.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testFourOfAKind() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.CLUB, Rank.JACK), new Card(Suit.DIAMOND, Rank.JACK), new Card(Suit.HEART, Rank.SEVEN));

        assertSame(HandRankingCategory.FOUR_OF_A_KIND.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testFullHouse() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.CLUB, Rank.JACK), new Card(Suit.DIAMOND, Rank.FOUR), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.FULL_HOUSE.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testFlush() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.KING), new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.HEART, Rank.THREE), new Card(Suit.HEART, Rank.QUEEN), new Card(Suit.HEART, Rank.SEVEN));

        assertSame(HandRankingCategory.FLUSH.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testStraight() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.DIAMOND, Rank.TEN),
                new Card(Suit.SPADE, Rank.NINE), new Card(Suit.SPADE, Rank.EIGHT), new Card(Suit.CLUB, Rank.SEVEN));

        assertSame(HandRankingCategory.STRAIGHT.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.ACE), new Card(Suit.HEART, Rank.KING),
                new Card(Suit.SPADE, Rank.QUEEN), new Card(Suit.CLUB, Rank.JACK), new Card(Suit.CLUB, Rank.TEN));

        assertSame(HandRankingCategory.STRAIGHT.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.ACE), new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.SPADE, Rank.THREE), new Card(Suit.SPADE, Rank.FOUR), new Card(Suit.CLUB, Rank.FIVE));

        assertSame(HandRankingCategory.STRAIGHT.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testThreeOfAKind() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.CLUB, Rank.JACK), new Card(Suit.DIAMOND, Rank.SIX), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.THREE_OF_A_KIND.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testTwoPair() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.CLUB, Rank.KING), new Card(Suit.DIAMOND, Rank.FOUR), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.TWO_PAIR.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testOnePair() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.JACK), new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.CLUB, Rank.QUEEN), new Card(Suit.DIAMOND, Rank.TWO), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.ONE_PAIR.getValue(), getDealer().evaluateHand(hand));
    }

    @Test
    public void testHighCard() {
        Hand hand = getHand(new Card(Suit.HEART, Rank.KING), new Card(Suit.SPADE, Rank.SIX),
                new Card(Suit.CLUB, Rank.JACK), new Card(Suit.DIAMOND, Rank.SEVEN), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.HIGH_CARD.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.KING), new Card(Suit.SPADE, Rank.ACE),
                new Card(Suit.CLUB, Rank.JACK), new Card(Suit.DIAMOND, Rank.SEVEN), new Card(Suit.HEART, Rank.FOUR));

        assertSame(HandRankingCategory.HIGH_CARD.getValue(), getDealer().evaluateHand(hand));

        hand = getHand(new Card(Suit.HEART, Rank.QUEEN), new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.CLUB, Rank.NINE), new Card(Suit.CLUB, Rank.SEVEN), new Card(Suit.SPADE, Rank.EIGHT));

        assertSame(HandRankingCategory.HIGH_CARD.getValue(), getDealer().evaluateHand(hand));
    }
}
