/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hachem
 */
public class AverageSensor implements Sensor {
    private final List<Sensor> sensors;
    private final List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
        
    @Override
    public boolean isOn() {
        return sensors.stream().noneMatch((sensor) -> (!sensor.isOn()));
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.stream().forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        int reading = (int) sensors.stream().mapToDouble(Sensor::read).average().getAsDouble();
        this.readings.add(reading);
        return reading;
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
}
