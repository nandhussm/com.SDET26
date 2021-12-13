package com.vtiger.SDET26.contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTestTest {
public static void main(String[] args) throws Throwable {
		 	Random ran = new Random();
		     int ranDomNun = ran.nextInt(10000);
	
		FileInputStream fis= new FileInputStream("./Commondatttaaa.Properties");
		Properties pObj = new Properties();
		 pObj.load(fis);
		 String BROWER = pObj.getProperty("browser");
		 String URL = pObj.getProperty("url");
		 String USERNAME = pObj.getProperty("username");
		 String PASSWORD = pObj.getProperty("password");
		 
		
			FileInputStream efis= new FileInputStream("./Book2.xlsx.xlsx");
		    Workbook wb =  WorkbookFactory.create(efis);
            Sheet sh =  wb.getSheet("Sheet1");
		    Row row = sh.getRow(1);
		    String lastname = row.getCell(2).getStringCellValue() + ranDomNun;
		    wb.close();
		   
		 
         
         /* launch the Browser */ 
         WebDriver driver = null;
         if(BROWER.equals("chrome")) {
              driver = new ChromeDriver();
         }else if(BROWER.equals("firefox")){
        	  driver = new FirefoxDriver();
         }
                   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   driver.get(URL);
    
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         
         driver.findElement(By.linkText("Contacts")).click();

        
         driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
         
      
         driver.findElement(By.name("lastname")).sendKeys(lastname);
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

    
        String actOrgName =  driver.findElement(By.className("dvHeaderText")).getText();
        if (actOrgName.contains(lastname)) {
			System.out.println(lastname + "org is created==PASs");
		}else{
			System.out.println(lastname + "org is not created==FAIL");

		}
  
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.close();

	}
}
