package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

public class LogoutPage extends Basetest {
	   @FindBy(xpath="//img[@alt='user']")
	   WebElement logicon;
	   
	   @FindBy(xpath="//a[normalize-space()='Signout']")
	   WebElement signout;
	   
	   public LogoutPage() {           //constructor
		   PageFactory.initElements(driver,this);
	   }
	   public void verifylogout() throws Throwable {
		  Thread.sleep(3000);
		  logicon.click();
		  Thread.sleep(3000);
		  signout.click();
	   }
}
