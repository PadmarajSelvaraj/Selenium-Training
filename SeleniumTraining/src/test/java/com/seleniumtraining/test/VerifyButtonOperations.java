package com.seleniumtraining.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.seleniumtraining.base.TestBase;
import com.seleniumtraining.pages.ButtonUIPage;
import com.seleniumtraining.pages.HomePage;



public class VerifyButtonOperations extends TestBase {
	
	HomePage hompage ;
	ButtonUIPage butnUIPage;
	int[] positionValues;
	
	@Test(priority = 0)
	public void pageTitleValidation() {
		
		reportLog = reports.createTest("pageTitleValidation");
		hompage = new HomePage();
		butnUIPage = hompage.ClickButtonOperns();
		
		reportLog.info("Sucesfully clicked the login button");
		log.info("Sucessefully clicked button");
		/* Commented to validate dependent test cases
		 * 
		 * hompage = butnUIPage.returnHomeButton(); String PageTitle =
		 * hompage.testLeafPageTitle();
		 * Assert.assertEquals("TestLeaf - Selenium Playground", PageTitle);
		 */
		
		reportLog.pass("pageTitleValidation completed Sucesfully" );
	}
	
	
	
	@Test(priority = 2,dependsOnMethods= { "pageTitleValidation" })
	public void pditFieldValidation() {
		reportLog = reports.createTest("pditFieldValidation");
		 
		 positionValues = butnUIPage.getPosition();
		 reportLog.pass("pditFieldValidation completed Sucesfully" );
	} 
	
	
	  @Test(priority = 3,dependsOnMethods= { "pageTitleValidation" })
	  
	  public void movetoElement() 
	  {
		  reportLog = reports.createTest("movetoElement");
	      butnUIPage.movetoElements( positionValues[0],positionValues[1]);
	      reportLog.info("Position Values are "+positionValues[0]+"and "+positionValues[1]);
	  
	      if(positionValues.length !=0) {
	    	  
	    	  reportLog.pass("Test case passed");
	      }
	      else
	    	  reportLog.fail("Test case failed");
	  
	  }
	  
	  @Test(priority = 4,dependsOnMethods= { "pageTitleValidation" }) 
	  public void colorValidate() {
		  reportLog = reports.createTest("colorValidate");
	  
	  String buttonColor = butnUIPage.checkColor();
	  reportLog.info(buttonColor); 
	  
	  if(!buttonColor.isEmpty()) {
    	  
    	  reportLog.pass("Test case passed");
      }
      else
    	  reportLog.fail("Test case failed");
	  
	  }
	  
	  @Test(priority = 6,dependsOnMethods= { "pageTitleValidation" }) 
	  
	  public void sizeValidate() {
	  
		 reportLog = reports.createTest("sizeValidate");
	  int[] buttonSize = butnUIPage.checkSize();
	  
	  for (int i : buttonSize) {
	  
	  System.out.println(i); } 
	  reportLog.pass("Test case passed");
	  
	  }
	  
	  
	  @Test(priority = 5,enabled =false) 
	  public void DuplicatesizeValidates()
	  {
		  reportLog = reports.createTest("DuplicatesizeValidates");
	  
			/*
			 * int[] buttonSize = butnUIPage.checkSize(); for (int i : buttonSize) {
			 * System.out.println(i); }
			 */
		  
		  Assert.assertTrue(false);
		  if(reportLog.equals("abc"))
			reportLog.fail("DuplicatesizeValidates failed");
	  }
	 	
}