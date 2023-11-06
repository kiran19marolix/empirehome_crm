package com.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;

public class Loginfunctionality extends Basetest {

   @FindBy (xpath="//input[@placeholder='example@gmail.com']")   
   WebElement userid;
	
   @FindBy (name="pword")
   WebElement pass;
  
   @FindBy (xpath="//button[text()='Login']")
   WebElement loginbutton;
   
   public Loginfunctionality() {           //constructor
	   PageFactory.initElements(driver,this);
   }
   
   public void verifylogin() {
	  userid.sendKeys(prop.getProperty("username")); 
	  pass.sendKeys(prop.getProperty("password"));
	  loginbutton.click();
   }
   
	public void verifylogindata(String username, String password) {
		userid.sendKeys(username); 
		   pass.sendKeys(password);
		   loginbutton.click();
   // String str = driver.getCurrentUrl();		   
    //assertEquals("http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard", str);	   
	}
}
