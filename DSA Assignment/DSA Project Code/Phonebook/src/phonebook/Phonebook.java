package phonebook;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Method to display contact details
    public void displayContact() {
        System.out.println("Name: " + this.name + ", Phone Number: " + this.phoneNumber);
    }
}

public class Phonebook {
    private ArrayList<Contact> phonebook = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Insert contact method
    public void insertContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        phonebook.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    // Search contact method
    public void searchContact() {
        System.out.println("Enter the name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Contact contact : phonebook) {
            if (contact.name.equalsIgnoreCase(name)) {
                contact.displayContact();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Display all contacts method
    public void displayContacts() {
        if (phonebook.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            for (Contact contact : phonebook) {
                contact.displayContact();
            }
        }
    }

    // Delete contact method
    public void deleteContact() {
        System.out.println("Enter the name to delete: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Contact contact : phonebook) {
            if (contact.name.equalsIgnoreCase(name)) {
                phonebook.remove(contact);
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Update contact method
    public void updateContact() {
        System.out.println("Enter the name to update: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Contact contact : phonebook) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println("Enter the new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                contact.phoneNumber = newPhoneNumber;
                System.out.println("Contact updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Sort contacts method (optional)
    public void sortContacts() {
        phonebook.sort((c1, c2) -> c1.name.compareToIgnoreCase(c2.name));
        System.out.println("Contacts sorted alphabetically.");
    }

    // Main program loop
    public void menu() {
        int choice;
        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    insertContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    sortContacts();
                    break;
                case 7:
                    System.out.println("Exiting phonebook...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 7);
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.menu();
    }
}
