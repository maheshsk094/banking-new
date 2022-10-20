package com.BANKDOM_1.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.java.swing.plaf.windows.resources.windows;

public class WebdriverUtility {

	/**
	 * This method will maximize the window
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will wait for 20 seconds for the page load
	 * @param driver
	 */

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait for 10 seconds for an element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for 10 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will select data from drop down using index
	 * @param element
	 * @param index
	 */

	public void select(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will select data from drop down using visibleText
	 * @param element
	 * @param text
	 */

	public void select(WebElement element, String text)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}


	/**
	 * This method will select data from drop down using value
	 * @param element
	 * @param value
	 */

	public void select(String value,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will perform mouseHover action
	 * @param driver
	 * @param element
	 */

	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click operation on element
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform right click operation on webpage
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}


	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param element
	 */

	public void draAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	/**
	 * This method will perform double click operation on element
	 * @param driver
	 * @param element
	 */

	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform double click operation on webpage
	 * @param driver
	 * @param element
	 */

	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}


	/**
	 * This method will press enter key
	 * @param driver
	 */

	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method will press enter key
	 * @param driver
	 */

	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will release enter key
	 * @param driver
	 */

	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}


	/**
	 * This method will switch the frame based on nameOrId
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}

	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to cancel alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will switch window
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		// step1: use getWindowHandles to capture all window is's
		Set<String> windows = driver.getWindowHandles();

		//step2: Iterate through the windows
		Iterator<String> it = windows.iterator();

		//step3: Check whether there is next window
		while(it.hasNext())
		{
			//step4: Capture current window id
			String winId=it.next();

			//step5: Switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();

			//step6: Check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenShotNmae
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);

	}

	/**
	 * This method will perform random scroll
	 * @param driver
	 */

	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("windows.scrollBy(0,500)", "");
	}

	/**
	 * This method will perform random scroll
	 * @param driver
	 */

	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		jse.executeScript("argument[0], scrollIntoView()", element);

	}


















































}
