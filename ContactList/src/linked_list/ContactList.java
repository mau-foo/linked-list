package linked_list;

import java.util.Scanner;

public class ContactList {

	public static void main(String[] args) {
		// Declared variables
		ContactNode headObj;
		ContactNode currObj;
		ContactNode lastObj;
		String fullName;
		String number;
		
		// Initialized variables
		Scanner scnr = new Scanner(System.in);
		
		// Populate head node
		System.out.println("Person 1");
		System.out.println("Enter full name");
		fullName = scnr.nextLine();
		System.out.println("Enter phone number");
		number = scnr.nextLine();
		System.out.println("You entered: " + fullName + ", " + number + "\n");
		
		headObj = new ContactNode(fullName, number);
		lastObj = headObj;
		
		// Populate linked list
		for (int i = 0; i < 2; ++i) { // hard code to loop only twice
			System.out.println("Person " + (i+2));
			System.out.println("Enter full name");
			fullName = scnr.nextLine();
			System.out.println("Enter phone number");
			number = scnr.nextLine();
			System.out.println("You entered: " + fullName + ", " + number + "\n");
			
			currObj = new ContactNode(fullName, number);
				
			lastObj.insertAfter(currObj);
			lastObj = currObj;
		}
		
		// Display all contacts in our linked list
		currObj = headObj;
		System.out.println("Contact List");
		while (currObj != null) {
			currObj.printContactNode();
			currObj = currObj.getNext();
		}
		
		// Close scanner
		scnr.close();
	}
}
