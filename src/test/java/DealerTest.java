import org.demo.simple.dealer.Dealer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {
    @Test
    public void testDealHand() {
        Dealer dealer = new Dealer();

        assertEquals(5, dealer.dealHand().getCards().size());
    }
}
