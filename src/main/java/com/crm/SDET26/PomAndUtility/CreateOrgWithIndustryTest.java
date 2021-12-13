package com.crm.SDET26.PomAndUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.crm.comcast.pomrepositrylib.OrganizationInfo;
import com.crm.comcast.pomrepositrylib.contactinfo;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
/**
 * 
 * @author Nandhu
 *
 */
public class CreateOrgWithIndustryTest extends Baseclass {
@Test
public void CreateOrgWithIndustry() throws IOException {
	int randomnum = ju.getRandomNum();
	Login ln = new Login(driver);
	
	Home hm= new Home(driver);
	hm.getOrganizationslink().click();
	CreateNewOrganization cno = new CreateNewOrganization(driver);
	cno.getcreateimage().click();
	
	 String orgname = eu.getDataFromExcel("Sheet1", 0, 0)+randomnum;
	 String industry = eu.getDataFromExcel("Sheet1", 0, 1) + randomnum;
	
	CreatingNewOrganization cnon = new CreatingNewOrganization(driver);
	cnon.getaccountname().sendKeys(orgname);
	cnon.industry(null, 10);
    cnon.getbutton().click();
    
    OrganizationInfo oi = new OrganizationInfo(driver);
    contactinfo ci = new contactinfo(driver);
	ci.successmsg();
	
}

}
