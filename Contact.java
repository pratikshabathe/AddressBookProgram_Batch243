package com.bridgelabz.address_book;

import java.util.Scanner;

public class Contact {

	String fName, lName, address, city, state, email;
	int zip;
	long phNum;

	Scanner sc = new Scanner(System.in);

	void getInputs() {
		System.out.print("Enter your first name: ");
		fName = sc.nextLine();

		System.out.print("Enter your last name: ");
		lName = sc.nextLine();

		System.out.print("Enter your address: ");
		address = sc.nextLine();

		System.out.print("Enter your city: ");
		city = sc.nextLine();

		System.out.print("Enter your state: ");
		state = sc.nextLine();

		System.out.print("Enter your email: ");
		email = sc.nextLine();

		System.out.print("Enter your area zip code: ");
		zip = sc.nextInt();

		System.out.print("Enter your phone number: ");
		phNum = sc.nextLong();

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
	
	Contact[] editContact(Contact[] contacts) {
		if(contacts[0] == null) {
			System.out.println("you have no contacts yet. 'add' one before you edit. \n");
		return contacts;
		}else {
			System.out.print("your contacts are :");
			for(Contact obj : contacts) {
				if(obj != null) System.out.println(obj.fName + ", ");
				else break;
			}
			System.out.println();
			
			System.out.println("\n Enter a name to edit. mind the case ");
			String name = sc.nextLine();
			
			short index = checkContact(contacts, name);
			
			if(index == -1) System.out.println("we couldn't fined" + name + ". try again ");
			else {
				System.out.println("\n* " + name + "is beging edited *");
				Contact obj2 = new Contact();
				obj2.getInputs();
		        contacts[index] = obj2;

		        System.out.println("contact has been updated.");
		      }

		      return contacts;
		    }
		  }

		  short checkContact(Contact[] contacts, String name) {
		    short found = -1;
		    for (short i = 0; i < contacts.length; i++) {
		      if (contacts[i] != null && contacts[i].fName.equals(name)) {
		        found = i;
		        break;
		      }
		    }

		    return found;
		  }
}
