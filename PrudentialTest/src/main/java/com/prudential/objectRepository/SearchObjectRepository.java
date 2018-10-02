package com.prudential.objectRepository;

import org.openqa.selenium.By;

public class SearchObjectRepository {

	
	public static By searchButton=By.xpath("//form[@id='searchform']//button[@type='submit']");
	public static By searchInputText=By.xpath("//form[@id='searchform']//input[@placeholder='Your city name']");
	public static By currentLocationButton=By.xpath("//form[@id='searchform']//button[contains(text(),'Current location')]");
	public static By weatherLink=By.linkText("Weather");
	public static By mapsLink=By.partialLinkText("Maps");
	public static By apiLink=By.linkText("API");
	public static By priceLink=By.linkText("Price");
	public static By partnersLink=By.linkText("Partners");
	public static By stationsLink=By.linkText("Stations");
	public static By widgetsLink=By.linkText("Widgets");
	public static By blogLink=By.linkText("Blog");
	public static By wrongDataButton=By.xpath("//button[text()='Wrong data?']");
	public static By wrongData_email=By.id("user_email");
	public static By wrongData_subject=By.id("subject");
	public static By wrongData_description=By.id("description");
	public static By wrongData_sendButton=By.xpath("//button[text()='Send']");
	
}
