package com.bridgelabz.main;
import java.util.Scanner;

public class AddressBook {
	Contacts contact = new Contacts();
	Scanner sc = new Scanner(System.in);
	public void add() {		
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last Name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter your address: ");
		String address = sc.nextLine();
		System.out.println("Enter your city: ");
		String city = sc.nextLine();
		System.out.println("Enter your state: ");
		String state = sc.nextLine();
		System.out.println("Enter zip code of your area: ");
		Long zipCode = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter phone number: ");
		Long phoneNum = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your EMail ID: ");
		String email = sc.nextLine();		
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAddress(address);
		contact.setCity(city);
		contact.setState(state);
		contact.setZipCode(zipCode);
		contact.setPhoneNumber(phoneNum);
		contact.setEmail(email);
		System.out.println(contact);
	}
	
	public void editContact() {
		System.out.println("Enter First Name of Persion");
		String editName = sc.nextLine();
		if (editName.equalsIgnoreCase(contact.firstName)) {
			add();
		} else {
			System.out.println("Invalid Name......!");
			System.out.println("Please enter valid First Name");
			editContact();
		}

	}	
	public void delete() {
		System.out.println("Enter First Name of Person");
		String deleteName = sc.nextLine();
		if (deleteName.equals(contact.firstName)) {
			System.out.println("you deleted " + contact.firstName + " data");
			contact = null;
		}
	}
}
