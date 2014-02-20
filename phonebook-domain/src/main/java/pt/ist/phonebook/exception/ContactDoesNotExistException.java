package pt.ist.phonebook.exception;

/**
 * An exception stating that a contact does not exist.
 */
public class ContactDoesNotExistException extends PhoneBookException {

	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The name of the inexistent contact.
	 */
	private final String contactName;

	/**
	 * Creates a new exception stating that a given contact does not exist.
	 * 
	 * @param contactName The name of the contact.
	 */
	public ContactDoesNotExistException(String contactName) {
		this.contactName = contactName;
	}
	
	/**
	 * Gets the name of the inexistent contact.
	 * 
	 * @return The name of the contact.
	 */
	public String getContactName() {
		return this.contactName;
	}
}
