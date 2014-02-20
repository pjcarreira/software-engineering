package es.examples.flightmanager.exception;

/**
 * An exception stating that a given name already exists in the same context.
 * 
 * @author Eugenio Ribeiro
 */
public class NameAlreadyExistsException extends FlightManagerException {
	
	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The conflicting name.
	 */
	private final String name;
	
	/**
	 * Creates a new exception stating that a given name already exists.
	 * 
	 * @param name The conflicting name.
	 */
	public NameAlreadyExistsException(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the conflicting name.
	 * 
	 * @return The conflicting name.
	 */
	public String getName() {
		return name;
	}

}
