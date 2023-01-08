package groupingtests;

import org.testng.annotations.Test;

public class Login {
	
	@Test(priority=1,groups= {"windows.smoke","sanity","regression","login","all"})
	public void loginWithValidCredentials() {
		
		System.out.println("loginWithValidCredentials - Login");
		
	}
	
	@Test(priority=2,groups= {"windows.regression","login","all"})
	public void loginWithValidEmailAndInvalidPassword() {
		
		System.out.println("loginWithValidEmailAndInvalidPassword - Login");
		
	}
	
	@Test(priority=3,groups= {"windows.sanity","regression","login","all"})
	public void loginWithInvalidEmailAndValidPassword() {
		
		System.out.println("loginWithInvalidEmailAndValidPassword - Login");
		
	}
	
	@Test(priority=4,groups= {"smoke","sanity","regression","login","all"})
	public void loginWithInvalidCredentials() {
		
		System.out.println("loginWithInvalidCredentials - Login");
		
	}
	
	@Test(priority=5,groups= {"sanity","regression","login","all"})
	public void loginWithoutCredentials() {
		
		System.out.println("loginWithoutCredentials - Login");
		
	}

}
