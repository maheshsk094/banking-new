package TestNGpractice;

import org.testng.annotations.Test;

// @Test--> for all method execution

public class TestNGpgm {
	

	@Test (priority=1)
	
	public void createCustomer()
	{
		System.out.println("customer details created");
	}
	
	@Test (priority=-1)
	public void modifyCustomer()
	{
		System.out.println("modify customer details");
	}
	
	@Test(enabled=false) // To skip the execution
	public void deleteCustomer()
	{
		System.out.println("deleted customer details");
	}
	


}
