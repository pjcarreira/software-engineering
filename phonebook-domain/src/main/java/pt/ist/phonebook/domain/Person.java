package pt.ist.phonebook.domain;

import java.util.ArrayList;
import java.util.List;

import pt.ist.phonebook.exception.ContactDoesNotExistException;
import pt.ist.phonebook.exception.NameAlreadyExistsException;

/**
 * A person which as a name and a list of contacts. 
 */
public class Person extends Person_Base {
    
	/**
	 * Creates a new person with an empty contact list.
	 * 
	 * @param name The name of the person.
	 */
    public Person(String name) {
        super();
        setName(name);
    }    	      
    
    /**
     * Gets a contact by name.
     * 
     * @param name The name of the contact.
     * @return The contact if it exists and null otherwise.
     */
    private Contact getContactByName(String name) {
		for(Contact contact : getContactSet()) {
		    if(contact.getName().equals(name))
		    	return contact;
		}
		return null;
    }
    
    /**
     * Checks whether a given name is on the contact list.
     * 
     * @param contactName The name to look for.
     * @return True if the contact exists and false otherwise.
     */
    public boolean hasContact(String contactName) {
    	return getContactByName(contactName) != null;
    }
    
    /**
     * Adds a new contact to the list.
     * 
     * @param contactToBeAdded The contact.
     * @throws NameAlreadyExistsException if the name is already on the list.
     */
    @Override
    public void addContact(Contact contactToBeAdded) throws NameAlreadyExistsException {
    	if (hasContact(contactToBeAdded.getName()))
    		throw new NameAlreadyExistsException(contactToBeAdded.getName());
	
    	super.addContact(contactToBeAdded);
    }
    
    /**
     * Removes a contact from the list.
     * 
     * @param contactName The name of the contact.
     * @throws ContactDoesNotExistException if the contact does not exist.
     */
    public void removeContact(String contactName) throws ContactDoesNotExistException {
    	Contact toRemove = getContactByName(contactName);
    	if (toRemove == null)
    		throw new ContactDoesNotExistException(contactName);
	
    	super.removeContact(toRemove);
    }

    /**
     * Gets the contacts with name containing a given string.
     *   
     * @param token The string to look for.
     * @return A list of contacts with name containing the string.
     */
    public List<Contact> searchContact(String token) {
    	List<Contact> matchingContacts = new ArrayList<Contact>();

    	for(Contact existingContact : this.getContactSet()) {
    		if(existingContact.getName().contains(token))
    			matchingContacts.add(existingContact);
    	}

    	return matchingContacts;
    }
}
