import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private int chips;
    private int chipsInPlay;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.chips = 0;
        this.chipsInPlay = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void resetCards(){
        this.cards = new ArrayList<Card>();
    }

    public void add(Card card){
        this.cards.add(card);
    }

    public int getTotal(){
        int total = 0;
        for(Card card : this.cards){
            total += card.getRankValue();
        }
        if(total > 21){
            total = 0;
            for(Card card : this.cards){
                total += card.getAlternativeRankValue();
            }
        }
        return total;
    }

    public boolean isBust(){
        return this.getTotal() > 21;
    }

    public int getChips(){
        return this.chips;
    }

    public int getChipsInPlay(){
        return this.chipsInPlay;
    }

    public void addChips(int numberOfChips){
        this.chips += numberOfChips;
    }

    public void makeBet(int bet){
        this.chips -= bet;
        this.chipsInPlay += bet;
    }

    public void resetChipsInPlay(){
        this.chipsInPlay = 0;
    }

    public boolean hasBlackJack(){
        if(this.cards.size() == 2 && this.getTotal() == 21){
            return true;
        }
        return false;
    }
}
