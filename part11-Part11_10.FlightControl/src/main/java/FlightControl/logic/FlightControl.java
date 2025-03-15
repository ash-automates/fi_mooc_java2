/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author hachem
 */
public class FlightControl {
    private final HashMap<String, Airplane> planes;
    private final HashMap<String, Flight> flights;
    private final HashMap<String, Place> airports;

    public FlightControl() {
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
        this.planes = new HashMap<>();
    }
    
    public void addPlane(String id, int capacity) {
        this.planes.put(id, new Airplane(id, capacity));
    }
    
    public void addFlight(String departureID, String destinationID, Airplane plane) {
        this.airports.putIfAbsent(departureID, new Place(departureID));
        this.airports.putIfAbsent(destinationID, new Place(destinationID));
        Place departure = this.airports.get(departureID);
        Place destination = this.airports.get(destinationID);
        Flight flight = new Flight(plane, departure, destination);
        this.flights.put(flight.toString(), flight);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Airplane getPlane(String id) {
        return this.planes.get(id);
    }

    public Collection<Airplane> getPlanes() {
        return planes.values();
    }

    public Collection<Flight> getFlights() {
        return flights.values();
    }
}
