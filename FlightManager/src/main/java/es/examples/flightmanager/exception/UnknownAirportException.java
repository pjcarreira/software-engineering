package es.examples.flightmanager.exception;

import es.examples.flightmanager.domain.Airport;

/**
 * An exception stating that an airport is unknown.
 * 
 * @author Eugenio Ribeiro
 */
public class UnknownAirportException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The unknown airport.
	 */
	private final Airport airport;
	
	/**
	 * Creates a new exception stating that an airport is unknown.
	 * 
	 * @param airport The unknown airport.
	 */
	public UnknownAirportException(Airport airport) {
		this.airport = airport;
	}
	
	/**
	 * Gets the unknown airport.
	 * 
	 * @return The unknown airport.
	 */
	public Airport getAirport() {
		return airport;
	}

}
