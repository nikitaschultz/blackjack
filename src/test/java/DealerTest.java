import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void Before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.DIAMONDS, RankType.NINE);
        card2 = new Card(SuitType.CLUBS, RankType.ACE);
        card3 = new Card(SuitType.HEARTS, RankType.FOUR);
        card4 = new Card(SuitType.HEARTS, RankType.EIGHT);
    }

    @Test
    public void startsWithNoCards(){
        assertEquals(0, dealer.getCards().size());
    }

    @Test
    public void canAddCardsToHand(){
        dealer.add(card1);
        dealer.add(card2);
        assertEquals(2, dealer.getCards().size());
    }

    @Test
    public void canGetTotal(){
        dealer.add(card1);
        dealer.add(card2);
        assertEquals(20, dealer.getTotal());
    }

    @Test
    public void aceCanChangeValue(){
        dealer.add(card1);
        dealer.add(card2);
        dealer.add(card3);
        assertEquals(14, dealer.getTotal());
    }

    @Test
    public void canGetNextMoveIfHit(){
        dealer.add(card1);
        assertEquals(true, dealer.hitStatus());
    }

    @Test
    public void canGetNextMoveIfStay(){
        dealer.add(card1);
        dealer.add(card2);
        assertEquals(false, dealer.hitStatus());
    }
}
