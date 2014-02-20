package pt.ist.phonebook.exception;

/**
 * An exception stating that a name already exists on a contact list.
 */
public class NameAlreadyExistsException extends PhoneBookException {

	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The conflicting name.
	 */
	private final String conflictingName;
	
	/**
	 * Creates a new exception stating that a given name already exists.
	 * 
	 * @param conflictingName The conflicting name.
	 */
	public NameAlreadyExistsException(String conflictingName) {
		this.conflictingName = conflictingName;
	}
	
	/**
	 * Gets the conflicting name.
	 * 
	 * @return The conflicting name.
	 */
	public String getConflictingName() {
		return this.conflictingName;
	}
	
}
