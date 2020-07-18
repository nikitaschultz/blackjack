import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;

    public Dealer() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards(){
        return this.cards;
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

    public boolean hitStatus(){
        return this.getTotal() < 16;
    }
}
