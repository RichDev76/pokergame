import org.demo.simple.card.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckCreation(){
        Deck deck = new Deck();
        assertNotNull(deck.getCards());
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void testDeckCreationByDeckSize(){
        Deck deck = new Deck(52);
        assertNotNull(deck.getCards());
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void testDeckCreationFailure(){
        assertThrows(IllegalArgumentException.class , () -> new Deck(53));
    }
}
