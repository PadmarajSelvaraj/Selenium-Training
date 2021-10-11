package com.seleniumtraining.utils;



import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import org.testng.annotations.Test;

public class TestUtils  {

	
	public static String takeScreenshot(WebDriver driver, String Filename) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String scrnpath = System.getProperty("user.dir")+"\\Screenshots\\"+ Filename+".png";	
		try {
		//FileHandler.copy(src, new File(scrnpath));
			FileUtils.copyFile(src, new File(scrnpath));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return scrnpath;
		
	}
	
	
	public static LocalDateTime getCurrentDate() {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime date = LocalDateTime.now();  
		 return date;
	}

}
