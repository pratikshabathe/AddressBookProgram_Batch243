package com.bridgelabz.address_book;

import java.util.Scanner;

public class AddressBook {
	
	public static void main(String[] args) {

		System.out.println("--Welcom to address book program--");
		Scanner sc = new Scanner(System.in);
		Contact[] contacts = new Contact[25];
		String choice = "add";
		choice = sc.next();
 
		while(!choice.equals("quit")) {

			System.out.println("\n1.add \n2. edit \n3. quit \nEnter your choice : ");
			choice = sc.next();
 
			switch (choice) {
			case "add" :
			case "1":
				Contact obj = new Contact();
				obj.getInputs();
				System.out.println("Here's What been added :" +obj.fName + " "  +obj.lName + " " + obj.address +" " + obj.city+ " " +obj.state +" " +obj.email +" " +obj.zip + " " +obj.phNum);
 
				contacts = obj.addContact(contacts, obj);
				break;
			
			case "edit":
			case "2" :
				obj = new Contact();
				contacts = obj.editContact(contacts);
				break;
				
			case "quit":
			case "3":
				choice = "quit";
				break;

			default:
				System.out.println("that didnt match any choice, try again");
				break;
			}
		}
	}

}