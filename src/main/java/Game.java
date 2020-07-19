import java.util.ArrayList;
import java.util.Scanner;

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

    public void createPlayers(){
        Scanner scanner = new Scanner(System.in);

        int playerNumber = 1;
        System.out.println(String.format("Type the name of player %d:", playerNumber));
        String name = scanner.nextLine();
        this.add(new Player(name));

        boolean addPlayer = true;

        while(addPlayer == true){
            playerNumber += 1;
            System.out.println(String.format("To play with %d players, type 'play'.  Otherwise, type the name of player %d.", playerNumber - 1, playerNumber));
            name = scanner.nextLine();
            if(name.equalsIgnoreCase("play")){
                addPlayer = false;
            }else{
                this.add(new Player(name));
            }
        }
    }

    public void playerHit(Player player){
        player.add(this.deck.remove());
    }

    public void getWinners(){
        ArrayList<Player> winners = new ArrayList<Player>();
        for(Player player : this.players){
            if(!player.isBust()){
                winners.add(player);
            }
        }


    }



}
