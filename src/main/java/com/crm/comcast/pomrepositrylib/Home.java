package com.crm.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver ;
    public Home(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Organizations")
    private WebElement Organizationslink;
    
    @FindBy(linkText="Products")
    private WebElement Productslink;
    
    @FindBy(linkText="Leads")
    private WebElement Leads;
    
    @FindBy(linkText="Contacts")
    private WebElement Contacts;
    
    @FindBy(linkText="Opportunities")
    private WebElement Opportunities;
    
    @FindBy(linkText="Invoice")
    private WebElement Invoice;  
    
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
     private WebElement administratorimg;
    
    @FindBy(linkText="Sign Out")
    private WebElement SignOut;
    
    @FindBy(linkText="Purchase Order")
    private WebElement PurchaseOrder;
    
    public WebElement getOrganizationslink() {
		return Organizationslink;
    	}
    public WebElement getProductslink() {
		return Productslink;
    }
    public WebElement getLeads() {
		return Leads;
    }
    public WebElement getContacts() {
		return Contacts;
    }
    public WebElement getOpportunities() {
		return Opportunities;
    }
    public WebElement getInvoice() {
		return Invoice;
    }
    public WebElement getadministratorimg() {
		return administratorimg;
    }
    public WebElement getSignOut() {
		return SignOut;
    }
    public WebElement getPurchaseOrder() {
		return PurchaseOrder;
    }
    public void Organizationslink() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Organizationslink).click();
    }
    public void Leads() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Leads).click();
    }
    public void Contacts() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Contacts).click();
    }
    public void Opportunities() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Opportunities).click();
    }
    public void Invoice() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Invoice).click();
    }
    public void administratorimg() {
    	Actions act = new Actions(driver);
    	act.moveToElement(administratorimg).perform();
    }
    public void SignOut() {
    	Actions act = new Actions(driver);
    	act.moveToElement(SignOut).perform();
    }
    public void PurchaseOrder() {
    	Actions act = new Actions(driver);
    	act.moveToElement(PurchaseOrder).click();
    }
    public void Productslink() {
    	Actions act = new Actions(driver);
    	act.moveToElement(Productslink).click();
    }
}
   
