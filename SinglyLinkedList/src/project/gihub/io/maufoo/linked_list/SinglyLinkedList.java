package project.gihub.io.maufoo.linked_list;

public class SinglyLinkedList {
	private Node headNode;
	private Node currentNode;
	private Node lastNode;
	
	public SinglyLinkedList() {
		this(null, null);
	}
	
	public SinglyLinkedList(Node headNode, Node lastNode) {
		this.headNode = headNode;
		this.lastNode = lastNode;
		this.currentNode = null;
	}
	
	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}
	
	public Node getHeadNode() {
		return headNode;
	}
	
	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}
	
	public Node getLastNode() {
		return lastNode;
	}
	
	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}
	
	public Node getCurrentNode() {
		return currentNode;
	}
	
	public int getCount() {
		int count = 0;
		currentNode = headNode;
		while (currentNode != null) {
			++count;
		}
		return count;
	}
	
	public void insertFirst(Node node) {
		node.setNextNode(headNode);
		headNode = node;
	}
	
	public void insertLast(Node nextNode) {
		lastNode.setNextNode(nextNode);
		nextNode.setNextNode(null);
		lastNode = nextNode;
	}
	
	public void remove(String contactName) {
		Node previousNode = null;
		currentNode = headNode;
		while (currentNode != null) {
			if (headNode.getContact().getFullName().equals(contactName)) {
				headNode = headNode.getNextNode();
			} else if (currentNode.getContact().getFullName().equals(contactName)) {
				previousNode.setNextNode(currentNode.getNextNode());
			} else if (lastNode.getContact().getFullName().equals(contactName)) {
				lastNode = previousNode;
				lastNode.setNextNode(null);
			}
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
	}
}
