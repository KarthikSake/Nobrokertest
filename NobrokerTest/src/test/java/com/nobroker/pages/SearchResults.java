package com.nobroker.pages;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.nobroker.utils.BasePage;

public class SearchResults extends BasePage{

	public SearchResults(WebDriver driver, ExtentTest testLog, Properties prop, WebDriverWait wait) {
		super(driver, testLog, prop, wait);
		PageFactory.initElements(driver, this);

	
	}

	@FindBy(xpath = "//article[4]/div[2]/div[1]/section[1]/div[1]/a[contains(@href,\"property\")]")
	private WebElement Result4;
	
	public void clickOnFourthResult() {
		testLog.info("Scrolling into veiw");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Result4); 
		testLog.info("clicking on 4th query");
		
		//Experiencing Stale Element exception, Hence Deployed Try & catch Blocks
		try {
		Result4.click();
		}
		catch(Exception e)
		{
			Result4.click();
		}
	}
	
}
