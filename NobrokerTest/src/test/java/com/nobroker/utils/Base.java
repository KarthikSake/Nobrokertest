package com.nobroker.utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

@Listeners ({com.nobroker.utils.TestReport.class})
public class Base {
	public static WebDriver driver;
	public Properties prop;
	protected static ExtentTest testLog;
	protected static ExtentReports extentReporter;
	public static WebDriverWait wait;
	public static ExcelReader er;


	@BeforeTest // Pre-Conditions
	public void beforeTest() {
		prop = PropertyReader.getInstance();
		extentReporter = new ExtentReports();
		ExtentHtmlReporter html=new ExtentHtmlReporter("Nobroker.html");
		html.setAppendExisting(true);
		extentReporter.attachReporter(html);
		
		driver = HelperFunctions.Startbrowser(prop.getProperty("browser"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterTest // Post- COndition
	public void afterTest() {
		driver.quit();
	}}
