package es.examples.flightmanager.domain;

import es.examples.flightmanager.exception.DuplicateFlightException;
import es.examples.flightmanager.exception.IATAAlreadyExistsException;
import es.examples.flightmanager.exception.ICAOAlreadyExistsException;
import es.examples.flightmanager.exception.InvalidFlightException;
import es.examples.flightmanager.exception.NameAlreadyExistsException;
import es.examples.flightmanager.exception.UnknownAirportException;

/**
 * A flight manager with manages airports and airlines.
 */
public class FlightManager extends FlightManager_Base {
    
    /**
     * Creates a new flight manager.
     */
    public FlightManager() {
        super();
    }
    
    /**
     * Gets an airport by its IATA code.
     *
     * @param iata The IATA code.
     * @return The airport if it exists and null otherwise.
     */
    public Airport getAirportByIATA(String iata) {
    	for(Airport ap : getAirportSet()) {
    		if(ap.getIata().equals(iata))
    			return ap;
    	}
    	return null;
    }
    
    /**
     * Gets an airport by its ICAO code.
     *
     * @param icao The ICAO code
     * @return The airport if it exists and null otherwise.
     */
    public Airport getAirportByICAO(String icao) {
    	for(Airport ap : getAirportSet()) {
    		if(ap.getIcao().equals(icao))
    			return ap;
    	}
    	return null;
    }
    
    /**
     * Checks whether an airport with a given IATA code exists.
     *
     * @param iata The IATA code.
     * @return True if the airport exists and false otherwise.
     */
    public boolean hasAirportWithIATA(String iata) {
    	return getAirportByIATA(iata) != null;
    }
    
    /**
     * Checks whether an airport with a given ICAO code exists.
     *
     * @param icao The ICAO code.
     * @return True if the airport exists and false otherwise.
     */
    public boolean hasAirportWithICAO(String icao) {
    	return getAirportByICAO(icao) != null;
    }
    
    /**
     * Adds a new airport.
     * 
     * @param airport The airport.
     * @throws IATAAlreadyExistsException if an airport with the same IATA code already exists.
     * @throws ICAOAlreadyExistsException if an airport with the same ICAO code already exists.
     */
    @Override
    public void addAirport(Airport airport) throws IATAAlreadyExistsException, ICAOAlreadyExistsException {
    	if(hasAirportWithIATA(airport.getIata()))
    		throw new IATAAlreadyExistsException(airport.getIata());
    
    	else if(hasAirportWithICAO(airport.getIcao()))
    		throw new ICAOAlreadyExistsException(airport.getIcao());
    	
    	else super.addAirport(airport);   	
    }
    
    /**
     * Gets an airline by its name.
     *
     * @param name The name of the airline.
     * @return The airline if it exists and null otherwise.
     */
    public Airline getAirlineByName(String name) {
    	for(Airline fc : getAirlineSet()) {
    		if(fc.getName().equals(name))
    			return fc;
    	}
    	return null;
    }
    
    /**
     * Gets an airline by its IATA code.
     *
     * @param iata The IATA code.
     * @return The airline if it exists and null otherwise.
     */
    public Airline getAirlineByIATA(String iata) {
    	for(Airline fc : getAirlineSet()) {
    		if(fc.getIata().equals(iata))
    			return fc;
    	}
    	return null;
    }
    
    /**
     * Checks whether an airline with a given name exists.
     *
     * @param name The name of the airline.
     * @return True if the airline exists and false otherwise.
     */
    public boolean hasAirlineWithName(String name) {
    	return getAirlineByName(name) != null;
    }
    
    /**
     * Checks whether an airline with a given IATA code exists.
     *
     * @param iata The IATA code of the airline.
     * @return True if the airline exists and false otherwise.
     */
    public boolean hasAirlineWithIATA(String iata) {
    	return getAirlineByIATA(iata) != null;
    }
    
    /**
     * Adds a new airline.
     * 
     * @param airline The airline.
     * @throws NameAlreadyExistsException if an airline with the same name already exists.
     * @throws IATAAlreadyExistsException if an airline with the same IATA code already exists.
     */
    @Override
    public void addAirline(Airline airline) throws NameAlreadyExistsException, IATAAlreadyExistsException {
    	if(hasAirlineWithName(airline.getName()))
    		throw new NameAlreadyExistsException(airline.getName());
    
    	else if(hasAirlineWithIATA(airline.getIata()))
    		throw new IATAAlreadyExistsException(airline.getIata());
    	
    	else super.addAirline(airline);   	
    }
    
    /**
     * Adds a new flight to a given airline.
     * @param airline
     * @param flight
     * @throws DuplicateFlightException
     * @throws UnknownAirportException
     * @throws InvalidFlightException
     */
    public void addFlight(Airline airline, Flight flight)
    		throws DuplicateFlightException, UnknownAirportException, InvalidFlightException {
    	if(!hasAirport(flight.getOrigin()))
    		throw new UnknownAirportException(flight.getOrigin());
    	
    	else if(!hasAirport(flight.getDestination()))
    		throw new UnknownAirportException(flight.getDestination());
    	
    	else airline.addFlight(flight);
    }
    
}
