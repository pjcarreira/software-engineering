package pt.ist.phonebook.domain;

import java.util.ArrayList;
import java.util.List;

import pt.ist.phonebook.exception.PersonDoesNotExistException;
import pt.ist.phonebook.exception.NameAlreadyExistsException;

/**
 * A phone book which contains people.
 */
public class PhoneBook extends PhoneBook_Base {
    
	/**
	 * Creates a new phone book.
	 */
    public PhoneBook() {
        super();
    }    	      
    
    /**
     * Gets a person by name.
     * 
     * @param name The name of the person.
     * @return The person.
     */
    private Person getPersonByName(String name) {
		for(Person person : getPersonSet()) {
		    if(person.getName().equals(name))
		    	return person;
		}
		return null;
	}
    
    /**
     * Checks whether the phone book has a given person.
     * 
     * @param personName The name of the person.
     * @return True if the person exists and false otherwise.
     */
    public boolean hasPerson(String personName) {
    	return getPersonByName(personName) != null;
    }
    
    /**
     * Adds a new person to the phone book.
     * 
     * @param personToBeAdded The person.
     * @throws NameAlreadyExistsException if the phone book already contains a person with the same name.
     */
    @Override
    public void addPerson(Person personToBeAdded) throws NameAlreadyExistsException {
		if (hasPerson(personToBeAdded.getName()))
		    throw new NameAlreadyExistsException(personToBeAdded.getName());
		
		super.addPerson(personToBeAdded);
    }
    
    /**
     * Removes a given person from the phone book.
     * 
     * @param personName The name of the person.
     * @throws PersonDoesNotExistException if the phone book does not contain the person.
     */
    public void removePerson(String personName) throws PersonDoesNotExistException {
    	Person toRemove = getPersonByName(personName);
    	if (toRemove == null)
    		throw new PersonDoesNotExistException(personName);
	
    	super.removePerson(toRemove);
    }

    /**
     * Finds people whose name contains a given string.
     * 
     * @param token The string to look for.
     * @return The list of people whose name contains the string.
     */
    public List<Person> searchPerson(String token) {
		List<Person> matchingPersons = new ArrayList<Person>();
	
		for(Person existingPerson : this.getPersonSet()) {
		    if(existingPerson.getName().contains(token))
		    	matchingPersons.add(existingPerson);
		}
	
		return matchingPersons;
    }
}
