package com.crm.SDET26.PomAndUtility;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
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
public class CreateContactWithSupportDateTest extends Baseclass {
	@Test
	public void CreateContactWithSupportDateTest() throws IOException  {
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
