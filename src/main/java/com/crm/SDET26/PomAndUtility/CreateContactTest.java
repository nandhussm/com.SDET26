package com.crm.SDET26.PomAndUtility;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
import com.crm.comcast.pomrepositrylib.CreatatingnewContact;
import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;
import com.crm.comcast.pomrepositrylib.contactinfo;
@Test
public class CreateContactTest extends Baseclass {
	public void CreateContact() throws IOException  {
	       int randomnum = ju.getRandomNum();
			Login ln = new Login(driver);
		    
			Home hm= new Home(driver);
			hm.getContacts().click();
			
			String lastname =  eu.getDataFromExcel("Sheet1", 0, 0) + randomnum;
			
			CreatatingnewContact cnc = new CreatatingnewContact(driver);
			cnc.getcreatecontact().click();
			cnc.getlastname().sendKeys(lastname);
		    cnc.getbutton().click();
		    contactinfo ci = new contactinfo(driver);
			ci.successmsg();
	}
}
