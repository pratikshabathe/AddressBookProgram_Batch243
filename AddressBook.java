package com.bridgelabz.address_book;

import java.util.Scanner;

public class AddressBook {
	
	String fName, lName, address, city, state, email;
	  int zip;
	  long phNum;

	  static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("--Welcom to address book program--");
		
		  AddressBook obj = new AddressBook();
		  obj.getInputs();
		  
		  System.out.println("What was entered :" +obj.fName + " " + obj.lName + " " + obj.address + " " +obj.city + " " + obj.state + " " + obj.email + " " +obj.zip + " " +obj.phNum);
		}
	
		  void getInputs() {
		    System.out.print("Enter your first name: ");
		    
			Object fName = scanner.nextLine();

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
}