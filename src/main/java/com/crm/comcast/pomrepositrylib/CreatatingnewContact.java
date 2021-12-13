package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtiliity;

public class CreatatingnewContact extends WebDriverUtiliity {
	WebDriver driver;
       public CreatatingnewContact(WebDriver driver) {
    	   this.driver=driver;
    	   PageFactory.initElements(driver, this);
       }
       @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']/../..")
       private WebElement createcontact;
       
       
       @FindBy(name="lastname")
       private WebElement lastname;
       
       @FindBy(id="mobile")
       private WebElement mobile;
       
       @FindBy(name="button")
       private WebElement button;
       
       @FindBy(id="jscal_field_support_end_date")
       private WebElement supportdate;
       
       public WebElement getcreatecontact()  {
    	   return createcontact;
       }
      
       public WebElement getlastname() {
    	   return lastname;
       }
       public WebElement getmobile() {
    	   return mobile;
       }
     
       public WebElement getsupportdate() {
    	   return supportdate;
       }
       public WebElement getbutton() {
    	   return button;
       }
       public void creatingaccount(String enterlastname, String mobilenum) {
    	   lastname.sendKeys(enterlastname);
    	   mobile.sendKeys(mobilenum);
       }
       public void clickingsupportdate(String date) {
    	   supportdate.clear();
    	   supportdate.click();
    	   supportdate.sendKeys(date);	   
       }
	
       
       
       
       
       
       
       
       
       
       
}
