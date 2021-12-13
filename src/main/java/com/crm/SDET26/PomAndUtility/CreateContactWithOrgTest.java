package com.crm.SDET26.PomAndUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtiliity;
import com.crm.comcast.pomrepositrylib.CreatatingnewContact;
import com.crm.comcast.pomrepositrylib.CreatingPartialWindowFromContactToOrg;
import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;
import com.crm.comcast.pomrepositrylib.contactinfo;
/**
 * 
 * @author Nandhu
 *
 */
public class CreateContactWithOrgTest extends Baseclass  {
	@Test
	public void CreateContactWithOrgTest() throws IOException {
		Login ln = new Login(driver);
	    
		Home hm= new Home(driver);
		hm.getContacts().click();
		
String lastname =  eu.getDataFromExcel("Sheet1", 0, 0) ;
CreatingPartialWindowFromContactToOrg   cpwfcto = new CreatingPartialWindowFromContactToOrg(driver);
		CreatatingnewContact cnc = new CreatatingnewContact(driver);
		cnc.getcreatecontact().click();
		cnc.getlastname().sendKeys(lastname);
	     cpwfcto.getlookup().click();
	    
	    wdu.switchToWindow(driver, "Accounts");
	    cpwfcto.getsearchtxt().click();
	    
	    String orgname = eu.getDataFromExcel("Sheet1", 0, 2);
	    
	    cpwfcto.searching(orgname);
	    cpwfcto.getsearching().click();
	   wdu.switchToWindow(driver, "Contacts"); 
	    cnc.getbutton().click();
	    contactinfo ci = new contactinfo(driver);
		ci.successmsg();	
		
		}
}





























