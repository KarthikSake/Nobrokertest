package com.nobroker.pages;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.nobroker.utils.BasePage;
import com.nobroker.utils.ExcelReader;

public class ResultPage extends BasePage {

	public ResultPage(WebDriver driver, Properties prop, ExtentTest testLog, ExcelReader er, WebDriverWait wait) {
		super(driver, prop, testLog, er, wait);
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//div[@id='description']")
	private WebElement Description;
	
		public void assertDescription() {
			
			testLog.info("Verifying if description element exists");
			if(Description.isDisplayed())
			{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Description);
			testLog.info("Verifying if Description has any text");
			Assert.assertEquals(false, Description.getText().isEmpty());
			}
			else
			{
				testLog.fail("There is No element named Description");
				Assert.fail();
			}

}
}