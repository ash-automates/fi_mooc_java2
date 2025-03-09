 
import java.util.ArrayList;
import java.util.Collections;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author hachem
 */
public class Hand implements Comparable<Hand>{
    private final ArrayList<Card> cards;
 
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        cards.forEach((card) -> {
            System.out.println(card);
        });
    }
    
    public void sort() {
        Collections.sort(cards);
    }

    @Override
    public int compareTo(Hand o) {
        int score = this.cards.stream().mapToInt(Card::getValue).sum();
        int compared = o.cards.stream().mapToInt(Card::getValue).sum();
        return score - compared;
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
 
