package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;

public class CompanyPage extends Basetest{
	@FindBy (xpath = "//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy (xpath = "//span[normalize-space()='Masters']")
	WebElement masters;
	
	@FindBy (xpath = "//a[normalize-space()='Company']")
	WebElement company;
	
	@FindBy (xpath = "//i[@class='fa fa-pencil']")
	WebElement edit;
	
	@FindBy (xpath = "//input[@placeholder='Enter Company Name']")
	WebElement companyname;
	
	@FindBy (xpath = "//input[@placeholder='Enter CEO Name']")
	WebElement ceoname;
	
	@FindBy (xpath = "//input[@placeholder='Enter CEO Email']")
	WebElement ceomail;
	
	@FindBy (xpath = "//input[@placeholder='Enter CEO Number']")
	WebElement ceonumber;
	
	@FindBy (xpath = "//button[normalize-space()='Save']")
	WebElement savebutton;
	
	
	public CompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyeditcompany() throws Throwable {
		
		Thread.sleep(2000);
		element.click();
		masters.click();
		company.click();
		
		Thread.sleep(2000);
		edit.click();
		
		Thread.sleep(2000);
		companyname.clear();
		companyname.sendKeys(prop.getProperty("CompanyName"));
		
		Thread.sleep(2000);
		ceoname.clear();
		ceoname.sendKeys(prop.getProperty("CEOname"));
		
		Thread.sleep(2000);
		ceomail.clear();
		ceomail.sendKeys(prop.getProperty("CEOmail"));
		
		Thread.sleep(2000);
		ceonumber.clear();
		ceonumber.sendKeys(prop.getProperty("CEOnumber"));
		
		Thread.sleep(2000);
		savebutton.click();
		
	}
}
