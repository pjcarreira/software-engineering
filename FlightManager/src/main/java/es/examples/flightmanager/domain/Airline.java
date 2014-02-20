package es.examples.flightmanager.domain;

import es.examples.flightmanager.exception.DuplicateFlightException;
import es.examples.flightmanager.exception.InvalidFlightException;

/**
 * An airline is identified both by a name and a IATA code.
 * It is responsible for a set of flights.
 * 
 * @author Eugenio Ribeiro
 */
public class Airline extends Airline_Base {
    
	/**
	 * Creates a new airline.
	 * 
	 * @param name The name of the airline.
	 * @param iata The IATA code of the airline.
	 */
    public Airline(String name, String iata) {
        this.setName(name);
        this.setIata(iata);
    }
    
    /**
     * Gets a flight by its id.
     * 
     * @param id The id of the flight.
     * @return The flight if it exists and null otherwise.
     */
    public Flight getFlightByID(int id) {
    	for(Flight f : getFlightSet()) {
    		if(f.getId() == id)
    			return f;
    	}
    	return null;
    }
    
    /**
     * Checks whether the airline has a flight with the given id.
     * 
     * @param id The id of the flight.
     * @return True if the flight exists and false otherwise.
     */
    public boolean hasFlight(int id) {
    	return getFlightByID(id) != null;
    }
    
    /**
     * Adds a flight to the set controlled by the airline.
     * 
     * @param flight The flight.
     * @throws DuplicateFlightException if a flight with the same id already exists.
     */
    @Override
    public void addFlight(Flight flight) throws DuplicateFlightException {
    	if(hasFlight(flight.getId()))
    		throw new DuplicateFlightException(this.getName(), flight.getId());
    	
    	if(flight.getOrigin().getIata().equals(flight.getDestination().getIata()))
    		throw new InvalidFlightException(flight);
    	
    	else super.addFlight(flight);
    }
    
}
