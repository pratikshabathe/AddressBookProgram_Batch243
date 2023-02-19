package com.bridgelabz.address_book;

import java.util.Scanner;

public class Main {

	public static Contact inpute(Scanner scanner) {
		
		System.out.println("Add details of a person");
	    System.out.println("Please provide first name");
	    String firstName = scanner.next();
	    System.out.println("Please provide Last name");
	    String lastName = scanner.next();
	    System.out.println("Please provide address");
	    String address = scanner.next();
	    System.out.println("Please provide city");
	    String city = scanner.next();
	    System.out.println("Please provide state");
	    String state = scanner.next();
	    System.out.println("Please provide zip");
	    int zip = scanner.nextInt();
	    System.out.println("Please provide phone number");
	    String phoneNumber = scanner.next();
	    Contact person = new Contact(firstName, lastName, address, city, state, zip, phoneNumber);
	    return person;
		}
		
		public static void main(String[] args) {
			    Scanner sc = new Scanner(System.in);
			 //Adding Contacts details using Constructor of person class
			 
			    Contact person1 = new Contact("pranali", "sathe", "Nandura", "Buldhana", "Maharashtra", 425411, "8380867601");
			    Contact person2 = new Contact("prathana", "kate", "Nandura", "Buldhana", "Maharashtra", 425411, "8380867602");
			
			 // Adding contacts to different address books by using addContact method means every single address book
			 // has multiple contacts
			    AddressBook addressBook = new AddressBook();
			    addressBook.addContact(person1);
			    addressBook.addContact(person2);
			    System.out.println("Address book before adding new contact is: ");
			    addressBook.printAddressBook();
			
			    System.out.println("Checking duplicate entry before adding new contact");
			    addressBook.addContact(inpute(sc));
			    addressBook.printAddressBook();
		
}
}
