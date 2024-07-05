package com.address.book;

	import java.io.*;
	import java.util.ArrayList;
	import java.util.Scanner;

	// AddressBook.java
	public class AddressBook {
	    private ArrayList<Contact> contacts = new ArrayList<>();

	    public void addContact(Contact contact) {
	        contacts.add(contact);
	    }

	    public void viewContacts() {
	        for (Contact contact : contacts) {
	            System.out.println(contact);
	        }
	    }

	    public Contact searchContact(String name) {
	        for (Contact contact : contacts) {
	            if (contact.getName().equalsIgnoreCase(name)) {
	                return contact;
	            }
	        }
	        return null;
	    }

	    public void deleteContact(Contact contact) {
	        contacts.remove(contact);
	    }

	    public void saveToFile(String fileName) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
	            for (Contact contact : contacts) {
	                writer.println(contact.getName() + "," + contact.getPhoneNumber() + "," +
	                        contact.getEmail() + "," + contact.getAddress());
	            }
	            System.out.println("Contacts saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error saving contacts: " + e.getMessage());
	        }
	    }

	    public void loadFromFile(String fileName) {
	        try (Scanner scanner = new Scanner(new File(fileName))) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] parts = line.split(",");
	                if (parts.length == 4) {
	                    String name = parts[0];
	                    String phoneNumber = parts[1];
	                    String email = parts[2];
	                    String address = parts[3];
	                    contacts.add(new Contact(name, phoneNumber, email, address));
	                }
	            }
	            System.out.println("Contacts loaded from " + fileName);
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found: " + e.getMessage());
	        }
	    }
	}

