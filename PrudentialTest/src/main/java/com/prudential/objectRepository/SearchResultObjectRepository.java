package com.prudential.objectRepository;

import org.openqa.selenium.By;

public class SearchResultObjectRepository {
	
	
	public static By searchButton=By.xpath("//form[contains(@onsubmit,'FindCity')]//button[@type='submit']");
	public static By noSearchResult=By.xpath("//div[@id='forecast-list']//div[text()='Not found']");
	public static By resultList=By.xpath("//div[@id='forecast-list']//a[contains(@href,'/city/')]");
}
