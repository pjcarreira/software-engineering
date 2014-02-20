package es.examples.flightmanager.domain;

import org.joda.time.LocalTime;

/**
 * A flight which is identified by an id. It has an origin, a destination, and a time.
 * 
 * @author Eugenio Ribeiro
 */
public class Flight extends Flight_Base {
    
	/**
	 * Creates a new flight.
	 * 
	 * @param id The id of the flight.
	 * @param origin The origin airport of the flight.
	 * @param destination The destination airport of the flight.
	 * @param time The time of the flight.
	 */
    public Flight(int id, Airport origin, Airport destination, LocalTime time) {
        this.setId(id);
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setTime(time);
    }
    
}
