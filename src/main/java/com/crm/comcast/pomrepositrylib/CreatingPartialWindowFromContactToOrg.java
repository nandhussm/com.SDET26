package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingPartialWindowFromContactToOrg {
      WebDriver driver ;
	public CreatingPartialWindowFromContactToOrg(WebDriver driver) {
		this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
    private WebElement lookup;
    
    @FindBy(id="search_txt")
    private WebElement searchtext;
    
    @FindBy(name="search")
    private WebElement search;
    
    @FindBy(xpath = "//a[text()='Test yantra']")
    private WebElement searching;
    
    public WebElement getlookup() {
 	   return lookup;
    }
    public WebElement getsearchtxt() {
    	return searchtext;
    }
    public WebElement getsearch() {
    	return search;
    }
    public WebElement getsearching() {
    	return searching;
    }
    
    public void searching(String orgname)
    {
    	searchtext.sendKeys(orgname);	
    }
    	
}
