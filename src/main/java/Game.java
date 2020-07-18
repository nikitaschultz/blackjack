import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;

    public Game() {
        this.players = new ArrayList<Player>();
        this.dealer = new Dealer();
        this.deck = new Deck();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void add(Player player){
        this.players.add(player);
    }

    public void startGame(){
        this.deck.populate();
        this.deck.shuffle();
    }

    public void dealCards(){
        this.dealer.add(this.deck.remove());
        this.dealer.add(this.deck.remove());
        for(Player player : this.players){
            player.add(this.deck.remove());
            player.add(this.deck.remove());
        }
    }



}
