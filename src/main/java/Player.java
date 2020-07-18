import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
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
}
