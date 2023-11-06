package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

public class ShiftsPage extends Basetest{
	@FindBy (xpath = "//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy (xpath = "//span[normalize-space()='Masters']")
	WebElement masters;
	
    @FindBy (xpath = "//a[text()='Shifts']")
	WebElement shifts;
    
    @FindBy (xpath = "//a[normalize-space()='Add New']")
    WebElement addnew;
    
    @FindBy (xpath = "//input[@id='ShiftName']")
    WebElement shiftname;
    
    @FindBy (xpath = "//input[@name='StartTime']")
    WebElement starttime;
    
    @FindBy (xpath = "//input[@name='EndTime']")
    WebElement endtime;
    
    @FindBy (xpath = "//button[normalize-space()='Save']")
    WebElement savebutton;
    
    @FindBy (xpath = "//input[@class='form-control form-control-sm']")
    WebElement search;
    
    @FindBy (xpath = "//i[@class='fa fa-pencil']")
    WebElement edit;
    
    @FindBy (xpath = "//i[@class='fa fa-trash-o']")
	WebElement delete;
	
	@FindBy (xpath = "//button[@class='swal-button swal-button--yes']")
	WebElement yes;
	
	@FindBy (xpath = "//select[@name='mydatatable_length']")
	WebElement length;
    
    public ShiftsPage() {
    	PageFactory.initElements(driver, this);
    }
    public void verifyaddnewshift() throws Throwable {
    	Thread.sleep(2000);
    	element.click();
    	masters.click();
    	shifts.click();
    	Thread.sleep(2000);
    	addnew.click();
    	Thread.sleep(2000);
    	shiftname.sendKeys(prop.getProperty("ShiftName"));
    	starttime.sendKeys(prop.getProperty("StartTime"));
    	endtime.sendKeys(prop.getProperty("EndTime"));
    	Thread.sleep(2000);
    	savebutton.click();
    	Utils.selectDropdown(length, "100");
    }
    public void verifyeditshift() throws Throwable {
    	Thread.sleep(2000);
    	search.sendKeys(prop.getProperty("ShiftName"));
    	search.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	edit.click();
    	shiftname.clear();
    	shiftname.sendKeys(prop.getProperty("EditShiftName"));
    	starttime.sendKeys(prop.getProperty("StartTime"));
    	endtime.sendKeys(prop.getProperty("EndTime"));
    	Thread.sleep(2000);
    	savebutton.click();
    }
    public void verifydeleteshift() throws Throwable {
    	Thread.sleep(2000);
    	search.sendKeys(prop.getProperty("EditShiftName"));
    	search.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	delete.click();
    	Thread.sleep(2000);
    	yes.click();
    	Thread.sleep(2000);
    	Utils.selectDropdown(length, "100");
    }
}
