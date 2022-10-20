package TestNGpractice;

import org.testng.annotations.Test;

public class Invocating {

@Test 
	
	public void createCustomer()
	{
		System.out.println("customer details created");
	}
	
	@Test (invocationCount=3)
	public void modifyCustomer()
	{
		System.out.println("modify customer details");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("deleted customer details");
	}
	
}
