package com.bridgelabz.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.HashMap;

public class AddressBookMain {
	public static void main(String[] args) {
		AddressBook myObj = new AddressBook();
		HashMap<String, AddressBook> addressBookMap = new HashMap<>();
		System.out.println("Welcome to Address Book System");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to Address Book System");
			System.out.println("1.Create Address Book");
			System.out.println("2.Open Address Book");
			System.out.println("3.Show Address Books");
			System.out.println("4.Search By City");
			System.out.println("5.Search By State");
            System.out.println("6.No.0f Contacts in a city");
			System.out.println("7.No.0f Contacts in a State");
			System.out.println("8.Sort By Name");
			System.out.println("9.Exit");
			int input = sc.nextInt();
			sc.nextLine();
			switch (input) {
				case 1:
					System.out.println("Enter Address Book Name:");
					String addressBookName = sc.nextLine();
					if (addressBookMap.containsKey(addressBookName)) {
						System.out.println("Address Book Already Exists");
					} else {
						addressBookMap.put(addressBookName, new AddressBook());
						System.out.println("Address Book Created Successfully");
					}
					break;
				case 2:
					System.out.println("Enter Address Book Name:");
					String name = sc.nextLine();
					AddressBook addressBook = addressBookMap.get(name);
					if (addressBook == null) {
						System.out.println("Address Book Not Found");
						break;
					}
					while (true) {
						System.out.println("1.Add Contact");
						System.out.println("2.Edit Contact");
						System.out.println("3.Delete Contact");
						System.out.println("4.Show Contacts");
						System.out.println("5.Back");
						int choice = sc.nextInt();
						sc.nextLine();
						switch (choice) {
							case 1:
								addressBook.add();
								break;
							case 2:
								addressBook.editContact();
								break;
							case 3:
								addressBook.delete();
								break;
							case 4:
								addressBook.showContact();
								break;
							case 5:
								break;
							default:
								System.out.println("Invalid Choice");
						}
						if (choice == 5)
							break;
					}
					break;
				case 3:
					if (addressBookMap.isEmpty()) {
						System.out.println("No Address Books Available");
					} else {
						System.out.println("Available Address Books:");
						for (String key : addressBookMap.keySet()) {
							System.out.println(key);
						}
					}
					break;
				case 4:
					System.out.println("Enter City:");
					String city = sc.nextLine();
					for (AddressBook book : addressBookMap.values()) {
						book.searchByCity(city);
					}
					break;
				case 5:
					System.out.println("Enter State:");
					String state = sc.nextLine();
					for (AddressBook book : addressBookMap.values()) {
						book.searchByState(state);
					}

					break;
				case 6:

					System.out.println("Enter City:");
					String cityName = sc.nextLine();

					long cityCount = 0;

					for (AddressBook book : addressBookMap.values()) {
						cityCount += book.countByCity(cityName);
					}

					System.out.println("Total Persons in " + cityName + " : " + cityCount);

					break;

				case 7:

					System.out.println("Enter State:");
					String stateName = sc.nextLine();

					long stateCount = 0;

					for (AddressBook book : addressBookMap.values()) {
						stateCount += book.countByState(stateName);
					}

					System.out.println("Total Persons in " + stateName + " : " + stateCount);

					break;
				case 8:
					System.out.println("Enter Address Book Name:");
					String bookName = sc.nextLine();
					AddressBook book = addressBookMap.get(bookName);
					if(book == null) {
						System.out.println("Address Book Not Found");
					}
					else {
						book.sortByName();
					}
					break;	
				case 9:
					System.out.println("Thank You");
					sc.close();
					return;
				default:
					System.out.println("Invalid Choice");
			}
		}

	}
}
