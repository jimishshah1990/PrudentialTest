package com.prudential.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prudential.pageObjects.SearchPage;

public class TC001_Validation {
  
	static
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}
	
	static WebDriver driver=new ChromeDriver();
	static WebDriverWait wait=new WebDriverWait(driver, 60);
	
	SearchPage search=new SearchPage(driver,wait);
	
	@Test(priority=0)
	public void launchApplication() throws InterruptedException, IOException
	{
		search.launchApplication();
	}
	
	@Test(priority=1)
	public void validation()
	{
		SoftAssert m_assert=new SoftAssert();
		search.launchValidation(m_assert);
		m_assert.assertAll();
	}
	
	@AfterSuite
	public void exit()
	{
		driver.quit();
	}
	
}
