package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLeadToOrganization {
	WebDriver driver;
       public ConvertLeadToOrganization(WebDriver driver) {
    	   PageFactory.initElements(driver, this);
       }
       @FindAll({@FindBy(linkText="Arilius"),@FindBy(xpath="//a[text()='Arilius']")})
       private WebElement Arilius;
       
       @FindBy(linkText="Convert Lead")
       private WebElement ConvertLead;
       
       @FindAll({@FindBy(id="select_potential"),@FindBy(xpath="//input[@id='select_potential']")})
       private WebElement selectpotential;
       
       @FindAll({@FindBy(id="select_account"),@FindBy(xpath="//input[@id='select_account']")})
       private WebElement selectaccount;
       
       @FindAll({@FindBy(id="select_contact"),@FindBy(xpath="//input[@id='select_contact']")})
       private WebElement selectcontact;
       
       @FindAll({@FindBy(id="jscal_trigger_closedate"),@FindBy(xpath="//img[@id='jscal_trigger_closedate']")})
       private WebElement jscaltriggerclosedate;
       
       @FindBy(xpath ="//td[@class='day selected today' or @class='day weekend']")
       private WebElement dayselectedtoday;
       
       @FindBy(name="Save")
       private WebElement Save;
       
       public WebElement  getArilius() {
		return Arilius;	   
       }
       public WebElement getConvertLead() {
    	   return ConvertLead;
       }
       public WebElement getselectpotential() {
    	   return selectpotential;
       }
       public WebElement getselectaccount() {
    	   return selectaccount;
       }
       public WebElement getselectcontact() {
    	   return selectcontact;
       }
       public WebElement getjscaltriggerclosedate() {
    	   return jscaltriggerclosedate;
       }
       public WebElement getdayselectedtoday() {
    	   return dayselectedtoday;
       }
       
       
       public void Arilius() {
    	   Actions act = new Actions(driver);
    	   act.moveToElement(Arilius).perform();
       }
       public void ConvertLead() {
    	   Actions act = new Actions(driver);
    	   act.moveToElement(ConvertLead).perform();
       }
       public void selectpotential() {
    	   selectpotential.click();
       }
       public void selectaccount() {
    	   selectaccount.click();
       }
       public void selectcontact() {
    	   selectcontact.click();
       }
       public void jscaltriggerclosedate() {
    	   jscaltriggerclosedate.click();
       }
       public void dayselectedtoday() {
    	   dayselectedtoday.click();
       }  
       public void Save() {
    	   Save.click();
       }
       }