package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BANKDOM_1.GenericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility  {  //for mouse hover extend used to get web driver methods
	
	//declaration 
	
		@FindBy(xpath=("//a[.='Open Account']"))
		private WebElement openAccountEdit;
		
		@FindBy(xpath=("//a[.='Apply Debit Card']"))
		private WebElement applyDebitCardEdit;
		
		@FindBy(partialLinkText=("Internet Banking"))
		private WebElement internetBankingEdit;
		
		@FindBy(xpath=("//a[.='Register']"))
		private WebElement registerLoginEdit;
		
		@FindBy(xpath=("//a[.='Login ']"))
		private WebElement internetLoginEdit;
		
		@FindBy(xpath=("//a[.='Fund Transfer']"))
		private WebElement fundTransferEdit;
		
		@FindBy(xpath=("//a[.='Staff Login']"))
		private WebElement staffLoginEdit;
		
		@FindBy(xpath=("//a[.='Home']"))
		private WebElement mainHomeEdit;

		
		//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this); //take last pagefactory
		}

		
		//utilization

		public WebElement getOpenAccountEdit() {
			return openAccountEdit;
		}


		public WebElement getApplyDebitCardEdit() {
			return applyDebitCardEdit;
		}


		public WebElement getInternetBankingEdit() { // mouse hover action
			return internetBankingEdit;
		}


		public WebElement getRegisterLoginEdit() {
			return registerLoginEdit;
		}


		public WebElement getInternetLoginEdit() {
			return internetLoginEdit;
		}


		public WebElement getFundTransferEdit() {
			return fundTransferEdit;
		}


		public WebElement getStaffLoginEdit() {
			return staffLoginEdit;
		}


		public WebElement getHomeEdit() {
			return mainHomeEdit;
		}

			
		//Business Library
		public void openAccount()
		{
			openAccountEdit.click();
		}
		public void applyDebitCard()
		{
			applyDebitCardEdit.click();
		}
		public void fundTransfer()
		{
			fundTransferEdit.click();
		}
		public void staffLogin()
		{
			staffLoginEdit.click();
		}
		public void internetBankRegister(WebDriver driver)
		{
			mouseHover(driver, internetBankingEdit);
			registerLoginEdit.click();
		}
		public void internetBankLogin(WebDriver driver)
		{
			mouseHover(driver, internetBankingEdit);
			internetLoginEdit.click();
		}
		public void homeLink()
		{
			mainHomeEdit.click();
		}
		
		


		
				
}
