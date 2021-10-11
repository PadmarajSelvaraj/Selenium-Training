package com.seleniumtraining.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.seleniumtraining.base.TestBase;

public class Log4jListeners implements ITestListener{
	
	
	  @Override public void onFinish(ITestContext contextFinish) {
	  
	  
	  
	  //TestBase.info("==============="+"Logging Ended for"+" "+contextFinish.getName
	
	  
	  }
	  
	  @Override public void onStart(ITestContext contextStart) {
	  //TestBase.info("==============="+"Logging started for"+" "+contextStart.
	
	  
	  }
	  
	  @Override public void onTestFailedButWithinSuccessPercentage(ITestResult
	  result) {
	  
	  }
	  
	  @Override public void onTestFailure(ITestResult result) {
	  

	  
	  }
	  
	  @Override public void onTestSkipped(ITestResult result) {
	 
	  
	  
	  }
	  
	  @Override public void onTestStart(ITestResult result) {
	  
	  
	  }
	  
	  @Override public void onTestSuccess(ITestResult result) {
	  
	  
	  
	  }
	 
	
	
	}