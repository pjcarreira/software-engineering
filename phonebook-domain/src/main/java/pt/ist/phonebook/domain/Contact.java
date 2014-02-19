package pt.ist.phonebook.domain;

public class Contact extends Contact_Base {
    
    public Contact(String name, Integer phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }
    
}
