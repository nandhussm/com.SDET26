package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactinfo {
public contactinfo(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(className="dvHeaderText")
private WebElement text;

public WebElement gettext() {
	return text;
}
public void successmsg() {
	String successsmsg = text.getText();
	System.out.println(successsmsg);
}
}
