package com.bridgelabz.main;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
	ArrayList<Contacts> contactList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public void add() {	
		Contacts contact = new Contacts();
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
		contactList.add(contact);
		System.out.println("Contact Added Successfully");
	}
	
	public void editContact() {
		System.out.println("Enter First Name of Persion");
		String editName = sc.nextLine();
        for (Contacts contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(editName)) {
                System.out.println("Enter New Address:");
                contact.setAddress(sc.nextLine());
                System.out.println("Enter New City:");
                contact.setCity(sc.nextLine());
                System.out.println("Enter New State:");
                contact.setState(sc.nextLine());
                System.out.println("Contact Updated Successfully");
                return;
            }
        }
        System.out.println("Contact Not Found");
	}	
	public void delete() {
		System.out.println("Enter First Name of Person");
		String deleteName = sc.nextLine();
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().equalsIgnoreCase(deleteName)) {
                contactList.remove(i);
                System.out.println("Contact Deleted Successfully");
                return;
            }
        }

        System.out.println("Contact Not Found");
	}
	public void showContact() {
        if (contactList.isEmpty()) {
            System.out.println("No Contacts Found");
            return;
        }
        for (Contacts contact : contactList) {
            System.out.println(contact);
        }
	}
}
