package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

import bsh.util.Util;

public class SubCategoriesPage extends Basetest{
	@FindBy (xpath = "//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy (xpath = "//span[normalize-space()='Masters']")
	WebElement masters;
	
	@FindBy (xpath = "//a[normalize-space()='Sub Categories']")
	WebElement subcategory;
	
	@FindBy (xpath = "//a[normalize-space()='Add New Sub Category']")
	WebElement addnewcategory;
	
	@FindBy (xpath = "//select[@id='subcatDD']")
	WebElement selectcategory;
	
	@FindBy (xpath = "//input[@id='SubCategoryName']")
	WebElement subcategoryname;
	
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
	
	public SubCategoriesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyaddnewsubcategory() throws Throwable {
		Thread.sleep(2000);
		element.click();
		masters.click();
		subcategory.click();
		Thread.sleep(2000);
		addnewcategory.click();
		
		Utils.selectDropdown(selectcategory, "BedRoom");
		subcategoryname.sendKeys(prop.getProperty("SubCategoryname"));
		Thread.sleep(2000);
		savebutton.click();
	}
	
	public void verifyeditsubcategory() throws Throwable {
		Thread.sleep(2000);
		search.sendKeys(prop.getProperty("SubCategoryname"));
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		edit.click();
		Thread.sleep(2000);
		Utils.selectDropdown(selectcategory, "BedRoom");
		Thread.sleep(2000);
		subcategoryname.clear();
		Thread.sleep(2000);
		subcategoryname.sendKeys(prop.getProperty("EditSubcategoryname"));
		Thread.sleep(2000);
		savebutton.click();
		
	}
	
	public void verifydeletesubcategory() throws Throwable {
		Thread.sleep(2000);
		search.sendKeys(prop.getProperty("EditSubcategoryname"));
		search.sendKeys(Keys.ENTER);
		delete.click();
		yes.click();
	}
}
