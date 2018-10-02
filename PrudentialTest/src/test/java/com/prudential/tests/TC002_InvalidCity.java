package com.prudential.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prudential.pageObjects.SearchPage;

public class TC002_InvalidCity {
  
	static
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}
	
	WebDriver driver=TC001_Validation.driver;
	WebDriverWait wait=TC001_Validation.wait;
	
	SearchPage search=new SearchPage(driver,wait);
	
	@Test(priority=0)
	public void launchApplication() throws InterruptedException, IOException
	{
		search.launchApplication();
	}
	
	@Test(priority=1)
	public void searchFunctionality() throws InterruptedException, IOException
	{
		SoftAssert m_assert=new SoftAssert();
		search.searchCity("Jimish", false, m_assert);
		m_assert.assertAll();
	}
	
	
	
}
