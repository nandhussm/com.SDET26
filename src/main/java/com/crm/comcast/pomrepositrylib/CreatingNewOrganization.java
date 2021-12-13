package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericUtility.WebDriverUtiliity;

public class CreatingNewOrganization{
         public CreatingNewOrganization(WebDriver driver) {
        	 PageFactory.initElements(driver, this);
         }
         @FindBy(name="accountname")
         private WebElement accountname;
         
         @FindBy(name="button")
         private WebElement button;
         
         @FindBy(name="industry")
         private WebElement industry;
         
         public WebElement getaccountname() {
        	 return accountname;
         }
         public WebElement getbutton() {
        	 return button;
         }
         public WebElement getindustry() {
        	 return industry;
         }
         public void savingbtn(String orgname ) {
        	 accountname.sendKeys(orgname);
        	 button.click();
         }
         public void industry(WebElement  element,int index) {
        	 Select s = new Select(industry);
        	 s.selectByIndex(index);
        	 
         }
}
