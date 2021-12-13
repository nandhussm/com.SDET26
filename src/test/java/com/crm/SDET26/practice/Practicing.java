package com.crm.SDET26.practice;

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

public class Practicing {
public static void main(String[] args) throws IOException {
	ExcelUtility eu = new ExcelUtility();
	FileUtility fu = new FileUtility();
	WebDriverUtiliity wdu = new WebDriverUtiliity();
	JavaUtility ju = new JavaUtility();
	
	int randomnum = ju.getRandomNum();
	
	String lastname = eu.getDataFromExcel("Sheet1", 2, 1) +randomnum;
	
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
    //wdu.mouseOverElement(driver, driver.findElement(By.xpath("//a[text()=' " + lastname + "']")));
    driver.findElement(By.xpath("//a[text()=' " + lastname + "']")).click();
   
	
}

}
