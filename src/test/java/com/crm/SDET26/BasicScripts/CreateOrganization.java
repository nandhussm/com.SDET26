package com.crm.SDET26.BasicScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtiliity;

public class CreateOrganization {
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
}
}
