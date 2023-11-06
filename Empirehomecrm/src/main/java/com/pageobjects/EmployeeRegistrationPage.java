package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;

public class EmployeeRegistrationPage  extends Basetest{
	@FindBy(xpath="//span[@class='pe-7s-keypad']")//span[@class='pe-7s-keypad']
	WebElement element;
	
	@FindBy(xpath="//span[normalize-space()='Staff']")
	WebElement staff;
	
	@FindBy(xpath="//a[normalize-space()='Add New Staff']")
	WebElement addnewstaff;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement ename;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Mail']")
	WebElement mail;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement mobnum;
	
	@FindBy(xpath="//span[@id='select2-UserTypeId-container']")
	WebElement staffdesignation;
	
	@FindBy(xpath="//div[@class='content-wrapper']")
	WebElement wrapper;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveb;
	
	public EmployeeRegistrationPage () {
		PageFactory.initElements(driver, this);
	}
	public void verifyemployeereg() throws Throwable {
		element.click();
		Thread.sleep(3000);
		staff.click();
		Thread.sleep(3000);
		addnewstaff.click();
		Thread.sleep(3000);
		ename.sendKeys(null);
		
	}
}
