package com.BANKDOM_1.ObjectRepository;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BANKDOM_1.GenericUtility.WebdriverUtility;

public class OpenAccountPage extends WebdriverUtility {

	//declaration 
	
	@FindBy(name=("name"))
	private WebElement nameEdit;
	
	@FindBy(name=("gender"))
	private WebElement genderDropdown;
	
	@FindBy(name=("mobile"))
	private WebElement mobileEdit;
	
	@FindBy(name=("email"))
	private WebElement emailEdit;
	
	@FindBy(name=("landline"))
	private WebElement landlineEdit;
	 
	@FindBy(xpath=("//input[@placeholder='Date of Birth']"))
	private WebElement dateOfBirth;
	
	@FindBy(xpath=("//input[@placeholder='PAN Number']"))
	private WebElement panNumber;
	
	@FindBy(name=("citizenship"))
	private WebElement citizenshipNo;
	
	@FindBy(name=("homeaddrs"))
	private WebElement homeAddress;
	
	@FindBy(name=("officeaddrs"))
	private WebElement officeAddress;
	
	@FindBy(name=("state"))                       // drop down use select class
	private WebElement stateDropdown;
	
	@FindBy(name=("city"))                        // drop down use select class
	private WebElement cityDropdown;
	
	@FindBy(name=("pin"))
	private WebElement pinCode;
	
	@FindBy(name=("arealoc"))
	private WebElement areaLocality;
	
	@FindBy(name=("acctype"))                     // drop down use select class
	private WebElement accountTypeDropdown;
	
	@FindBy(name=("submit"))                    
	private WebElement submitBtn;
	
	
	//initialization
			public OpenAccountPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this); //take last pagefactory
			}
	
			
	//utilization

			public WebElement getNameEdit() {
				return nameEdit;
			}


			public WebElement getGenderDropdown() {  
				return genderDropdown;
			}


			public WebElement getMobileEdit() {
				return mobileEdit;
			}


			public WebElement getEmailEdit() {
				return emailEdit;
			}


			public WebElement getLandlineEdit() {
				return landlineEdit;
			}


			public WebElement getDateOfBirth() {
				return dateOfBirth;
			}


			public WebElement getPanNumber() {
				return panNumber;
			}


			public WebElement getCitizenshipNo() {
				return citizenshipNo;
			}


			public WebElement getHomeAddress() {
				return homeAddress;
			}


			public WebElement getOfficeAddress() {
				return officeAddress;
			}


			public WebElement getStateDropdown() {
				return stateDropdown;
			}


			public WebElement getCityDropdown() {
				return cityDropdown;
			}

			public WebElement getPinCode() {
				return pinCode;
			}

			public WebElement getAreaLocality() {
				return areaLocality;
			}

			public WebElement getAccountTypeDropdown() {
				return accountTypeDropdown;
			}
			
			public WebElement getSubmitBtn() {
				return submitBtn;
			}
			
			
			//Business Library
			public void openAccountPage(String name, String gender, String mobile, String email, String landline, String pan, String citizen,
					String homeaddr, String officeaddr, String state, String city, String pin, String area, String accType)
			{
				nameEdit.sendKeys(name);
				select(genderDropdown, gender);          //for dropdown select by text
				mobileEdit.sendKeys(mobile);
				emailEdit.sendKeys(email);
				landlineEdit.sendKeys(landline);
				//dateOfBirth.click();
				//dateOfBirth.sendKeys(dob);
				panNumber.sendKeys(pan);
				citizenshipNo.sendKeys(citizen);
				homeAddress.sendKeys(homeaddr);
				officeAddress.sendKeys(officeaddr);
				select(stateDropdown, state);
				select(cityDropdown, city);
				pinCode.sendKeys(pin);
				areaLocality.sendKeys(area);
				select(accountTypeDropdown, accType);
				submitBtn.click();
				
			}


	
}
