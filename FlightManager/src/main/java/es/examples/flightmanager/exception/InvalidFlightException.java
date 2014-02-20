package es.examples.flightmanager.exception;

import es.examples.flightmanager.domain.Flight;

/**
 * An exception stating that a flight is invalid.
 * 
 * @author Eugenio Ribeiro
 */
public class InvalidFlightException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The invalid flight.
	 */
	private final Flight flight;
	
	/**
	 * Creates a new exception stating that a flight is invalid.
	 * 
	 * @param flight The invalid flight.
	 */
	public InvalidFlightException(Flight flight) {
		this.flight = flight;
	}
	
	/**
	 * Gets the invalid flight.
	 * 
	 * @return The invalid flight.
	 */
	public Flight getFlight() {
		return flight;
	}

}
