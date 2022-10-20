package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomer {
	
	//declaration 
	
	@FindBy(name="customer_account_no")
	private WebElement customerAccNo;
	
	@FindBy(name="credit_amount")
	private WebElement amount;
		
	@FindBy(name="credit_btn")
	private WebElement creditBtn;
	
	
				
	//initialization
	public CreditCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}


	
	//utilization
	
	public WebElement getCustomerAccNo() {
		return customerAccNo;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getCreditBtn() {
		return creditBtn;
	}
	

	
	//Business Library

	public void creditAmount(String custAccNo, String amountt)
	{
		customerAccNo.sendKeys(custAccNo);
		amount.sendKeys(amountt);
		creditBtn.click();
	}
	

}
