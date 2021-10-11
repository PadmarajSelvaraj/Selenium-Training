package com.seleniumtraining.pages;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.seleniumtraining.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;



public class ButtonUIPage extends TestBase{
	
	@FindBy(how = How.ID, using = "home" )
	WebElement homeButton;
	
	@FindBy(id ="color")
	WebElement buttonColor;
	
	@FindBy(id ="size")
	WebElement buttonSize;
	
	public ButtonUIPage() {
		
		PageFactory.initElements(driver, this);
	}

     
	public HomePage returnHomeButton()
	{
		
		
		homeButton.click();
		
		return new HomePage();
			
	}
	
	
	public String bPageTitle()
	{
		
		return driver.getTitle();
			
	}
	
	
	public int[] getPosition() {
		
	org.openqa.selenium.Point positionValues =	homeButton.getLocation();
	
	return new int[] {positionValues.x,positionValues.y};

		
		
	}
	
public void movetoElements( int x, int y) {
		
		
		Actions action = new Actions(driver);
        
        action.moveToElement(homeButton, x, y).click().build().perform();
		 
		
	} 
	
	public String checkColor() {
		
    String clors = buttonColor.getCssValue("background-color");
		
    String hexacolor = Color.fromString(clors).asHex();
    
    
    return hexacolor;
	
	}
	
	public int[] checkSize() {
		
		
		org.openqa.selenium.Dimension dm = buttonSize.getSize();
	           
		int height = dm.height;
		int width = dm.width;
		
		return new int[] {height,width};
	
		}
	
	
	}