package groupingtests;

import org.testng.annotations.Test;

public class Search {
	
	@Test(priority=1,groups= {"smoke","sanity","regression","search","all"})
	public void searchForValidProduct() {
		
		System.out.println("SearchForAValidProduct - Search");
	}
	
	@Test(priority=2,groups= {"sanity","regression","search","all"})
	public void searchForAnInvalidProduct() {
		
		System.out.println("searchForAnInvalidProduct - Search");
	}
	
	@Test(priority=3,groups= {"windows.sanity","regression","search","all"})
	public void searchWithoutAnyProduct() {
		
		System.out.println("searchWithoutAnyProduct - Search");
	}

}
