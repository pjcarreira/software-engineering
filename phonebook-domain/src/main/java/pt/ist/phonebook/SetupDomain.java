package pt.ist.phonebook;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;

import pt.ist.phonebook.domain.PhoneBook;
import pt.ist.phonebook.domain.Contact;
import pt.ist.phonebook.domain.Person;

public class SetupDomain {

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
    
    @Atomic
    public static void populateDomain() {
	PhoneBook pb = FenixFramework.getRoot();

	Person person = new Person("Manel");
 	pb.addPerson(person);
	person.addContact(new Contact("SOS", 112));
	person.addContact(new Contact("IST", 214315112));
    }
}
