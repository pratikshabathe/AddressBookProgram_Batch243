package com.bridgelabz.address_book;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("Welcome to Address Book program");   //display welcome message
        AddressBook addressBook = new AddressBook();    //creating object of address book
        Scanner sc = new Scanner(System.in);      //create an object of scanner class
        boolean flag1 = true;
        while (flag1) {
            System.out.println("addressBook.addressBookList.keySet()");
            System.out.println("current AddressBook Name: "+addressBook.currentAddressBookName);
            System.out.println("Select Option :\n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Display contact\n5.Add New Address Book\n6.Select Address Book\n7.Search contact\n8.show contact count \n9. sort contact \n10.Write data \n11. Read data \n12.Exit");
            int option = sc.nextInt();
            switch (option) { //select option
                case 1:
                    Contact contactPerson = addressBook.createContact();
                    addressBook.addContact(contactPerson);
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                    addressBook.deleteContact();
                    break;
                case 4:
                    addressBook.viewContacts();
                    break;
                case 5:
                    addressBook.addNewAddressBook();
                    break;
                case 6:
                    addressBook.selectAddressBook();
                    break;
                case 7:
                	addressBook.searchContact();
                	break;
                case 8:
                	addressBook.showContactCount();
                	break;
                case 9:
                    addressBook.sortContact();
                    break;
                case 10:
                	addressBook.writeData();
                	break;
                case 11:
                	addressBook.readData();
                	break;
                case 12:
                    flag1 = false;
                    break;
                default:
                    System.out.println(option + " is not valid option");
                    break;
            }
        }
	}
}
