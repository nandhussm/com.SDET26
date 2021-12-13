package com.vtiger.SDET26.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtiliity;
import com.crm.comcast.pomrepositrylib.ConvertLeadToOrganization;
import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;
@Test
public class ConvertLeadToOpertunitiesBySelectingOrganisationAndContactChekboxsAndFeelAllTheMandatoryFields extends Baseclass{
	public void ConvertLeadToOpertunitiesBySelectingOrganisationAndContactChekboxsAndFeelAllTheMandatoryFields() {
	Login ln = new Login(driver);
	
	Home hme = new Home(driver);
	hme.getLeads().click();
	
ConvertLeadToOrganization clto = new ConvertLeadToOrganization(driver);
	clto.getArilius().click();
	clto.getConvertLead().click(); 
	 clto.getselectpotential().click();
	 clto.getselectaccount().click();
	 clto.Save();
      /*  driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("//a[text()='Arilius']")));
	    driver.findElement(By.xpath("//a[text()='Arilius']")).click();
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("//a[text()='Convert Lead']")));
	    driver.findElement(By.xpath("//a[text()='Convert Lead']")).click();
	    wdu.mouseOverElement(driver,  driver.findElement(By.id("select_potential")));
	    driver.findElement(By.id("select_potential")).click();
	    wdu.mouseOverElement(driver,  driver.findElement(By.id("select_potential")));
	    driver.findElement(By.id("select_potential")).click();
	    
	    driver.findElement(By.name("Save")).click();
	    
	    WebElement org = driver.findElement(By.className("dvHeaderText"));
	    String organization = org.getText();
	    System.out.println(organization + " page is displaying" );
	   
	    wdu.mouseOverElement(driver, driver.findElement(By.xpath("(//td[@valign='bottom']//img)[2]")));
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();    */
}
}
