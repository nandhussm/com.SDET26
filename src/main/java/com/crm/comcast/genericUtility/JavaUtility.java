package com.crm.comcast.genericUtility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Nandhu
 *
 */
public class JavaUtility {
/**
 * its used to generate the integer random number with the boundary of 0 to 10000
 * return 
 */
	public int getRandomNum() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(10000);
		return randomNumber;
	}
	/**
	 * its used to get current date and time
	 *  return 
	 */
	public String  getSystemDate() {
		Date date = new Date();
    	String systemdateandtime = date.toString();
		return systemdateandtime;
	}
	/**
	 * its used to get current date and time with YYYY-MM-DD format
	 * return
	 */
	public String getSystemDate_YYYY_MM_DD() {
		Date date = new Date();
		String systemdateandtime= date.toString();
		System.out.println(systemdateandtime);
		String[] arr = systemdateandtime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth()+1;
		String finalfomart =YYYY + "-" +MM + "-" + DD;
		return finalfomart;
	}
	/**
	 * used to pass virtual key to OS
	 * @throws AWTException 
	 */
	public void pressVirtualEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
