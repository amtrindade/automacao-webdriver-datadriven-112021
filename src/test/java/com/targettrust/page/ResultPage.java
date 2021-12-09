package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultPage {

	public String getTextTitle() {
		WebElement titleLabel = getDriver().findElement(By.id("firstHeading"));
		return titleLabel.getText();
	}
}
