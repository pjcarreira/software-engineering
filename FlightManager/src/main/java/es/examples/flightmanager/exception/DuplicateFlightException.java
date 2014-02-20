package es.examples.flightmanager.exception;

/**
 * An exception stating that a given flight already exists.
 * 
 * @author Eugenio Ribeiro
 */
public class DuplicateFlightException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The name of the airline.
	 */
	private final String airlineName;
	
	/**
	 * The id of the conflicting flight.
	 */
	private final int id;
	
	/**
	 * Creates a new exception stating that a given flight already exists.
	 * 
	 * @param airlineName The name of the airline.
	 * @param id The conflicting flight id.
	 */
	public DuplicateFlightException(String airlineName, int id) {
		this.airlineName = airlineName;
		this.id = id;
	}
	
	/**
	 * Gets the name of the airline.
	 * 
	 * @return The name of the airline.
	 */
	public String getAirlineName() {
		return airlineName;
	}
	
	/**
	 * Gets the id of the conflicting flight.
	 * 
	 * @return The id of the flight.
	 */
	public int getID() {
		return id;
	}

}
