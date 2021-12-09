package com.targettrust.test;

import static com.targettrust.core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.targettrust.core.BaseTest;
import com.targettrust.core.SpreadSheetData;

public class DataDrivenCountriesTest extends BaseTest{

	@BeforeTest
	public void beforeMethod() {
		getDriver().get("https://en.wikipedia.org/");
	}
	
	@Test(dataProvider = "countriesList")
	public void searchCountriesLocal(String searchCountry, String expectedCountry) {
		WebElement tfSearch = getDriver().findElement(By.id("searchInput"));
		tfSearch.sendKeys(searchCountry);
		
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		
		WebElement titleLabel = getDriver().findElement(By.id("firstHeading"));
		assertEquals(titleLabel.getText(), expectedCountry, "Deveria ter pesquisao o país");
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderList() {
		return new Object[][] {
			{"India", "India"},			
			{"Brazil", "Brasil" },
			{"Brasil", "Brazil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}
		};
	}

	@Test(dataProvider = "countriesExcel")
	public void searchCountriesExcel(String searchCountry, String expectedCountry) {
		WebElement tfSearch = getDriver().findElement(By.id("searchInput"));
		tfSearch.sendKeys(searchCountry);
		
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		
		WebElement titleLabel = getDriver().findElement(By.id("firstHeading"));
		assertEquals(titleLabel.getText(), expectedCountry, "Deveria ter pesquisao o país");
	}

	
	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderExcel(){
		Object[][]testData = SpreadSheetData.readExcelData("Paises", 
				"src/test/resources/paises.xls", "Dados");
		return testData;
	}
}
