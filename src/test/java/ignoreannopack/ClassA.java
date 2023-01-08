package ignoreannopack;

import org.testng.annotations.Test;

public class ClassA {
	
	@Test(priority=1)
	
	public void methodAone() {
		
		System.out.println("methodA one");
	}
	
	@Test(priority=2)
	
	public void methodAtwo() {
		
		System.out.println("methodA two");
	}
	
	@Test(priority=3)
	
	public void methodAthree() {
		
		System.out.println("methodA three");
	}

}
