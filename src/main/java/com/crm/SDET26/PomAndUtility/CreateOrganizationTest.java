package com.crm.SDET26.PomAndUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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
import com.crm.comcast.pomrepositrylib.CreateNewOrganization;
import com.crm.comcast.pomrepositrylib.CreatingNewOrganization;
import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;
import com.crm.comcast.pomrepositrylib.contactinfo;
/**
 * 
 * @author Nandhu
 *
 */
public class CreateOrganizationTest extends Baseclass{	
	@Test
	public void createOrganizationTest() throws IOException {
	int randomnum = ju.getRandomNum();
	 Home hm= new Home(driver);
	 Login ln = new Login(driver);	  

	hm.getOrganizationslink().click();
	CreateNewOrganization cno = new CreateNewOrganization(driver);
	cno.getcreateimage().click();
	
	String orgname = eu.getDataFromExcel("Sheet1", 0, 0)+randomnum;

	CreatingNewOrganization cnon = new CreatingNewOrganization(driver);
	cnon.getaccountname().sendKeys(orgname);
	cnon.getbutton().click();
	
	contactinfo ci = new contactinfo(driver);
	ci.successmsg();

		}
}	
	

