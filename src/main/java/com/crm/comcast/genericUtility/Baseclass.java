package com.crm.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.pomrepositrylib.Home;
import com.crm.comcast.pomrepositrylib.Login;

public class Baseclass {
	public WebDriver driver = null;
	public FileUtility fu = new FileUtility();
	public WebDriverUtiliity wdu = new WebDriverUtiliity();
	public JavaUtility ju = new JavaUtility();
	public ExcelUtility eu = new ExcelUtility();
	public static  WebDriver sdriver;
     @BeforeSuite(groups="ST")
     public void  openDBConnection() {
    	 System.out.println("before suite");
    	 System.out.println("-----------------------db connection--------------------------");
    	 System.out.println("=======================================");
     }
    // @Parameters ("browser")
     @BeforeClass(groups="ST")
     public void launchBrowser() throws IOException {
    	 System.out.println("before class");
    	String browser = fu.getPropertyKeyValue("browser");
    		String url = fu.getPropertyKeyValue("url");
    		
    		if(browser.equals("chrome")) {
    			driver = new ChromeDriver();
    		} else if(browser.equals("firefox")) {
    			driver=new FirefoxDriver();
    		}
    		wdu.waitForPageToLoad(driver);
    		driver.get(url);
    		sdriver=driver;
    		driver.manage().window().maximize();
    		System.out.println("=====================================");
     }
     @BeforeMethod(groups="ST")
     public void loginToApp() throws IOException {
    	 System.out.println("before Method");
    	 String username = fu.getPropertyKeyValue("username");
    		String password = fu.getPropertyKeyValue("password");
    		Login ln = new Login(driver);	  
    		ln.logintoapp(username, password);
    		System.out.println("=====================================");
     }
     @AfterMethod(groups="ST")
     public void logoutToApp() {
    	 System.out.println("AfterMethod"); 	
    	 Home hm= new Home(driver);
    	 hm.administratorimg();
    	  hm.getSignOut().click();
    	  System.out.println("======================================");
     }
     @AfterClass(groups="ST")
     public void closeTheBrowser() {
    	 System.out.println("After Class");
    	 wdu.quit(driver);
    	 System.out.println("=======================================");
     }
     @AfterSuite(groups="ST")
     public void closeDBConnection() {
    	 System.out.println("After Suite");
    	 System.out.println("==============DB Connection====================");	 
     }
}
