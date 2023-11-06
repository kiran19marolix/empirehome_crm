package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

public class CategoriesPage extends Basetest{
	@FindBy (xpath = "//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy (xpath = "//span[normalize-space()='Masters']")
	WebElement masters;
	
	@FindBy (xpath = "//a[normalize-space()='Categories']")
	WebElement categories;
	
	@FindBy (xpath = "//a[normalize-space()='Add New Category']")
	WebElement addnewcategory;
	
	@FindBy (xpath = "//input[@id='CategoryName']")
	WebElement categoryname;
	
	@FindBy (xpath = "//button[normalize-space()='Save']")
	WebElement savebutton;
	
	@FindBy (xpath = "//input[@class='form-control form-control-sm']")
	WebElement search;
	
	@FindBy (xpath = "//select[@name='mydatatable_length']")
	WebElement tablelength;
	
	@FindBy (xpath = "//i[@class='fa fa-pencil']")
	WebElement edit;
	
	@FindBy (id = "preloader")
	WebElement loader;
	
	@FindBy (xpath = "//i[@class='fa fa-trash-o']")
	WebElement delete;
	
	@FindBy (xpath = "//button[@class='swal-button swal-button--yes']")
	WebElement alert;
	
	@FindBy (xpath = "//select[@name='mydatatable_length']")
	WebElement length;
	
	public CategoriesPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void common() throws Throwable {
		Thread.sleep(2000);
		element.click();
		masters.click();
		categories.click();
	}	
	public void verifyaddnewcategory() throws Throwable {	
		Thread.sleep(2000);
		addnewcategory.click();
		categoryname.sendKeys(prop.getProperty("CategoryName"));
		Thread.sleep(2000);
		savebutton.click();
	}
	public void verifyeditcategory() throws Throwable {
		search.sendKeys(prop.getProperty("CategoryName"));
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		edit.click();
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.invisibilityOf(loader));
		categoryname.clear();
		categoryname.sendKeys(prop.getProperty("editcategoryName"));
		Thread.sleep(2000);
		savebutton.click();
		WebElement Edit = driver.findElement(By.xpath("//div[@id='mydatatable_info']"));
	}
	public void verifydeletecategory() throws Throwable {
		search.sendKeys(prop.getProperty("editcategoryName"));
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Utils.selectDropdown(length, "100");
		
//		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='mydatatable']//tbody//tr"));
//		int rowsize = rows.size();
//		System.out.println(rowsize);
//		 
//		for(int i=1;i<rowsize;i++) {
//		List<WebElement> cells = rows.get(i).findElements(By.xpath(".//td"));
//		for(WebElement cell:cells) {
//		String	countries =cell.getText();
//		System.out.println(countries);
//		    
//		if(countries.equals("editcategoryName")) {
//	    WebElement checkbox = rows.get(i).findElement(By.xpath(".//i[@class='fa fa-trash-o']"));
//	    checkbox.click();
//		break;
//		}
//			 }
//		}
		delete.click();
		Thread.sleep(2000);
		alert.click();
	}
}
