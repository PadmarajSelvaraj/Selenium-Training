package com.seleniumtraining.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.seleniumtraining.base.TestBase;



public class FieldsPage extends TestBase {
	

	@FindBy(id ="email")
	WebElement Email;

	@FindBy(xpath="//label[text() ='Append a text and press keyboard tab']/following::input")
	WebElement Edittxt;

	@FindBy(xpath= "//label[text() ='Clear the text']/following::input[1]")
	WebElement Clrtxt;
	
	@FindBy(css = "input[disabled ='true']" )
	WebElement Enabledtxt;
	
	public FieldsPage() {
		PageFactory.initElements(driver, this);
	}

	


	public String FieldsPageTitle()
	{
		return driver.getTitle();
			
	}
	
	public void EnterEmailadress() {
		
	
		Email.sendKeys("s.padmaraj@gmail.com");
		
	}
		
	public String Appendtext(String Appendtxt) {
		
		Edittxt.sendKeys(Appendtxt,Keys.TAB);
		
		Edittxt.getAttribute("value");
		
		return Edittxt.getAttribute("value");
		
	}
	
	public String CheckClearvales() {
	
		Clrtxt.clear();
	
	    return Clrtxt.getText();
	
	}
	
	public boolean	CheckEditField() {
	
	return Enabledtxt.isEnabled();
		
	
		}
	}