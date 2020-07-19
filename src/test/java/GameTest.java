import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;


    @Before
    public void Before(){
        game = new Game();
        player1 = new Player("Nikita");
        player2 = new Player("Tom");
    }

    @Test
    public void gameInitializesWithNoPlayers(){
        assertEquals(0, game.getPlayers().size());
    }

    @Test
    public void canAddPlayers(){
        game.add(player1);
        game.add(player2);
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    public void canDealCards(){
        game.add(player1);
        game.add(player2);
        game.populateDeck();
        game.shuffleDeck();
        game.dealCards();
        assertEquals(46, game.getDeck().getCards().size());
        assertEquals(2, player1.getCards().size());
        assertEquals(2, player2.getCards().size());
        assertEquals(2, game.getDealer().getCards().size());
    }

}
