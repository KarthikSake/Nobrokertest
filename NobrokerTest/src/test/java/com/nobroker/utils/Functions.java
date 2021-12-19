package com.nobroker.utils;



import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Functions extends Base {

	Actions ac = new Actions(driver);
	
	public void sendData(By locator,String data ) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(data);
	}
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	
	public void clickOn(By locator) {
		driver.findElement(locator).click();
	}
	public void wclickOn(By locator) {
		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		driver.findElement(locator).click();
	}
	public void getUrl(String data) {
		driver.get(data);
	}
	
	public void selectfromDropDown(By locator,String data )  {
			if(data.contains(".0")) {
				float da1=Float.parseFloat(data);
				int da= (int) da1;
				String value=Integer.toString(da);
				Select s=new Select(driver.findElement(locator));
				s.selectByValue(value);
			}
			else
			{
			Select s=new Select(driver.findElement(locator));
			s.selectByValue(data);	
			}
}
	
	public void asserturl(String data ) {
		Assert.assertTrue(driver.getCurrentUrl().contains(data));
	}
	public void asserttext(By locator,String data  ) {
		Assert.assertTrue(driver.findElement(locator).getText().contains(data));
	}

	public void asserttrue(By locator) {
		Assert.assertTrue(driver.findElement(locator).isDisplayed());
	}

	public void cclickOn(By  locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).click();
	}

	public void wselectfromDropDown(By  locator, String data) {
		
		try {
		Select s=new Select(driver.findElement(locator));
		s.selectByValue(data);	
		}
		catch(Exception e) {
		Select s=new Select(driver.findElement(locator));
		s.selectByValue(data);	
			}
		}
	
	public void mousehover(By  locator) {
		
		
		ac.moveToElement(driver.findElement(locator));
		ac.perform();
	}
	public void actionclick(By  locator) {
		
		ac.click(driver.findElement(locator));
		ac.perform();
	}
	}
	

