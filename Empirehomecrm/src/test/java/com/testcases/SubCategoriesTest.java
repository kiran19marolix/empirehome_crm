package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.Loginfunctionality;
import com.pageobjects.SubCategoriesPage;

public class SubCategoriesTest extends Basetest{
	Loginfunctionality lf;
	SubCategoriesPage sp;
	
	public SubCategoriesTest() {
		super();
	}
	
	@BeforeTest
	public void setup()  {
		initialization();
		lf = new Loginfunctionality();
		lf.verifylogin();
		sp = new SubCategoriesPage();
	}
	
	@Test (priority = 1)
	public void addsubcategoryvalidation() throws Throwable {
		sp.verifyaddnewsubcategory();
		List<WebElement> records = driver.findElements(By.tagName("tr"));
		int recordcount = records.size();
	    Assert.assertEquals(recordcount, 2);
	}
	
	@Test (priority = 2)
	public void editsubcategoryvalidation() throws Throwable {
		sp.verifyeditsubcategory();
		String urltest = driver.getCurrentUrl();
		Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/Master/Subcategories?catId=527");
	}
	
	@Test (priority = 3)
	public void deletesubcategoryvalidation() throws Throwable {
		sp.verifydeletesubcategory();
		List<WebElement> records = driver.findElements(By.tagName("tr"));
		int recordcount = records.size();
	    Assert.assertEquals(recordcount, 1);
	}
}
