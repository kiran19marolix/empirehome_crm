package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.CompanyPage;
import com.pageobjects.Loginfunctionality;

public class CompanyTest extends Basetest{
	Loginfunctionality lf;
	CompanyPage cp;

	public CompanyTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		lf = new Loginfunctionality();
		lf.verifylogin();
		cp = new CompanyPage();
	}

	@Test
	public void editcompanyvalidation() throws Throwable {

		cp.verifyeditcompany();

		List<WebElement> rows = driver.findElements(By.xpath(".//td[normalize-space()='KIERON']"));

		if (rows.isEmpty()) {

			Assert.fail("No rows found");
		} else {

			String expectedTest = "KIERON";

		}
		for (WebElement row : rows) {
			String actualText = row.getText();
			System.out.println(actualText);
		}
	}
}
