package com.bridgelabz.main;
import java.util.Scanner;
public class AddressBookMain {
	public static void main(String[] args) {
		AddressBook myObj = new AddressBook();
		System.out.println("Welcome to Address Book System");
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Edit \n 2.Delete \n3.ShowContacts");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			myObj.editContact();
			break;
		case 2:
			myObj.delete();
			break;	
		
		case 3:
			myObj.showContact();
		    break;
		}
	sc.close();
	}
}
