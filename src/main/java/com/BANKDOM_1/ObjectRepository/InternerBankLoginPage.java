package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternerBankLoginPage {
	
	//declaration 
	
		@FindBy(name="customer_id")
		private WebElement custNmae;
		
		@FindBy(name="password")
		private WebElement passwordEdit;
		
		@FindBy(name="login-btn")
		private WebElement submitBtn;
		
		
		//initialization
		public InternerBankLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this); //take last pagefactory
		}


		//utilization
		public WebElement getCustNmae() {
			return custNmae;
		}


		public WebElement getPasswordEdit() {
			return passwordEdit;
		}


		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		
		//Business Library
		public void internetBankLogin(String username, String password)
		{
			custNmae.sendKeys(username);
			passwordEdit.sendKeys(password);
			submitBtn.click();
		}


	

}
