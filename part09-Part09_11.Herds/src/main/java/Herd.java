
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
public class Herd implements Movable {
    private ArrayList<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable member : this.herd) {
            member.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Movable member : this.herd) {
            str += member.toString() + "\n";
        }
        return str;
    }    
}
