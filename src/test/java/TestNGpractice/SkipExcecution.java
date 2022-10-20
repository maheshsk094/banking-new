package TestNGpractice;

import org.testng.annotations.Test;

public class SkipExcecution {

@Test 
	
	public void createCustomer()
	{
		System.out.println("customer details created");
		int []a={1,2,3};
		System.out.println(a[5]);  // failing the script
	}
	
	@Test (dependsOnMethods="createCustomer")  // it will skip because createCustomer is failed
	public void modifyCustomer()
	{
		System.out.println("modify customer details");
	}
	
	@Test(dependsOnMethods="createCustomer")    // it will skip because createCustomer is failed
	public void deleteCustomer()
	{
		System.out.println("deleted customer details");
	}
	

}
