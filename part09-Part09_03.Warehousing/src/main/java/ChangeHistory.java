
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
public class ChangeHistory {
    private ArrayList<Double> statuses;

    public ChangeHistory() {
        this.statuses = new ArrayList<>();
    }
    
    public void add(double status) {
        statuses.add(status);
    }
    
    public void clear() {
        statuses.clear();
    }

    @Override
    public String toString() {
        return statuses.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double maxValue() {
        if (!this.statuses.isEmpty()) {
            return Collections.max(statuses);
        }
        return 0;
    }
    
    public double minValue() {
        if (!this.statuses.isEmpty()) {
            return Collections.min(statuses);
        }
        return 0;
    }
    
    public double average() {
        if (!this.statuses.isEmpty()) {
            return (this.statuses.stream().mapToDouble(Double::doubleValue).sum() / this.statuses.size());
        }
        return 0;
    }
}
