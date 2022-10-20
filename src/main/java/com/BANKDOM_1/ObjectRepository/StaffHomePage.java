package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {

	//declaration 

	@FindBy(name="viewdet")
	private WebElement ViewActiveCust;

	@FindBy(name="apprvac")
	private WebElement apprvAcc;

	@FindBy(name="view_cust_by_ac")
	private WebElement viewByAccNo;

	@FindBy(name="del_cust")
	private WebElement deleteCustomer;

	@FindBy(name="credit_cust_ac")
	private WebElement creditCustomer;

	@FindBy(name="logout_btn")
	private WebElement staffLogout;

	@FindBy(name="home")
	private WebElement staffHomeBtn;


	//initialization

	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}



	//utilization

	public WebElement getViewActiveCust() {
		return ViewActiveCust;
	}


	public WebElement getApprvAcc() {
		return apprvAcc;
	}


	public WebElement getViewByAccNo() {
		return viewByAccNo;
	}


	public WebElement getDeleteCustomer() {
		return deleteCustomer;
	}


	public WebElement getCreditCustomer() {
		return creditCustomer;
	}


	public WebElement getStaffLogout() {
		return staffLogout;
	}


	public WebElement getStaffHomeBtn() {
		return staffHomeBtn;
	}


	
	//Business Library
	
	public void viewActiveCust()
	{
		ViewActiveCust.click();
	}
	public void apprvAcc()
	{
		apprvAcc.click();
	}
	public void viewByAccNo()
	{
		viewByAccNo.click();
	}
	public void deleteCustomer()
	{
		deleteCustomer.click();
	}
	public void creditCustomer()
	{
		creditCustomer.click();
	}
	public void staffLogout()
	{
		staffLogout.click();
	}
	public void staffHomeBtn()
	{
		staffHomeBtn.click();
	}

}
