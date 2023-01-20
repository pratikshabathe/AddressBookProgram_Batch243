package com.bridgelabz.address_book;

import java.util.Scanner;

public class AddressBook {
	
	public static void main(String[] args) {

		System.out.println("--Welcom to address book program--");
		Scanner scanner = new Scanner(System.in);
		Contact[] contacts = new Contact[25];
		String choice = "add";
		choice = scanner.next();
 
		while(!choice.equals("quit")) {

			System.out.println("\n1.add \n2. quit \nEnter your choice : ");
			choice = scanner.next();
 
			switch (choice) {
			case "add" :
			case "1":
				Contact obj = new Contact();
				obj.getInputs();
				System.out.println("What was entered :" +obj.fName + " "  +obj.lName + " " + obj.address +" " + obj.city+ " " +obj.state +" " +obj.email +" " +obj.zip + " " +obj.phNum);
 
				contacts = obj.addContact(contacts, obj);
				break;

			case "quit":
			case "2":
				choice = "quit";
				break;

			default:
				System.out.println("that didnt match any choice, try again");
				break;
			}
		}
	}

}