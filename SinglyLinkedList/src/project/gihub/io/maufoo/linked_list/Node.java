package project.gihub.io.maufoo.linked_list;

public class Node {
	private Contact contact;
	private Node nextNode;
	
	public Node() {
		this(null, null);
	}
	
	public Node(Contact contact) {
		this(contact, null);
	}
	
	public Node(Contact contact, Node node) {
		this.contact = contact;
		this.nextNode = node;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
		
	public Node getNextNode() {
		return nextNode;
	}
}