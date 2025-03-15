/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author hachem
 */
public class Flight {
    private final Airplane airplane;
    private final Place departure;
    private final Place destination;

    public Flight(Airplane airplane, Place departure, Place destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getDestination() {
        return destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departure + "-" + this.destination + ")";
    }
    
    
}
