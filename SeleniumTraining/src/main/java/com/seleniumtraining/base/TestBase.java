package com.seleniumtraining.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.seleniumtraining.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
//synchronoize the class

Properties prop;
public static Logger log = Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
public String FilePath;
public static WebDriver driver ;
protected static ExtentReports reports;
protected static ExtentTest reportLog;

// executed before the test
	@BeforeTest
	public void launchApplication() {
		
		FilePath = System.getProperty("user.dir")
				+"\\src\\test\\resources\\Configuration.properties";
		prop = new Properties();
		try {
			prop.load(new BufferedReader(new FileReader(FilePath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browser = prop.getProperty("browser");
		String Homeurl = prop.getProperty("url");
		
		WebDriverManager.chromedriver().setup(); 
		
		if(browser.equals("chrome")) {
		
		driver = new ChromeDriver();
		log.info("===============Chrome browser Launched===============");
		}
		
		else if (browser.equals("FE")) {
			
			driver = new FirefoxDriver();	
		}
		else
		{
			
		log.info("================Not a valid browser==================");
		}
		
		driver.get(Homeurl);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	}
	
	@BeforeSuite
	public void setup() {
		  //Set log4j properties
		  PropertyConfigurator.configure("./src/test/resources/log4j.properties");
		  
		  // Set the ExtentReports
		   reports = new ExtentReports();
		   ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		   reports.attachReporter(spark);
		  
		   
		  }
		 
  
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	} 
	
	
	@AfterMethod	
	public void teardownMethod(ITestResult result)
	{
		if(result.getStatus() ==ITestResult.SUCCESS) {
			
			
			reportLog.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.takeScreenshot(driver,result.getMethod().getMethodName())).build());
		
		}
		else if (result.getStatus() ==ITestResult.FAILURE) {
			
			
			reportLog.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.takeScreenshot(driver,result.getMethod().getMethodName())).build());
		
		}	
			
		reports.flush();
	}
	
	
	
	}
