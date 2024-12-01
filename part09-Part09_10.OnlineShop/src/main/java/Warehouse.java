
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.products = new HashMap<>();
        this.stocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product) {
        return products.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return stocks.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (this.stock(product) != 0) {
           stocks.put(product, this.stock(product) - 1);
           return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return this.stocks.keySet();
    }
}
