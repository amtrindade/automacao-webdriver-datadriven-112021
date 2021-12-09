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
import com.targettrust.page.MainPage;
import com.targettrust.page.ResultPage;

public class DataDrivenCountriesTest extends BaseTest{
	
	private MainPage mainPage;
	private ResultPage resultPage;

	@BeforeTest
	public void beforeMethod() {
		mainPage = new MainPage();
		mainPage.open();
	}
	
	@Test(dataProvider = "countriesList")
	public void searchCountriesLocal(String searchCountry, String expectedCountry) {
		resultPage = mainPage.searchCountry(searchCountry);
		assertEquals(resultPage.getTextTitle(), expectedCountry, "Deveria ter pesquisao o país");
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderList() {
		return new Object[][] {
			{"India", "India"},			
			{"Brazil", "Brazil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}
		};
	}

	@Test(dataProvider = "countriesExcel")
	public void searchCountriesExcel(String searchCountry, String expectedCountry) {
		resultPage = mainPage.searchCountry(searchCountry);
		assertEquals(resultPage.getTextTitle(), expectedCountry, "Deveria ter pesquisao o país");
	}

	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderExcel(){
		Object[][]testData = SpreadSheetData.readExcelData("Paises", 
				"src/test/resources/paises.xls", "Dados");
		return testData;
	}
}
