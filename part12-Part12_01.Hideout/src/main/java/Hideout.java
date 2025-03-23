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
public class Hideout<T> {
    private T element;
    
    public void putIntoHideout(T toHide) {
        this.element = toHide;
    }
    
    public T takeFromHideout() {
        if (this.element == null) {
            return null;
        }
        T taken = this.element;
        this.element = null;
        return taken;
    }
    
    public boolean isInHideout() {
        return this.element != null;
    }
}
