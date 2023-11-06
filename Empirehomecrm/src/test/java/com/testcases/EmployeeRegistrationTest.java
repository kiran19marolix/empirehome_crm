package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.EmployeeRegistrationPage;
import com.pageobjects.Loginfunctionality;

public class EmployeeRegistrationTest extends Basetest{
	Loginfunctionality lp;
	EmployeeRegistrationPage er;
    public EmployeeRegistrationTest() {
    super();
    }
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	er = new EmployeeRegistrationPage();
	}
	@Test
	public void verifyemployee() throws Throwable {
	lp.verifylogin();
	er.verifyemployeereg();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();
	}
}
