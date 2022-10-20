package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAcc {
	
	//declaration 
	
		@FindBy(name="application_no")
		private WebElement applicationNo;
		
		@FindBy(name="search_application")
		private WebElement search;
			
		@FindBy(name="approve_cust")
		private WebElement approve;
		
		
					
		//initialization
		public ApprovePendingAcc(WebDriver driver)
		{
			PageFactory.initElements(driver, this); //take last pagefactory
		}

		public WebElement getApplicationNo() {
			return applicationNo;
		}

		public WebElement getSearch() {
			return search;
		}

		public WebElement getApprove() {
			return approve;
		}

		
		//Business Library

		public void approveAcc(String appNo)
		{
			applicationNo.sendKeys(appNo);
			search.click();
			approve.click();
		}


}
