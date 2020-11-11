package project.gihub.io.maufoo.linked_list;

import java.util.Scanner;

public class ContactList {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SinglyLinkedList linkedList = null;
		String contactInformation;
		String[] parsedContactInformation;
		Contact contact;
		Node contactNode;
		
		System.out.println("Please add 5 contacts to the list. First name, last name, email, and phone number. Ex. Ben Smith ben.smith@gmail.com 8027779058");
		for (int i = 0; i < 3; ++i) {
			contactInformation = scanner.nextLine();
			parsedContactInformation = contactInformation.split(" ");
			contact = new Contact(parsedContactInformation[0], parsedContactInformation[1], parsedContactInformation[2], parsedContactInformation[3]);
			contactNode = new Node(contact);
			if (i == 0) {
				linkedList = new SinglyLinkedList(contactNode, contactNode);
			} else {
				linkedList.insertLast(contactNode);
			}
		}
		
		// Display all contact in list
		contactNode = linkedList.getHeadNode();
		System.out.println("Contact List");
		while (contactNode != null) {
			contactNode.getContact().displayContactInformation();
			contactNode = contactNode.getNextNode();
		}
		
		linkedList.remove("Test"); // Replace test with a name you entered into the list
		
		contactNode = linkedList.getHeadNode();
		System.out.println("Contact List");
		while (contactNode != null) {
			contactNode.getContact().displayContactInformation();
			contactNode = contactNode.getNextNode();
		}
		
		scanner.close();
	}
}
