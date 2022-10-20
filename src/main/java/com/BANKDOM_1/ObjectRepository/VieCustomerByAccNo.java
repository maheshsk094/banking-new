package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VieCustomerByAccNo {

	//declaration 

	@FindBy(name="account_no")
	private WebElement accountNo;

	@FindBy(name="submit_view")
	private WebElement submitBtn;


	//initialization
	public VieCustomerByAccNo(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}



	//utilization

	public WebElement getAccountNo() {
		return accountNo;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	//Business Library
	
	public void viewCustomerByAccNo(String acccountNo)
	{
		accountNo.sendKeys(acccountNo);
		submitBtn.click();
	}
}
