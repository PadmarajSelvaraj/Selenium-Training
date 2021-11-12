package com.seleniumtraining.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.seleniumtraining.base.TestBase;
import com.seleniumtraining.pages.FieldsPage;

import com.seleniumtraining.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class VerifyEditOperationsTest extends TestBase {
	HomePage page ;
	FieldsPage fp;
	
	
	@Test (priority =0)
	public void PageTitleValidation() {
		reportLog = reports.createTest("PageTitleValidation");
		 page = new HomePage();
		 fp = page.ClickEditButton();
		 
		String PageTitle = fp.FieldsPageTitle();
		
		Assert.assertEquals("TestLeaf - Interact with Edit Fields", PageTitle);
		 
		if (PageTitle.equals("TestLeaf - Interact with Edit Fields")){
			
			reportLog.pass("Test case passed");
		}	
		else
				
			reportLog.fail("Test case failed");
				
			
		}
		
	
	
	
	@Test(priority =1)
	public void EditFieldValidation() {
		
		reportLog = reports.createTest("EditFieldValidation");
		fp.EnterEmailadress();
		 
		String actualString = fp.Appendtext("Hello Selenium");
		
		String eValues = fp.CheckClearvales();
		
		
		
		//assertTrue(actualString.contains("Hello Selenium"));
		
		assertTrue(actualString.contains("america"));
		Assert.assertEquals("", eValues);
		
		assertFalse(fp.CheckEditField());
		
        if (actualString.contains("america ")){
			
			reportLog.pass("Test case passed");
		}	
		else
				
			reportLog.fail("Test case failed");
		 
	}
	
	}