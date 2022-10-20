package com.BANKDOM_1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingRegister {


	//declaration 

	@FindBy(name="holder_name")
	private WebElement holderName;

	@FindBy(name="accnum")
	private WebElement accountNo;

	@FindBy(name="dbtcard")
	private WebElement debitCardNo;

	@FindBy(name="dbtpin")
	private WebElement debitCardPin;

	@FindBy(name="mobile")
	private WebElement mobileNo;

	@FindBy(name="pan_no")
	private WebElement panNo;

	@FindBy(xpath="//input[@placeholder='Date of Birth']")
	private WebElement dob;

	@FindBy(name="last_trans")
	private WebElement lastTransaction;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(name="cnfrm_password")
	private WebElement confirmPassword;

	@FindBy(name="submit")
	private WebElement submitBtn;


	//initialization
	public InternetBankingRegister(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //take last pagefactory
	}

	

	//utilization

	public WebElement getHolderName() {
		return holderName;
	}

	public WebElement getAccountNo() {
		return accountNo;
	}

	public WebElement getDebitCardNo() {
		return debitCardNo;
	}

	public WebElement getDebitCardPin() {
		return debitCardPin;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getDateOfBirth() {
		return panNo;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getLastTransaction() {
		return lastTransaction;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}



	//Business Library
	public void internetBankRegister(String name, String accNo, String debitNo, String debitPin, String mblNo, String pan, String lastTran,
			String pass, String cnfrPass)
	{
		holderName.sendKeys(name);
		accountNo.sendKeys(accNo);
		debitCardNo.sendKeys(debitNo);
		debitCardPin.sendKeys(debitPin);
		mobileNo.sendKeys(mblNo);
		panNo.sendKeys(pan);
	//	dob.sendKeys(dobb);
		lastTransaction.sendKeys(lastTran);
		password.sendKeys(pass);
		confirmPassword.sendKeys(cnfrPass);
		submitBtn.click();		
	}
	
}
