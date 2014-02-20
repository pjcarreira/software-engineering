package es.examples.flightmanager.exception;

/**
 * An exception stating that a given IATA code already exists in the same context.
 * 
 * @author Eugenio Ribeiro
 */
public class IATAAlreadyExistsException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The conflicting IATA code.
	 */
	private final String iata;
	
	/**
	 * Creates a new exception stating that a given IATA code already exists.
	 * 
	 * @param iata The conflicting IATA code.
	 */
	public IATAAlreadyExistsException(String iata) {
		this.iata = iata;
	}
	
	/**
	 * Gets the conflicting IATA code.
	 * 
	 * @return The conflicting IATA code.
	 */
	public String getIATA() {
		return iata;
	}

}
