package com.seleniumtraining.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenerAnalyser implements IRetryAnalyzer {

	int count =1;
	int retry =3;
	
	public boolean retry(ITestResult result) {
		if(count < retry) {
			count ++;
			return true;
		}
		return false;
	}

}
