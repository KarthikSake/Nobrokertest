package com.nobroker.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nobroker.pages.MainPage;
import com.nobroker.pages.ResultPage;
import com.nobroker.pages.SearchResults;
import com.nobroker.utils.*;

public class Runner extends Base {

	@Test(dataProvider = "Location",retryAnalyzer = com.nobroker.utils.RetryAnalyser.class)
	public void Nobrokertest(String city, String Area,String locality1, String locality2, String BHk1,String BHk2) {
		testLog.info("Fetching URL");
		driver.get("https://www.nobroker.in/");
		MainPage p = new MainPage(driver, prop, testLog, er, wait);
		p.Search(city, Area, locality1, locality2, BHk1, BHk2);
		SearchResults sr = new SearchResults(driver, testLog, prop, wait);
		sr.clickOnFourthResult();
		testLog.info("Switching Window");
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		ResultPage rs  = new ResultPage(driver, prop, testLog, er, wait);
		rs.assertDescription();

	}

	@DataProvider(name = "Location")
	public Object[][] dp() {
		return new Object[][] {
			{"Mumbai","Malad","Malkani Estate","Sundar Ln","BHK2","BHK3"}
		};}

}
