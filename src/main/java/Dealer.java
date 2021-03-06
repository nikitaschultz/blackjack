import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;

    public Dealer() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards(){
        return this.cards;
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

    public boolean hitStatus(){
        return this.getTotal() < 16;
    }

    public boolean isBust(){
        return this.getTotal() > 21;
    }

    public boolean hasBlackJack(){
        if(this.cards.size() == 2 && this.getTotal() == 21){
            return true;
        }
        return false;
    }
}
