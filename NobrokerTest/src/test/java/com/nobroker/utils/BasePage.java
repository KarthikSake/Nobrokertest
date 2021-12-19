package com.nobroker.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;



public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public ExtentTest testLog;
	public ExcelReader er;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BasePage(WebDriver driver, Properties prop, ExtentTest testLog, ExcelReader er, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.prop = prop;
		this.testLog = testLog;
		this.er = er;
		this.wait = wait;
	}

	public BasePage(WebDriver driver, ExtentTest testLog, Properties prop, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.testLog = testLog;
		this.prop = prop;
		this.wait = wait;
	}
}
