package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
public  Login(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(name="user_name")
private WebElement usernameEdt;

@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@name='user_password']")})
private WebElement pwdEdt;

@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
private WebElement login;

public WebElement getusername() {
	return usernameEdt;
}
public WebElement getpassword() {
	return pwdEdt;
}
public WebElement getloginbtn() {
	return login;
}
public void logintoapp(String username,String password) {
	usernameEdt.sendKeys(username);
	pwdEdt.sendKeys(password);
	login.click();
}
}
