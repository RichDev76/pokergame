package org.demo.simple.card;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    public String toString() {
        return rank.toString() +
                suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.rank.getValue(), o.rank.getValue());
    }
}