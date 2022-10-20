package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	
	//declaration 
	
	@FindBy(name="staff_id")
	private WebElement userNameEdit;
	
	@FindBy(name="password")
	private WebElement passwordEdit;
	
	@FindBy(name="staff_login-btn")
	private WebElement submitBtn;
	
	
	//initialization
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}


	//utilization
	
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}


	public WebElement getPasswordEdit() {
		return passwordEdit;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	
	//Business Library
	public void loginPage(String username, String password)
	{
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitBtn.click();
	}
	
	

}
