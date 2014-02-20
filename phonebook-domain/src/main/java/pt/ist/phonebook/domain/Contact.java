package pt.ist.phonebook.domain;

/**
 * A contact. It is composed by the name and phone number of the contact.  
 */
public class Contact extends Contact_Base {
    
	/**
	 * Creates a new contact.
	 * 
	 * @param name The name of the contact.
	 * @param phoneNumber The phone number of the contact.
	 */
    public Contact(String name, Integer phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }
    
}
