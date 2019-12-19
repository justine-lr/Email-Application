/**
 * 
 * Task: An application that an employer can use to create new email accounts for new employees
 *
 */

package email;

public class Application {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email e1 = new Email("Jane", "Doe");
		/**
		 * code to set and get an alternate email, jane@doe.com is just an example
		  e1.setAlternateEmail("jane@doe.com");
		  System.out.println(e1.getAlternateEmail());
		*/
		
		int errorCode = 0;
		String dept = e1.getDept();
		if(dept.contains("error")) { //assigns an error code if entered department name is unknown/spelled wrong
			errorCode = 1;
			System.out.println("Email creation failed. Password uavailable for use. \nCheck your spelling and try again.");
		}
		
		if(errorCode >0) {
			System.exit(errorCode); //terminates program if department is spelled wrong
		}
		
		System.out.println(e1.showInfo()); //prints employee information 
		
	}


}
