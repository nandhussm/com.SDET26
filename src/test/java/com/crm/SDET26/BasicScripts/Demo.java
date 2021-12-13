package com.crm.SDET26.BasicScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
@Test(retryAnalyzer = com.crm.comcast.genericUtility.RetryImpClass.class)
public class Demo  extends Baseclass{
	public void demo() {
		Assert.assertEquals(true, false);
	}

}
