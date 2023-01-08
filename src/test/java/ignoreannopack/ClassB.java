package ignoreannopack;

import org.testng.annotations.Test;

public class ClassB {
	
	@Test(priority=1)
	
	public void methodBone() {
		
		System.out.println("methodB one");
	}
	
	@Test(priority=2)
	
	public void methodBtwo() {
		
		System.out.println("methodB two");
	}

}
