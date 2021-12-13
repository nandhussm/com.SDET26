package com.vtiger.SDET26.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtiliity;

public class ConvertLeadToOpertunitiesBySelectingOnlyContactChekboxsAndFeelAllTheMandatoryFields {
	public static void main(String[] args) throws IOException {
		FileUtility fu = new FileUtility();
		WebDriverUtiliity wdu = new WebDriverUtiliity();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		int randomnum = ju.getRandomNum();
		
		String browser = fu.getPropertyKeyValue("browser");
		String url = fu.getPropertyKeyValue("url");
		String username = fu.getPropertyKeyValue("username");
		String password = fu.getPropertyKeyValue("password");
		
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		wdu.waitForPageToLoad(driver);
		driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password ,Keys.ENTER);
        
        driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("//a[text()='Arilius']")));
	    driver.findElement(By.xpath("//a[text()='Arilius']")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("//a[text()='Convert Lead']")));
	    driver.findElement(By.xpath("//a[text()='Convert Lead']")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.id("select_account")));
	    driver.findElement(By.id("select_account")).click();
	    wdu.mouseOverElement(driver,  driver.findElement(By.id("select_potential")));
	    driver.findElement(By.id("select_potential")).click();
	    wdu.mouseOverElement(driver,  driver.findElement(By.id("select_contact")));
	    driver.findElement(By.id("select_contact")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.id("select_potential")));
	    driver.findElement(By.id("select_potential")).click();
	    wdu.mouseOverElement(driver,  driver.findElement(By.id("select_contact")));
	    driver.findElement(By.id("select_contact")).click();
	    
	    driver.findElement(By.name("Save")).click();
	    
	    WebElement contact = driver.findElement(By.className("dvHeaderText"));
	    String contactpage = contact.getText();
	    System.out.println(contactpage + " page is displaying" );
	    
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("(//td[@valign='bottom']//img)[2]")));
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();    
}
}
