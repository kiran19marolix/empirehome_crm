package com.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

public class HolidaysPage extends Basetest{
	@FindBy(xpath="//span[@class='pe-7s-keypad']")//span[@class='pe-7s-keypad']
	WebElement element;
	
	@FindBy(xpath="//span[normalize-space()='Masters']")
	WebElement master;
	
	@FindBy(xpath="//a[normalize-space()='Holidays']")
	WebElement holiday;
	
	@FindBy(xpath="//a[normalize-space()='Add New']")
	WebElement anew;
	
	@FindBy(xpath="//input[@name='HolidayDate']")
	WebElement hdate;
	
	@FindBy(xpath="//input[@id='HolidayName']")
	WebElement hname;
	
	@FindBy(xpath="//input[@id='HolidayDesc']")
	WebElement hdesc;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement sve;
	
	@FindBy(xpath="//tbody/tr[50]/td[5]/a[1]/button[1]/i[1]")
	WebElement edt;
	
	@FindBy(xpath="//tbody/tr[1]/td[5]/a[2]/button[1]/i[1]")
	WebElement delete;
	public HolidaysPage () {
	PageFactory.initElements(driver, this);
	}
	public void verifyholiday() throws Exception {
		Thread.sleep(3000);
		element.click();
		master.click();
		Thread.sleep(3000);
		holiday.click();
		Thread.sleep(3000);
		anew.click();
		Thread.sleep(3000);
		Utils.mouseHoverandClickOnElement(driver, hdate);
		hdate.sendKeys(prop.getProperty("HolidayDate"));
		hname.sendKeys(prop.getProperty("HolidayName"));
		hdesc.sendKeys(prop.getProperty("HolidayDescription"));
		sve.click();
		//hdate.sendKeys(null);
		driver.navigate().to("http://empirehome.myprojectsonline.co.in/Master/HolidayTypedata?id=23");
		hdate.sendKeys(prop.getProperty("edithdate"));
		hdate.sendKeys(prop.getProperty("edithname"));
		hdate.sendKeys(prop.getProperty("edithdes"));
		sve.click();
		driver.navigate().to("http://empirehome.myprojectsonline.co.in/Master/Holidays");
		Thread.sleep(3000);
		delete.click();
		
	}
}