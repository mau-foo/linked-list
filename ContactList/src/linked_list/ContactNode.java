package linked_list;

public class ContactNode {
	// Private variables
	private String contactName;
	private String contactPhoneNumber;
	private ContactNode nextNodePtr;
	
	// Default constructor
	public ContactNode() {
		contactName 	   = "none";
		contactPhoneNumber = "none";
		nextNodePtr 	   = null;
	}
	
	// Parameterized constructor
	public ContactNode(String name, String phoneNumber) {
		contactName 	   = name;
		contactPhoneNumber = phoneNumber;
		nextNodePtr 	   = null;
	}
	
	// Getter and setter methods
	public String getName() {
		return contactName;
	}
	
	public String getPhoneNumber() {
		return contactPhoneNumber;
	}
	
	public ContactNode getNext() {
		return nextNodePtr;
	}
	
	// Method used to link objects together into a list
	public void insertAfter(ContactNode nodeLoc) {
		ContactNode tmpNext;
		
		tmpNext 			= this.nextNodePtr;
		this.nextNodePtr 	= nodeLoc;
		nodeLoc.nextNodePtr = tmpNext; 
	}
	
	// Display contact information
	public void printContactNode() {
		System.out.println("Name: " + getName() + "\nPhone number: " + getPhoneNumber() + "\n");
	}
}