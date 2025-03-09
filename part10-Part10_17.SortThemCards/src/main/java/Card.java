 
 
public class Card implements Comparable<Card> {
 
    private int value;
    private Suit suit;
 
    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }
 
        this.value = value;
        this.suit = suit;
    }
 
    @Override
    public String toString() {
        String cardValue = "" + value;
        switch (value) {
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            case 14:
                cardValue = "A";
                break;
            default:
                break;
        }
        
        return suit + " " + cardValue;
    }
 
    public int getValue() {
        return value;
    }
 
    public Suit getSuit() {
        return suit;
    }
 
    @Override
    public int compareTo(Card t) {
        if (t.getValue() == this.getValue()) {
            return this.getSuit().ordinal() - t.getSuit().ordinal();
        } else {
            return this.getValue() - t.getValue();
        }
    }
 
    
}

