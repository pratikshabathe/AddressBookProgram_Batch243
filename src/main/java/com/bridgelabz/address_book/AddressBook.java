package com.bridgelabz.address_book;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> addressBook = new ArrayList<Contact>();

     // Adding Contacts using addContact method in the arraylist of address book and checking duplicates entry
    public void addContact(Contact person) {

        boolean isDuplicate = duplicateEntry(person.getFirstName(), person);

        if (!isDuplicate) {
            addressBook.add(person);
        } else {
            System.out.println("Person name is duplicate");
        }
    }

    public boolean duplicateEntry(String firstname, Contact contacts) {
     // Checking duplicate entry in address book using for-each loop if person firstname matches with
     // the existing person first name in the address book means it is duplicate entry and return true else false
        for (Contact person1 : this.addressBook) {

            if (person1.getFirstName().equals(firstname)) {
                return true;
            }
        }
        return false;
    }
         //Printing method to print all the contacts in the list using for each loop
         
    public void printAddressBook() {

        for (Contact person : this.addressBook) {
            System.out.println("First name = " + person.getFirstName());
            System.out.println("last name = " + person.getLastName());
            System.out.println("address = " + person.getAddress());
            System.out.println("city = " + person.getCity());
            System.out.println("state = " + person.getState());
            System.out.println("zip = " + person.getZip());
            System.out.println("phone number = " + person.getPhoneNumber());
        }
	 }
}
