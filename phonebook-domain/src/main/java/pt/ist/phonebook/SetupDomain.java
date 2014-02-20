package pt.ist.phonebook;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;

import pt.ist.phonebook.domain.PhoneBook;
import pt.ist.phonebook.domain.Contact;
import pt.ist.phonebook.domain.Person;

/**
 * This class populates the database.
 */
public final class SetupDomain {

	/**
	 * A dummy private constructor.
	 */
	private SetupDomain() {
		// Never used
	}

	/**
	 * The main method. It performs the initialization and populates the database. 
	 * 
	 * @param args Not used in this case.
	 */
    public static void main(String[] args) {
		FenixFramework.initialize(new Config() {{
		    domainModelPath="src/main/dml/phonebook.dml";
	        dbAlias = "//localhost:3306/hellodb";
	        dbUsername = "hello";
	        dbPassword = "world";
		    rootClass=PhoneBook.class;
		    
		}});
		populateDomain();
    }
    
    /**
     * Populates the database.
     */
    @Atomic
    public static void populateDomain() {
    	PhoneBook pb = FenixFramework.getRoot();

    	Person person = new Person("Manel");
    	pb.addPerson(person);
    	person.addContact(new Contact("SOS", 112));
    	person.addContact(new Contact("IST", 214315112));
    }
}
