package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerAcc {

	//declaration 

	@FindBy(name="Cust_ac_no")
	private WebElement customerAccNo;

	@FindBy(name="Cust_ac_Id")
	private WebElement customerId;

	@FindBy(name="reason")
	private WebElement reason;

	@FindBy(name="del_cust")
	private WebElement deleteBtn;



	//initialization
	public DeleteCustomerAcc(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}



	//utilization

	public WebElement getCustomerAccNo() {
		return customerAccNo;
	}

	public WebElement getApplyDebitCardEdit() {
		return customerId;
	}

	public WebElement getReason() {
		return reason;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}


	//Business Library

	public void deleteAcc(String accountNo, String custId, String reasons)
	{
		customerAccNo.sendKeys(accountNo);
		customerId.sendKeys(custId);
		reason.sendKeys(reasons);
		deleteBtn.click();
	}


}
