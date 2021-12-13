package com.vtiger.SDET26.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
public class ConvertLeadToOpertunitiesBySelectingOrganisationAndOpertunityTheChekboxsAndFeelAllTheMandatoryFields extends Baseclass {
public void ConvertLeadToOpertunitiesBySelectingOrganisationAndOpertunityTheChekboxsAndFeelAllTheMandatoryFields() {
			Login ln = new Login(driver);
			
			Home hme = new Home(driver);
			hme.getLeads().click();
			
		ConvertLeadToOrganization clto = new ConvertLeadToOrganization(driver);
			clto.getArilius().click();
			clto.getConvertLead().click();
		     clto.getselectpotential().click();
		     clto.getselectaccount().click();
		     clto.Save();
			  wdu.validatingTheValues(driver);
			 
			 
}
}