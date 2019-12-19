package email;

import java.util.Scanner;

public class Email {

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String department; 
	private int mailboxCapacity=750; //in megabytes
	private int defaultLength = 9; //default password length
	private String companySuffix = "helloworld";
	private String alternateEmail;
	public int errorCode;
	
	//constructor for first and last name
	public Email (String firstName, String lastName) {
		this.firstName = firstName;  //this.firstName refers to class level variable and firstName refers to local variable being passed to parameter
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED FOR: " + this.firstName + " " + this.lastName);
		
		//call a method asking for the department and return it
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);
		
		//generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix +".com";
//		System.out.println("Your email is: " + email);
		
		//call method that returns random password
		this.password = generatePassword(defaultLength);
		System.out.println("Your password is: " + this.password);
	}
	
	//ask for department
	private String setDepartment() {
		System.out.println("New Employee: " + firstName + " " + lastName);
		System.out.println("Enter Department Name From the Following: \nSales \nDevelopment \nAccounting \nMarketing" );
		System.out.println("Enter Department Name: ");
		Scanner sc= new Scanner(System.in);
		String originalDept = sc.next();
		String dept = originalDept.toLowerCase();
		if (dept.contains("sales")) return "sales";
		else if (dept.contains("development")) return "development";
		else if (dept.contains("accounting")) return "accounting";
		else if (dept.contains("marketing")) return "marketing";
		else { return "error";} //returns error message if department entered isn't a previously specified one or if spelled wrong
	}
	
	
	//generate a random password
	private String generatePassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&^*()?/:;><.,abcdefghijklmnopqrstuvwxyz";
		char[] password = new char[length];
		for (int i = 0; i<length; i++) {
			int random = (int)(Math.random()* passwordSet.length()); //a random number is generated within scope of password set
			password[i] = passwordSet.charAt(random); //the character at the random number is taken and passed into the array one at a time
		}
		return new String(password);
	}
	
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set alternative email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public String getDept() {return department;}
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "NAME: " + firstName  + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";
	}

}
