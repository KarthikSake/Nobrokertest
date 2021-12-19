package com.nobroker.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import com.nobroker.utils.BasePage;
import com.nobroker.utils.ExcelReader;
import com.nobroker.utils.Functions;

public class MainPage extends BasePage{
	
	
	
	
	public MainPage(WebDriver driver, Properties prop, ExtentTest testLog, ExcelReader er, WebDriverWait wait) {
		super(driver, prop, testLog, er, wait);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "searchCity")
	private WebElement SearchCity;
	
	@FindBy(xpath="//*[contains(text(),'Mumbai') and contains(@id,\"react-select\")]")
	private WebElement Mumbai;
	
	@FindBy(id="listPageSearchLocality")
	private WebElement Searchlocatity;
	
	@FindBy(xpath="//span[contains(.,'Malkani Estate')]")
	private WebElement Malkani;
	
	@FindBy(xpath="//span[contains(.,' Sundar Ln')]")
	private WebElement Sundar;
	
	@FindBy(css=".nb-select__sm")
	private WebElement Apartment;
	
	@FindBy(xpath= "//input[@value='BHK2']")
	private WebElement BHK2;
	
	@FindBy(xpath = "//input[@value='BHK3']")
	private WebElement BHK3;
	
	@FindBy(xpath = "//article[4]/div[2]/div[1]/section[1]/div[1]/a[contains(@href,\"property\")]")
	private WebElement Result4;
	
	@FindBy(xpath="//button[contains(.,'Search')]")
	private WebElement Search;
	
	
	@FindBy(xpath="//div[@id='description']")
	private WebElement Description;
	
	@FindBy(xpath="//input[@id='RENT']")
	private WebElement House;
	
	Functions f = new Functions();
	
	public void Search(String city, String Area,String locality1, String locality2, String BHk1,String BHk2 )
	{   
		By Mumbai1 = By.xpath("//*[contains(text(),'" + city +"') and contains(@id,\"react-select\")]");
		By Malkani1 =  By.xpath("//span[contains(.,'" + locality1 +"')]");
		By Sundar1 =  By.xpath("//span[contains(.,'" + locality2 +"')]");
		By Bhk02=  By.xpath( "//input[@value='"+ BHk1+"']");
		By BHK03 =  By.xpath( "//input[@value='"+ BHk2+"']");
		
		testLog.info("Clicking on cities");
		SearchCity.click();
		
		f.clickOn(Mumbai1);
		
		testLog.info("Selecting Mumbai");
		//Mumbai.click();
		
		testLog.info("Selecting Malkani locality");
		Searchlocatity.sendKeys(Area);
		f.clickOn(Malkani1);
		//Malkani.click();
		
		//Had to implement Thread to deal with synchronization of already sent 'Malad'.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testLog.info("Selecting Sundar ln locality");
		Searchlocatity.sendKeys(Area);
		//Sundar.click();
		f.clickOn(Sundar1);

		testLog.info("Selecting Full House");
		if(House.isSelected())
			;
		else
			House.click();
		
		testLog.info("Selecting Apartments types");
		Apartment.click();
		f.clickOn(Bhk02);
		f.clickOn(BHK03);
		testLog.info("Clicking on Search");
		Search.click();

		
	}
	
}
