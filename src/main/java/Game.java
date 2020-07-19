import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;
    private ArrayList<Player> playersInPlay;

    public Game() {
        this.players = new ArrayList<Player>();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.playersInPlay = new ArrayList<Player>();
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

    public void createPlayers() {
        Scanner scanner = new Scanner(System.in);

        int playerNumber = 1;
        System.out.println(String.format("Type the name of player %d:", playerNumber));
        String name = scanner.nextLine();
        this.add(new Player(name));

        boolean addPlayer = true;

        while (addPlayer == true) {
            playerNumber += 1;
            System.out.println(String.format("To play with %d players, type 'play'.  Otherwise, type the name of player %d.", playerNumber - 1, playerNumber));
            name = scanner.nextLine();

            if (name.equalsIgnoreCase("play")) {
                addPlayer = false;
            } else {
                this.add(new Player(name));
            }
        }
    }


    public void setInitialChips(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many chips should each player start with?");

        int startingChips = 10;

        try{
            startingChips = scanner.nextInt();
        }catch(Exception e){
            System.out.println("Starting chips value must be numerical.  Starting chip value has been set to 10.");
        }

        for(Player player : this.players){
            player.addChips(startingChips);
        }
    }

    public int getBetValue(){
        Scanner scanner = new Scanner(System.in);

        int bet = 1;

        try{
            bet = scanner.nextInt();
        }catch(Exception e){
            System.out.println("Bet value must be numerical.  Bet has been set to 1.");
        }finally{
            return bet;
        }
    }

    public void getPlayerBets(){
        Scanner scanner = new Scanner(System.in);

        for(Player player : this.players){
            boolean betOkay = false;
            while(betOkay == false) {
                System.out.println(String.format("%s, you have %d chips.  How many chips would you like to bet?", player.getName(), player.getChips()));

                int bet = this.getBetValue();
                if(bet <= player.getChips()) {
                    betOkay = true;
                    player.makeBet(bet);
                }

            }
        }
    }

    public void displayCards(){
        System.out.println(String.format("DEALER'S HAND:"));
        System.out.println("   The " + dealer.getCards().get(0).getName());
        System.out.println("   The **** of ****.");
        for(Player player : this.players){
            System.out.println(String.format("%s's HAND:", player.getName()).toUpperCase());
            System.out.println("   The " + player.getCards().get(0).getName());
            System.out.println("   The " + player.getCards().get(1).getName());
        }
    }


    public void playRound(Player player){
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("It's your turn %s.", player.getName()));

        this.pressEnterToContinue();

        System.out.println("   The " + player.getCards().get(0).getName());

        boolean inPlay = true;

        while(inPlay == true){
            System.out.println("   The " + player.getCards().get(player.getCards().size() - 1).getName());
            System.out.println(String.format("Your hand total: %d", player.getTotal()));
            System.out.println("To take another card, type 'hit', to stand type 'stand'.");
            String move = scanner.nextLine();
            if(move.equalsIgnoreCase("hit")){
                this.playerHit(player);
            }else{
                this.playersInPlay.add(player);
                inPlay = false;
            }
            if(player.isBust() == true){
                System.out.println("BUST!  You're out for this round.");
                inPlay = false;
            }
        }
    }

    public void playDealerRound(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("It's the dealer's turn.  The dealer reveals their second card.");
        System.out.println("   The " + dealer.getCards().get(0).getName());

        boolean inPlay = true;

        while(inPlay == true){
            System.out.println("   The " + dealer.getCards().get(dealer.getCards().size() - 1).getName());
            System.out.println(String.format("The dealer's total is: %d", dealer.getTotal()));

            boolean hitStatus = dealer.hitStatus();

            this.pressEnterToContinue();

            if(hitStatus){
                System.out.println("The dealer hits.");
                this.dealerHit();
            }else{
                System.out.println("The dealer stands.");
                inPlay = false;
            }
            if(dealer.isBust()){
                System.out.println("BUST!  The dealer is out for this round.");
                inPlay = false;
            }

        }




    }

    public void playerHit(Player player){
        player.add(this.deck.remove());
    }

    public void dealerHit(){
        dealer.add(this.deck.remove());
    }


    public void pressEnterToContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue.");
        try{
        }catch(Exception e){
        }finally{
            String userInput = scanner.nextLine();
        }
    }


    public void payoutPlayers(){
        if(dealer.isBust()){
            System.out.println("The dealer has bust.");
            for(Player player : this.playersInPlay){
                player.addChips(player.getChipsInPlay() * 2);
                System.out.println(String.format("%s wins %d chips.", player.getName(), player.getChipsInPlay() * 2));
            }
        }else{
            for(Player player : this.playersInPlay){
                if(player.getTotal() > dealer.getTotal()){
                    player.addChips(player.getChipsInPlay() * 2);
                    System.out.println(String.format("%s beat the dealer and wins %d chips.", player.getName(), player.getChipsInPlay() * 2));
                }else if(player.getTotal() == dealer.getTotal()){
                    player.addChips(player.getChipsInPlay());
                    System.out.println(String.format("%s drew with the dealer and gets back %d chips.", player.getName(), player.getChipsInPlay()));
                }
            }
        }
    }

    public void resetPlayerChips(){
        for(Player player : this.players){
            player.resetChipsInPlay();
        }
    }

    public void displayLeaderBoard(){

    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        boolean inPlay = true;

        while(inPlay == true){
            this.startGame();
            this.dealCards();
            this.displayCards();

            for(Player player : this.players){
                this.playRound(player);
            }

            this.playDealerRound();

            this.pressEnterToContinue();

            this.payoutPlayers();
            this.resetPlayerChips();

            this.displayLeaderBoard();

            System.out.println("To play another round type 'yes'.  To exit, type 'exit'.");
            String playAgain = scanner.nextLine();

            if(playAgain.equalsIgnoreCase("exit")){
                System.out.println("Thanks for playing!");
                inPlay = false;
            }
        }
    }


}
