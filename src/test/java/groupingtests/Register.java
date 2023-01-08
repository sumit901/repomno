package groupingtests;

import org.testng.annotations.Test;

@Test(groups={"all"})
public class Register {
	
	@Test(priority=1,groups= {"windows.smoke","regression","register"})
	public void registerByProvidingOnlyMandatoryFields() {
		
		System.out.println("registerByProvidingOnlyMandatoryFields - Register");
	}
	
	@Test(priority=2,groups= {"windows.sanity","regression","register"})
	public void registerByProvidingAllFields() {
		
		System.out.println("registerByProvidingAllFields - Register");
	}
	
	@Test(priority=3,groups= {"register"})
	public void registerByNotProvidingAnyFields() {
		
		System.out.println("registerByNotProvidingAnyFields - Register");
	}
	
	@Test(priority=4,groups= {"sanity","register"})
	public void registerByProvidingDupicateEmail() {
		
		System.out.println("registerByProvidingDupicateEmail - Register");
	}

}
