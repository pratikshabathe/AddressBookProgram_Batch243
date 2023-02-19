package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	static Scanner sc = new Scanner(System.in);
	static HashMap<String,ArrayList<Contact>> addressBookList = new HashMap<>();// create an object of hashmap
	static ArrayList<Contact> currentAddressBook;// declare variable
	static String currentAddressBookName;//declare variable
	static HashMap<String, ArrayList<Contact>> cityContactList = new HashMap<>();
	static HashMap<String, ArrayList<Contact>> stateContactList = new HashMap<>();
	
	public Contact createContact(){
		 Contact person = new Contact();//creating object of ContactPerson class
		 System.out.print("Enter First Name: ");
		 person.setFirstName(sc.next());//using object reference calling setFirstName method to set first name
		 System.out.print("Enter Last Name: ");
		 person.setLastName(sc.next());
		 System.out.print("Enter Address: ");
		 person.setAddress(sc.next());
		 System.out.print("Enter City: ");
		 person.setCity(sc.next());
		 System.out.print("Enter State: ");
		 person.setState(sc.next());
		 System.out.print("Enter email: ");
		 person.setEmail(sc.next());
		 System.out.print("Enter ZipCode: ");
		 person.setZipCode(sc.nextInt());
		 System.out.print("Enter Phone Number: ");
		 person.setPhoneNumber(sc.nextLong());
		 System.out.println("created new contact");
		 return person;
		 }
	
		 /*
		 if duplicate contact found then display message as contact name already exists
		 Add new contacts to address book if there is no duplicate contact
		 */
		 void addContact(Contact person){
			 boolean isDuplicate = checkDuplicateContact(person);
			 if (isDuplicate) {
			 System.out.println("Contact name already exists");
			 } else {
			 currentAddressBook.add(person);
			 System.out.println("contact added to AddressBook " + currentAddressBookName);
			 System.out.println(person);
			 }
		 }
		
		 //check duplicate contact using their name
			boolean checkDuplicateContact(Contact newPerson) {
				return currentAddressBook.stream().anyMatch((person) -> person.getFirstName().equals(newPerson.getFirstName()));
			 }
			
			// Edit existing contact using person`s name
			// if contact found then edit otherwise no contact found message will be display
				 
			 public void editContact() {
				 boolean isContactFound = false;
				 System.out.println("Enter Name to edit Contact");
				 String name = sc.next();
		
				 for (Contact contactPerson : currentAddressBook) { //iterate over the arraylist
					 if (name.equalsIgnoreCase(contactPerson.getFirstName())) {
					 isContactFound = true;
					 System.out.print("Enter First Name :");
					 contactPerson.setFirstName(sc.next());
					 System.out.print("Enter Last Name :");
					 contactPerson.setLastName(sc.next());
					 System.out.print("Enter Address :");
					 contactPerson.setAddress(sc.next());
					 System.out.print("Enter City :");
					 contactPerson.setCity(sc.next());
					 System.out.print("Enter State :");
					 contactPerson.setState(sc.next());
					 System.out.print("Enter email :");
					 contactPerson.setEmail(sc.next());
					 System.out.print("Enter ZipCode :");
					 contactPerson.setZipCode(sc.nextInt());
					 System.out.print("Enter Phone Number :");
					 contactPerson.setPhoneNumber(sc.nextLong());
					 System.out.println(contactPerson);
					 break;
					 }
				 }	
				 if (isContactFound) {
					 System.out.println("Contact Updated Successfully..");
				 } else {
					 System.out.println("Oops...Contact not found");
				 }
				 }
		
			 //Delete contact using person`s name
			// if contact found then delete that contact
			// if no contact found then message will be display as oops....contact not found
			 
			 public void deleteContact(){
				 boolean isContactFound = false;
				 System.out.println("enter name to delete contact");
				 String name = sc.next();
				 for (Contact contactPerson : currentAddressBook){
					 if (contactPerson.getFirstName().equalsIgnoreCase(name)) {
						 System.out.println("contact found:");
						 isContactFound = true;
						 System.out.println(contactPerson);
						 System.out.println("confirm to delete (y/n)");
						 if (sc.next().equalsIgnoreCase("y")) {
							 currentAddressBook.remove(contactPerson);
							 System.out.println("contact deleted");
							 }
							 	break;
							 }
							 }
					if (!isContactFound) {
						System.out.println("Opps... contact not found");
					}
			 }
		
			 //add multiple address book
			 //each address book has unique name
			 void addNewAddressBook(){
				 System.out.println("Enter name for AddressBook: ");
				 String addressBookName = sc.next();
				 ArrayList <Contact> addressBook = new ArrayList();//creating object of arraylist
				 //using object reference of hashmap calling put method and passing key as addressBookName and value as addressBook
				 addressBookList.put(addressBookName,addressBook);
				 System.out.println("new AddressBook created");
				 currentAddressBook = addressBookList.get(addressBookName);//retrieve addressBookName using get method
				 currentAddressBookName = addressBookName;//addressBookName store in current addressBookName
				 }
				 //select address book
				 //if we want to add more contact in existing address book then select that address book
				 void selectAddressBook(){
					 System.out.println(addressBookList.keySet());
					 System.out.println("Enter name of address book:");
					 String addressBookName = sc.next();
					 
					 for (String key : addressBookList.keySet()) {
						 if (key.equalsIgnoreCase(addressBookName)){
						 currentAddressBook = addressBookList.get(key);
						 currentAddressBookName = key;
						 }
					 }
					 System.out.println("current AddressBook is: "+currentAddressBookName);
			 }
			// Display contact
			 void displayContact(ArrayList addressBook){
				 System.out.println("Contacts: ");
				 for (Object p : addressBook) {
					 Contact person = (Contact) p;
					 System.out.println(person);
					 }
			 }
			 //search contact by city and state
			 void searchContact() {
				 System.out.println("1.Search by City \n2.Search by State");
				 int option = sc.nextInt();
				 switch (option) {
					 case 1:
						 System.out.println("Enter city :");
						 searchByCity(sc.next());
						 break;
					 case 2:
						 System.out.println("Enter State :");
						 searchByState(sc.next());
						 break;
					 default:
						 searchContact();
						 break;
					 }
				 }
		
			 //search contact by city
			 void searchByCity(final String city) {
				 System.out.println("Search Result: ");
				 for (String addressBookName : addressBookList.keySet()) {//returns a set view of the keys contained in map
				 //forEach iterate through every element of the stream
					 addressBookList.get(addressBookName).stream().forEach((person) -> {
						 if (person.getCity().equalsIgnoreCase(city))
							 System.out.println(person);
							 //we will get contacts whose city is same
					 });
				 }
			 }
		
			 //search contact by state
			 void searchByState(String state) {
				 System.out.println("Search Result: ");
				 for (String addressBookName : addressBookList.keySet()) {//returns a set view of the keys contained in map
					 //forEach iterate through every element of the stream
					 addressBookList.get(addressBookName).stream().forEach((person) -> {
						 if (person.getState().equalsIgnoreCase(state))
						 System.out.println(person);
						 //we will get contacts whose state is same
				 });
				 }
			 }
				 
					//Initialize city and state
					    public void initializeCityAndStateContactList() {
					        for (String key : addressBookList.keySet()) {
					            for (Contact person : addressBookList.get(key)) {
					                String city = person.getCity();
					                if (cityContactList.containsKey(city)) {
					                    cityContactList.get(city).add(person);
					                } else {
					                    ArrayList<Contact> list = new ArrayList<>();
					                    list.add(person);
					                    cityContactList.put(city, list);
					                }

					                String state = person.getState();
					                if (stateContactList.containsKey(state)) {
					                    stateContactList.get(state).add(person);
					                } else {
					                    ArrayList<Contact> list = new ArrayList<>();
					                    list.add(person);
					                    stateContactList.put(state, list);
					                }
					            }
					        }
					    }

					    //view contacts
					    void viewContacts() {
					        initializeCityAndStateContactList();//calling method
					        System.out.println("1.View by City \n2.View by State");
					        switch (sc.nextInt()) {
					            case 1:
					                viewContactByCity();//calling method
					                break;
					            case 2:
					                viewContactByState();//calling method
					                break;
					            default:
					                viewContacts();//calling method
					                break;
					        }
					    }
	
					    //view contact by city
					    void viewContactByCity() {
					        System.out.println("Enter City:");
					        String city = sc.next();
					        for (String key : cityContactList.keySet()) {//returns a set view of the keys contained in map
					            if (key.equalsIgnoreCase(city)) {
					                cityContactList.get(key).stream().forEach(person -> System.out.println(person));
					            }
					        }
					    }

					    //view contact by state
					    void viewContactByState() {
					        System.out.println("Enter State:");
					        String state = sc.next();
					        for (String key : stateContactList.keySet()) {//returns a set view of the keys contained in map
					            if (key.equalsIgnoreCase(state)) {
					                stateContactList.get(state).stream().forEach(person -> System.out.println(person));
		       }
		 }
	 }
}
