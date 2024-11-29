/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class OneItemBox extends Box {
    private Item item;

    public OneItemBox() {
        this.item = null;
    }
    
    @Override
    public void add(Item itm) {
        if (this.item == null) {
            this.item = itm;
        }
    }
    
    @Override
    public boolean isInBox(Item itm) {
        return this.item != null && this.item.equals(itm);
    }
}
