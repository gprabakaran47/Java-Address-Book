package com.address.book;

import java.util.Scanner;

// Main.java
	public class Main {
	    public static void main(String[] args) {
	        AddressBook addressBook = new AddressBook();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nAddress Book Menu:");
	            System.out.println("1. Add Contact");
	            System.out.println("2. View Contacts");
	            System.out.println("3. Search Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("5. Save Contacts to File");
	            System.out.println("6. Load Contacts from File");
	            System.out.println("7. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter phone number: ");
	                    String phoneNumber = scanner.nextLine();
	                    System.out.print("Enter email: ");
	                    String email = scanner.nextLine();
	                    System.out.print("Enter address: ");
	                    String address = scanner.nextLine();
	                    Contact newContact = new Contact(name, phoneNumber, email, address);
	                    addressBook.addContact(newContact);
	                    System.out.println("Contact added successfully.");
	                    break;
	                case 2:
	                    addressBook.viewContacts();
	                    break;
	                case 3:
	                    System.out.print("Enter name to search: ");
	                    String searchName = scanner.nextLine();
	                    Contact foundContact = addressBook.searchContact(searchName);
	                    if (foundContact != null) {
	                        System.out.println("Contact found: " + foundContact);
	                    } else {
	                        System.out.println("Contact not found.");
	                    }
	                    break;
	                case 4:
	                    System.out.print("Enter name to delete: ");
	                    String deleteName = scanner.nextLine();
	                    Contact deleteContact = addressBook.searchContact(deleteName);
	                    if (deleteContact != null) {
	                        addressBook.deleteContact(deleteContact);
	                        System.out.println("Contact deleted successfully.");
	                    } else {
	                        System.out.println("Contact not found.");
	                    }
	                    break;
	                case 5:
	                    addressBook.saveToFile("contacts.txt");
	                    break;
	                case 6:
	                    addressBook.loadFromFile("contacts.txt");
	                    break;
	                case 7:
	                    System.out.println("Exiting program.");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
	            }
	        }
	    }
	}
