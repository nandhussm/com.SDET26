package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
public CreateNewOrganization(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
   @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']/../..")
   private WebElement createimage;
   
   public WebElement getcreateimage() {
	   return createimage;
	   
	   
   }
}
