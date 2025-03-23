
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 * @param <T>
 */
public class Pipe<T> {
    private final ArrayList<T> elements;

    public Pipe() {
        this.elements = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.elements.add(value);
    }
    
    public T takeFromPipe() {
        if (elements.isEmpty()) {
            return null;
        }
        return this.elements.remove(0);
    }
    
    public boolean isInPipe() {
        return !this.elements.isEmpty();
    }
}
