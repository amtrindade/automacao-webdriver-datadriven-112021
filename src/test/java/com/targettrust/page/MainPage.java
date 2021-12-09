package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open() {
		getDriver().get("https://en.wikipedia.org/");
		return this;
	}
	
	public ResultPage searchCountry(String country) {
		WebElement tfSearch = getDriver().findElement(By.id("searchInput"));
		tfSearch.sendKeys(country);
		
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		
		return new ResultPage();
	}

}
