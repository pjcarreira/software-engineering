package pt.ist.phonebook.domain;

import java.util.ArrayList;
import java.util.List;

import pt.ist.phonebook.exception.PersonDoesNotExistException;
import pt.ist.phonebook.exception.NameAlreadyExistsException;

public class PhoneBook extends PhoneBook_Base {
    
    public  PhoneBook() {
        super();
    }    	      
    
    private Person getPersonByName(String name) {
	for(Person person : getPersonSet()) {
	    if(person.getName().equals(name)) {
		return person;
	    }
	}
	return null;
    }
    
    public boolean hasPerson(String personName) {
	return getPersonByName(personName) != null;
    }
    
    @Override
    public void addPerson(Person personToBeAdded) throws NameAlreadyExistsException {
	if (hasPerson(personToBeAdded.getName()))
	    throw new NameAlreadyExistsException(personToBeAdded.getName());
	
	super.addPerson(personToBeAdded);
    }
    
    public void removePerson(String personName) throws PersonDoesNotExistException {
    	Person toRemove = getPersonByName(personName);
    	if (toRemove == null)
	    throw new PersonDoesNotExistException(personName);
	
    	super.removePerson(toRemove);
    }

    public List<Person> searchPerson(String token) {
	List<Person> matchingPersons = new ArrayList<Person>();

	for(Person existingPerson : this.getPersonSet()) {
	    if(existingPerson.getName().contains(token)) {
		matchingPersons.add(existingPerson);
	    }
	}

	return matchingPersons;
    }
}
