import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void Before(){
        player = new Player("Nikita");
        card1 = new Card(SuitType.DIAMONDS, RankType.NINE);
        card2 = new Card(SuitType.CLUBS, RankType.ACE);
        card3 = new Card(SuitType.HEARTS, RankType.FOUR);
        card4 = new Card(SuitType.HEARTS, RankType.EIGHT);
    }

    @Test
    public void playerStartsWithNoCards(){
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void canAddCardsToPlayersHand(){
        player.add(card1);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canGetCardTotal(){
        player.add(card1);
        player.add(card2);
        assertEquals(20, player.getTotal());
        assertEquals(false, player.isBust());
    }

    @Test
    public void aceValueCanChange(){
        player.add(card1);
        player.add(card2);
        player.add(card3);
        assertEquals(14, player.getTotal());
        assertEquals(false, player.isBust());
    }

    @Test
    public void playerCanGoBust(){
        player.add(card1);
        player.add(card2);
        player.add(card3);
        player.add(card4);
        assertEquals(22, player.getTotal());
        assertEquals(true, player.isBust());
    }
}
