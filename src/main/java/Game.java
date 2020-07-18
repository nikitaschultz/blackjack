import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;

    public Game() {
        this.players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void add(Player player){
        this.players.add(player);
    }

}
