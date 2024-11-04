/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class Container {
    private int content;

    public Container() {
        this.content = 0;
    }

    public int contains() {
        return content;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.content = this.content + amount <= 100 ? this.content + amount : 100;
        }
    }
    
    public void remove(int amount) {
        if (amount > 0) {
            this.content = this.content - amount >= 0 ? this.content - amount : 0;
        }    
    }
    
    public void move(Container dest, int amount) {
        if (amount > 0) {
            amount = dest.content + amount > 100 ? 100 - dest.content : amount;
            if (amount <= this.content) {
                dest.content = dest.content + amount;
                this.content = this.content - amount;
            } else {
                dest.content = dest.content + this.content;
                this.content = 0;
            }
        }
    }
    
    public String toString() {
        return this.content + "/100";
    }
}