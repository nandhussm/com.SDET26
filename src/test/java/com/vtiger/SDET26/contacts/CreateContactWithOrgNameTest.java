package com.vtiger.SDET26.contacts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateContactWithOrgNameTest {
	@Test
public  void CreateContactWithOrgNameTest() {
	System.setProperty("webdriver.chrome.driver", "E:\\nan\\selenium auto\\chromedriver(1).exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("arilius tech pvt ltd");
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	String mainid = driver.getWindowHandle();
	Set<String> allid = driver.getWindowHandles();
	for(String id : allid) {
	if(!mainid.equals(id)) {
		driver.switchTo().window(id);
		if(driver.getTitle().equals("Organizations")) {
			
			driver.close();
			if(driver.getTitle().equals("Organizations")) {
				 System.out.println("validation is pass");
			 } else {
				 System.out.println("validation is fail");
			 }
			
		
	}
		
		
	}
	}
	 
	driver.findElement(By.xpath("//a[text()='nandhu']")).click();
	driver.switchTo().window(mainid);
	driver.findElement(By.name("button")).click();
	WebElement img1 = driver.findElement(By.xpath("(//td[@valign='bottom']//img)[2]"));
	Actions act1 = new Actions(driver);
	act1.moveToElement(img1).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
}
}


