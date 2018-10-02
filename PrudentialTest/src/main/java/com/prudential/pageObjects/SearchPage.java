package com.prudential.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.prudential.config.ConfigReader;
import com.prudential.objectRepository.SearchObjectRepository;
import com.prudential.objectRepository.SearchResultObjectRepository;
import com.prudential.testbase.TestBase;

public class SearchPage extends TestBase{
	
	
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}


	public void launchApplication() throws InterruptedException, IOException
	{
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(new ConfigReader().getPropertyValue("URL"));
		explicitWait(SearchObjectRepository.searchButton);
		
	}
	
	
	public void launchValidation(SoftAssert m_assert)
	{
		m_assert.assertEquals(driver.getTitle(), "Сurrent weather and forecast - OpenWeatherMap","Title is not correct");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.searchInputText), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.searchButton), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.currentLocationButton), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.weatherLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.mapsLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.apiLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.priceLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.partnersLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.stationsLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.widgetsLink), true," Element is not Present");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.blogLink), true," Element is not Present");
		
	}
	
	
	public void searchCity(String cityName, boolean validCity,SoftAssert m_assert ) throws InterruptedException
	{
		
		clickButton(SearchObjectRepository.weatherLink);
		explicitWait(SearchObjectRepository.searchButton);
		enterInputText(SearchObjectRepository.searchInputText, cityName);
		clickButton(SearchObjectRepository.searchButton);
		explicitWait(SearchResultObjectRepository.searchButton);
		
		if(validCity==false)
		{
			m_assert.assertEquals(isElementPresent(SearchResultObjectRepository.noSearchResult), true,"Not Found is not displayed");
		}
		else
		{
			List<WebElement> elements=driver.findElements(SearchResultObjectRepository.resultList);
			for(WebElement element:elements)
			{
				m_assert.assertEquals(element.getText().toLowerCase().contains(cityName.toLowerCase()), true,"Search Result - "+element.getText()+" doesnt match with City Name - "+cityName);
			}
		}
		
	}
	
	
	public void currentLocation(SoftAssert m_assert) throws InterruptedException, IOException
	{
		
		searchCity("New York", true, m_assert);
		clickButton(SearchResultObjectRepository.resultList);
		explicitWait(SearchObjectRepository.searchButton);
		clickButton(SearchObjectRepository.currentLocationButton);
		explicitWait(SearchObjectRepository.searchButton);
		m_assert.assertEquals(driver.findElement(By.xpath("//h2[@class='weather-widget__city-name']")).getText(), "Weather in "+(new ConfigReader().getPropertyValue("CurrentLocation")));
		
	}
	
	
	public void wrongData(String emailAddress, String subject, String description) throws InterruptedException
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[@class='weather-widget__city-name']")));
		clickButton(SearchObjectRepository.wrongDataButton);
		enterInputText(SearchObjectRepository.wrongData_email, emailAddress);
		enterInputText(SearchObjectRepository.wrongData_subject, subject);
		enterInputText(SearchObjectRepository.wrongData_description, description);
		clickButton(SearchObjectRepository.wrongData_sendButton);
		explicitWait(SearchObjectRepository.searchButton);
		
	}

	
}
