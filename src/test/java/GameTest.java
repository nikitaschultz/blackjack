import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player;

    @Before
    public void Before(){
        game = new Game();
        player = new Player("Nikita");
    }

    @Test
    public void gameInitializesWithNoPlayers(){
        assertEquals(0, game.getPlayers().size());
    }

    @Test
    public void canAddPlayers(){
        game.add(player);
        assertEquals(1, game.getPlayers().size());
    }

}
