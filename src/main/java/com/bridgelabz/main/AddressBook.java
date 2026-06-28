package com.bridgelabz.main;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
		if(contactList.contains(contact)) {
		    System.out.println("Duplicate Contact Found");
		}
		else {
		    contactList.add(contact);
		    try {	    	
		    	FileWriter fw=new FileWriter("Contacts.csv",true);
				CSVWriter writer=new CSVWriter(fw);
				String contactDetails=contact.toString();
				writer.writeNext(contactDetails.split(","));
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Contact Added Successfully");
		}
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
	public ArrayList<Contacts> getContactList() {
		return contactList;
	}
	public void searchByCity(String city) {
		boolean found = false;
		for (Contacts contact : contactList) {
			if (contact.getCity().equalsIgnoreCase(city)) {
				System.out.println(contact);
				found = true;
			}
		}
		if (!found)
			System.out.println("No Person Found");
	}
	
	public void searchByState(String state) {
		boolean found = false;
		for (Contacts contact : contactList) {
			if (contact.getState().equalsIgnoreCase(state)) {
				System.out.println(contact);
				found = true;
			}
		}
		if (!found)
			System.out.println("No Person Found");
	}
	public long countByCity(String city) {
	return contactList.stream().filter(contact -> contact.getCity().equalsIgnoreCase(city)).count();
}
public long countByState(String state) {
	return contactList.stream().filter(contact -> contact.getState().equalsIgnoreCase(state)).count();
}

public void sortByName() {
	contactList.stream().sorted((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName())).forEach(System.out::println);
}

public void sortByZip() {
	contactList.stream().sorted(Comparator.comparing(obj->obj.zipCode)).forEach(System.out::println);
}
public void sortByCity() {
	contactList.stream().sorted((c1, c2) -> c1.getCity().compareToIgnoreCase(c2.getCity())).forEach(System.out::println);
}
public void sortByState() {
	contactList.stream().sorted((c1, c2) -> c1.getState().compareToIgnoreCase(c2.getState())).forEach(System.out::println);
}
public void readingAllTheContacts() {
	try {
FileReader fr=new FileReader("Contacts.csv");
    CSVReader cr=new CSVReader(fr);
		List<String[]> contactList=cr.readAll();
		for(String[] contact:contactList) {
			for(int i=0;i<contact.length;i++) {
				System.out.print(contact[i]+",");
			}
			System.out.println();
		}
		System.out.println();
	} catch (IOException | CsvException e) {
		e.printStackTrace();
	}
}

public void showContactsFromDB() {
    AddressBookDBService service = new AddressBookDBService();
    ArrayList<Contacts> contacts = service.getAllContacts();
    if (contacts.isEmpty()) {
        System.out.println("No Contacts Found");
        return;
    }
    for (Contacts contact : contacts) {
        System.out.println(contact);
    }
}
}
