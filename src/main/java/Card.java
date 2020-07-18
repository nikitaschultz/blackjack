public class Card {
    private SuitType suit;
    private RankType rank;

    public Card(SuitType suit, RankType rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public SuitType getSuit() {
        return suit;
    }

    public RankType getRank() {
        return rank;
    }

    public int getRankValue(){
        return rank.getValue();
    }

    public int getAlternativeRankValue(){
        return rank.getAlternativeValue();
    }
}
