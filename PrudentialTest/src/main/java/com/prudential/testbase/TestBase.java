package com.prudential.testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public TestBase(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=wait;
		
	}
	
	
	public boolean isElementPresent(By element)
	{
		try
		{
			driver.findElement(element);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	
	public void explicitWait(By element) throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(2000);
	}
	
	public void enterInputText(By element, String value)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).sendKeys(value);
		
	}
	
	public void clickButton(By element) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(1500);
		driver.findElement(element).click();
		
	}
	
}
