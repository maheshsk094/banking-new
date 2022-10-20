package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	
	//declaration 

		@FindBy(name="holder_name")
		private WebElement holderName;

		@FindBy(name="pan")
		private WebElement panNo;

		@FindBy(name="mob")
		private WebElement mobile;

		@FindBy(name="acc_no")
		private WebElement accountNo;

		

		

		//initialization
		public ApplyDebitCardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this); //take last pagefactory
		}


		
		//utilization
		public WebElement getHolderName() {
			return holderName;
		}



		public WebElement getPanNo() {
			return panNo;
		}



		public WebElement getMobile() {
			return mobile;
		}



		public WebElement getAccountNo() {
			return accountNo;
		}



		
		
		//Business Library
		public void applyDebitCard(String name, String pan, String mblNo, String accNo)
		{
			holderName.sendKeys(name);
			panNo.sendKeys(pan);
			mobile.sendKeys(mblNo);
			accountNo.sendKeys(accNo);
			
			
		}
	
	

}
