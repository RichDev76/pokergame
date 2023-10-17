package org.demo.simple.hand;

import org.demo.simple.card.Card;
import org.demo.simple.card.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.demo.simple.hand.HandRankingCategory.*;

/***************************************************************************************
 *    Title: Guide to Spring Boot REST API Error Handling
 *    Author: gdejohn
 *    Date: 2023-01-07
 *    Code version: 1.0
 *    Availability: https://stackoverflow.com/questions/10363927/the-simplest-algorithm-for-poker-hand-evaluation
 *    Description: Base code from the link above but modularised and enhanced
 ***************************************************************************************/
public class HandEvaluationEngine {

    private static final int ACE_HIGH_STRAIGHT_SUMMED_RANK_VALUE = 47;

    public static HandRankingCategory evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();
        boolean flush = isFlush(cards);
        Map<Rank, Long> counts = getRankCounts(cards);
        Rank[] ranks = getGroupedRanks(counts);
        return getHandRankingCategory(ranks, counts, flush);
    }

    private static HandRankingCategory getHandRankingCategory(Rank[] ranks, Map<Rank, Long> counts, boolean flush) {
        if (ranks.length == 4) {
            return HandRankingCategory.ONE_PAIR;
        } else if (ranks.length == 3) {
            return counts.get(ranks[0]) == 2 ? TWO_PAIR : THREE_OF_A_KIND;
        } else if (ranks.length == 2) {
            return counts.get(ranks[0]) == 3 ? FULL_HOUSE : FOUR_OF_A_KIND;
        } else if (ranks[0].ordinal() - ranks[4].ordinal() == 4) {
            return flush ? STRAIGHT_FLUSH : STRAIGHT;
        } else if (checkAceHighStraight(ranks)) {
            return flush ? STRAIGHT_FLUSH : STRAIGHT;
        } else {
            return flush ? FLUSH : HIGH_CARD;
        }
    }

    private static Rank[] getGroupedRanks(Map<Rank, Long> counts) {
        return counts.entrySet().stream()
                .sorted(comparing(Map.Entry<Rank, Long>::getValue)
                        .thenComparing(Map.Entry::getKey)
                        .reversed())
                .map(Map.Entry::getKey)
                .toArray(Rank[]::new);
    }

    private static Map<Rank, Long> getRankCounts(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getRank, counting()));
    }

    private static boolean isFlush(List<Card> cards) {
        return cards.stream().map(Card::getSuit).distinct().count() == 1;
    }

    /*
     * In order to determine whether an ace high straight exists('A','K','Q','J','10'),
     * 1. first check if the 1st and last ranks are 'A' and 'K' respectively
     * 2. (a) If they are then make sure the sum total of the value of all the cards in the ranks = 47
     *    (b) Return false if the conditions above are not met.
     */
    private static boolean checkAceHighStraight(Rank[] ranks) {
        if((ranks[0].equals(Rank.ACE) && ranks[4].equals(Rank.KING)))
            return ACE_HIGH_STRAIGHT_SUMMED_RANK_VALUE == (Arrays.stream(ranks).mapToInt(Rank::getValue).sum());
        return false;
    }
}
