
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class Box implements Packable {
    private ArrayList<Packable> contents;
    private double maxWeight;

    public Box(double maxWeight) {
        this.contents = new ArrayList<>();
        this.maxWeight = maxWeight;
    }
    
    public double weight() {
        double total = 0;
        for (Packable packable : this.contents) {
            total = total + packable.weight();
        }
        return total;
    }
    
    public void add(Packable item) {
        if (item.weight() + this.weight() <= this.maxWeight) {
            this.contents.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + this.contents.size() + " items, total weight " + this.weight() + " kg";
    }
    
    
}
