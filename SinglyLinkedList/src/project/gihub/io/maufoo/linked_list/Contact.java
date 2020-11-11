package project.gihub.io.maufoo.linked_list;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public Contact(String firstName, String lastName, String email) {
		this(firstName, lastName, email, "NA");
	}
	
	public Contact(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
		
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public void displayContactInformation() {
		StringBuilder contactInformation = new StringBuilder();
		System.out.println(contactInformation.append("Full name: ")
											 .append(firstName)
											 .append(" ")
											 .append(lastName)
											 .append("\nEmail: ")
											 .append(email)
											 .append("\nPhone number: ")
											 .append(phoneNumber)
											 .append("\n"));
	}
}
