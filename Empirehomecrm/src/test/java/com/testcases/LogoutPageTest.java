package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.Loginfunctionality;
import com.pageobjects.LogoutPage;

public class LogoutPageTest extends Basetest{
	Loginfunctionality lp;
	LogoutPage lo;
    public LogoutPageTest() {
    super();
    }
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	lo = new LogoutPage();
	}
	@Test
	public void verifylogout() throws Throwable {
	lp.verifylogin();
	lo.verifylogout();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();
	}

}
