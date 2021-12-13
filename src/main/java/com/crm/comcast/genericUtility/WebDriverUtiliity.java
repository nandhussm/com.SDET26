package com.crm.comcast.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.pomrepositrylib.CreatingNewOrganization;
import com.google.common.io.Files;

/**
 * it contains Webdriver specific reusable actions
 * @author Nandhakumar
 *
 */
public class WebDriverUtiliity{
/**
 * wait for the page to load before identifying any synchronized element in DOM[HTML-Document]
 * @param driver
 */
	public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Iconstant.implicitlyWait_TimeOut, TimeUnit.SECONDS);
	}
	/**
	 *wait for page to load before identifying any assynchronized [java script actions ]element in DOM[HTML-Document] 
	 * @param driver
	 */
	public void waitForElementToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(Iconstant.implicitlyWait_TimeOut, TimeUnit.SECONDS);
	}
	/**
	 * Used to wait for element to be clickable in GUI and check for specific element for every 500 milli sec
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI and check the specific element for 500 milli sec
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException 
	 */
	public void waitForElementEWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
	FluentWait wait = new FluentWait(driver);
	wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
	wait.wait(20);	
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to new window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void  switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains("partialWindowTitle")) {
				break;
			}
		}
	}
	/**
	 * used to switchto alert window and click on ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switchto alert window and click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switchto frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to switchto frame windown based on  id_name_attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switcToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s =  new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select value from the dropdown based on text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element ,String text) {
	Select s = new Select(element);
	s.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specific element 
	 * @param driver
	 * @param element
	 */
	public void mouseOverElement(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * used to execute the script by providing js
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver,String javascript) {
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript(javascript, null); 
	}
	/**
	 * used to click and hold the element for a sec
	 * @param element
	 * @throws InterruptedException 
	 */
	public void holdAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while(count <20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to take screen shot on which element we want
	 * @param driver
	 * @param screenshot
	 * @throws IOException 
	 */
	public void takeScreenShot(WebDriver driver,String screenshot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File filesrc = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshot" + screenshot + ".png");
		Files.copy(filesrc, desc);
	}
	/**
	 * used to press the enter key by using mouse over handling
	 * @param driver
	 */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   }
   
   public void validatingTheMsg(WebDriver driver) {
	   Alert alt = driver.switchTo().alert();
	   String alertmsg = alt.getText();
	   if(alertmsg.equals("Select either Organization or Contact to convert the lead")) {
		   System.out.println("Select either Organization or Contact to convert the lead" +" validattions is pass");
	   } else {
		   System.out.println("Select either Organization or Contact to convert the lead" + "validation is fail");
	   }
	   alt.accept();
   }
   public void quit(WebDriver driver) {
	   driver.quit();
   }
   public void validatingTheMsing(WebDriver driver) {
	   Alert alt = driver.switchTo().alert();
	   String alertmsg = alt.getText();
	   if(alertmsg.equals("Support End Date should be greater than or equal to Support Start Date")) {
		   System.out.println("Support End Date should be greater than or equal to Support Start Date" +" validattions is pass");
	   } else {
		   System.out.println("Support End Date should be greater than or equal to Support Start Date" + "validation is fail");
	   }	
	   alt.accept();
   }
   public void validatingTheValues(WebDriver driver) {
	   Alert alt = driver.switchTo().alert();
	   String alertmsg = alt.getText();
	   if(alertmsg.equals("Values for Mandatory Fields are missing")) {
		   System.out.println("Values for Mandatory Fields are missing" +" validattions is pass");
	   } else {
		   System.out.println("Values for Mandatory Fields are missing" + "validation is fail");
	   }	
	   alt.accept();
   
 }
}
