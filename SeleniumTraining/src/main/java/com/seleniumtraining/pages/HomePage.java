package com.seleniumtraining.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumtraining.base.TestBase;




public class HomePage extends TestBase {
	
	
	//WebDriver driver;
	
    @FindBy(xpath="//h5[@class='wp-categories-title']/following::h5[1]")
    WebElement button;
	//WebDriver drivers;
    @FindBy(xpath="//h5[@class='wp-categories-title'][text() = 'Edit']")
    WebElement Editbutton;

	public HomePage() {
		
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ButtonUIPage ClickButtonOperns() {
		
		button.click();
		return new ButtonUIPage();
	
	}

	
	public String testLeafPageTitle()
	{
		
		return driver.getTitle();
			
	}
	

	public FieldsPage ClickEditButton() {
		Editbutton.click();
		return new FieldsPage();
		
		
	}
	
	}