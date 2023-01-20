package com.bridgelabz.address_book;

import java.util.Scanner;

public class Contact {

	String fName, lName, address, city, state, email;
	int zip;
	long phNum;

	Scanner scanner = new Scanner(System.in);

	void getInputs() {
		
		System.out.print("Enter your first name: ");

		fName = scanner.nextLine();

		System.out.print("Enter your last name: ");
		lName = scanner.nextLine();

		System.out.print("Enter your address: ");
		address = scanner.nextLine();

		System.out.print("Enter your city: ");
		city = scanner.nextLine();

		System.out.print("Enter your state: ");
		state = scanner.nextLine();

		System.out.print("Enter your email: ");
		email = scanner.nextLine();

		System.out.print("Enter your area zip code: ");
		zip = scanner.nextInt();

		System.out.print("Enter your phone number: ");
		phNum = scanner.nextLong();

}  

	Contact[] addContact(Contact[] contacts, Contact obj) {

		Object contact ;
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i] == null) {
				contacts[i] = obj;
				break;
			}
		}
		int i;
		System.out.println("a new contact has been added :" ) ;
		return contacts;
	}
}
