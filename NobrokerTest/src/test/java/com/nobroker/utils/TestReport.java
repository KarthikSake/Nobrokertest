package com.nobroker.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestReport extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		testLog = extentReporter.createTest(result.getName());
		testLog.info(result.getName() + " Started");
	}

	public void onTestSuccess(ITestResult result) {
		testLog.pass(result.getName() + " Successful");
		String d = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		
		TakesScreenshot sp=(TakesScreenshot)driver;
		File src=sp.getScreenshotAs(OutputType.FILE); 
		try {
			FileHandler.copy(src, new File(result.getName()+d+".png"));		
		testLog.addScreenCaptureFromPath(result.getName()+d+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		testLog.fail(result.getName() + " Unsuccessful");
		String d = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		
		TakesScreenshot sp=(TakesScreenshot)driver;
		File src=sp.getScreenshotAs(OutputType.FILE); 
		try {
			FileHandler.copy(src, new File(result.getName()+d+".png"));		
		testLog.addScreenCaptureFromPath(result.getName()+d+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		testLog.info("Writing Report");
		extentReporter.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
