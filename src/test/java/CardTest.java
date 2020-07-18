import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void Before(){
        card = new Card(SuitType.CLUBS, RankType.ACE);
    }

    @Test
    public void canGetRankValues(){
        assertEquals(11, card.getRankValue());
        assertEquals(1, card.getAlternativeRankValue());
    }

    @Test
    public void canGetStringName(){
        assertEquals("ACE of CLUBS", card.getName());
    }

}
