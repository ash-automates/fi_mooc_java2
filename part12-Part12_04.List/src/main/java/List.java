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
public class List<T> {
    private T[] values;
    private int pointer;

    public List() {
        this.values = (T[]) new Object[10];
        this.pointer = 0;
    }
    
    public void add(T value) {
        // resize internal array once all indexes are used
        if (this.values.length == this.pointer) {
            this.grow();
        }
        this.values[pointer] = value;
        this.pointer += 1;
    }
    
    // Automatic re-sizing once the internal array grows too large
    private void grow() {
        T[] newArray = (T[]) new Object[this.values.length + (this.values.length / 2)];
        System.arraycopy(this.values, 0, newArray, 0, this.values.length);
        this.values = newArray;
    }
    
    // List lookup to verify if element exists or not
    public boolean contains(T value) {
        return this.idxOfValue(value) >= 0;
    }
    
    // Delegate finding index to external method idxOfValue(T value)
    // Turned public as user might benefit from value(idxOfValue(idx))
    public int idxOfValue(T value) {
        for (int i = 0; i < this.pointer; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    // Remove element from list without leaving null values in between elements
    public void remove(T value) {
        boolean found = this.contains(value);
        if (found) {            
            this.shiftLeftFromIdx(this.idxOfValue(value));
            this.pointer -= 1;
        }
    }
    
    private void shiftLeftFromIdx(int idx) {
        for (int i = idx; i < (this.pointer - 1); i++) {
            this.values[i] = this.values[i + 1];
        }
    }
    
    // get value given index
    public T value(int idx) {
        if (idx < 0 || idx >= this.pointer) {
            System.out.println("Error: index is out of bounds, or the list is currently empty!");
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.values[idx];
    }
    
    public int size() {
        return this.pointer;
    }
}
