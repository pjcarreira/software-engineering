package es.examples.flightmanager.exception;

/**
 * An exception stating that a given ICAO code already exists in the same context.
 * 
 * @author Eugenio Ribeiro
 */
public class ICAOAlreadyExistsException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The conflicting ICAO code.
	 */
	private final String icao;
	
	/**
	 * Creates a new exception stating that a given ICAO code already exists.
	 * 
	 * @param icao The conflicting ICAO code.
	 */
	public ICAOAlreadyExistsException(String icao) {
		this.icao = icao;
	}
	
	/**
	 * Gets the conflicting ICAO code.
	 * 
	 * @return The conflicting ICAO code.
	 */
	public String getICAO() {
		return icao;
	}

}

