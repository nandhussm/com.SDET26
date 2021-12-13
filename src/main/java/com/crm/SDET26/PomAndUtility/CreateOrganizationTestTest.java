package com.crm.SDET26.PomAndUtility;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
import com.crm.comcast.pomrepositrylib.CreateNewOrganization;
import com.crm.comcast.pomrepositrylib.CreatingNewOrganization;
import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;
import com.crm.comcast.pomrepositrylib.OrganizationInfo;
import com.crm.comcast.pomrepositrylib.contactinfo;

public class CreateOrganizationTestTest extends Baseclass {
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
