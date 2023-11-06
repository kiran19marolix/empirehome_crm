package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.LocationPage;
import com.pageobjects.Loginfunctionality;

public class LocationTest extends Basetest{
	LocationPage location;
	Loginfunctionality lf;
	
	public LocationTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		
		initialization();
		lf = new Loginfunctionality();
		lf.verifylogin();
		location = new LocationPage();
	}
	
	@Test (priority = 1)
	public void addnewlocationvalidation() throws Throwable {
		location.verifyaddnewlocation();
		List<WebElement> records = driver.findElements(By.tagName("tr"));
		int recordcount = records.size();
	    Assert.assertEquals(recordcount, 82);
	}
	
	@Test (priority = 2)
	public void editlocationvalidation() throws Throwable {
		location.verifyeditlocation();
		String urltest = driver.getCurrentUrl();
		Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/Master/Loctation");
	}
	@Test (priority = 3)
	public void deletelocationvalidation() throws Throwable {
		location.verifydeletelocation();
		List<WebElement> records = driver.findElements(By.tagName("tr"));
		int recordcount = records.size();
	    Assert.assertEquals(recordcount, 81);
	}

}
