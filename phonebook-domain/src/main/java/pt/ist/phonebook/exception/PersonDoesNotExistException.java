package pt.ist.phonebook.exception;

/**
 * An exception stating that a given person does not exist in the phone book.
 */
public class PersonDoesNotExistException extends PhoneBookException {

	/**
	 * An identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The name of the inexistent person.
	 */
	private final String personName;

	/**
	 * Creates a new exception stating that the phone book does not contain a given person.
	 * 
	 * @param personName The name of the person.
	 */
	public PersonDoesNotExistException(String personName) {
		this.personName = personName;
	}
	
	/**
	 * Gets the name of the inexistent person.
	 * 
	 * @return The name of the person.
	 */
	public String getPersonName() {
		return this.personName;
	}
}
