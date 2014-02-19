package pt.ist.phonebook;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.pstm.Transaction;

import pt.ist.phonebook.domain.PhoneBook;
import pt.ist.phonebook.domain.Contact;
import pt.ist.phonebook.domain.Person;


public class PhoneBookApplication {

    public static void main(String[] args) {
    	FenixFramework.initialize(new Config() {{
                dbAlias = "//localhost:3306/hellodb"; 
                dbUsername = "hello";
                dbPassword = "world";
    		domainModelPath="src/main/dml/phonebook.dml";
    		rootClass=PhoneBook.class;
    	}});

    	System.out.println("Welcome to the PhoneBook application!");

    	boolean committed = false;

    	try {
    		Transaction.begin();

    		PhoneBook pb = FenixFramework.getRoot();
		
		for (Person person : pb.getPersonSet()) {
			System.out.println("The Contact book of " + person.getName() + " :");
    			for(Contact contact : person.getContactSet()) {
    				System.out.println("Name: " + contact.getName() + " phone: " + contact.getPhoneNumber());
    			}
		}
    		Transaction.commit();
    		committed = true;
    	} finally {
    		if (!committed)
    			Transaction.abort();
    	}
    }
}
