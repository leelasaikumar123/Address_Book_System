package com.bridgelabz.main;
import java.util.Scanner;
public class AddressBookMain {
	public static void main(String[] args) {
		AddressBook myObj = new AddressBook();
		System.out.println("Welcome to Address Book System");
		Scanner sc = new Scanner(System.in);
		while (true) {
            System.out.println("\n1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.Show Contacts");
            System.out.println("5.Exit");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
            case 1:
                myObj.add();
                break;
            case 2:
                myObj.editContact();
                break;
            case 3:
                myObj.delete();
                break;
            case 4:
                myObj.showContact();
                break;
            case 5:
                System.out.println("Thank You");
                sc.close();
                return;
            default:
                System.out.println("Invalid Choice");
            }
        }
	
	}
}
