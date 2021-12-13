package com.crm.SDET26.practice;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
@Listeners(com.crm.comcast.genericUtility.LisImpClass.class)
public class SampleTest extends Baseclass{
  @Test
  public void validating() {
	  System.out.println("========test start===========");
	  Assert.assertEquals(false, true);
  }
}
