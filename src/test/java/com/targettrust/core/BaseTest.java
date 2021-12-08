package com.targettrust.core;

import static com.targettrust.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public abstract class BaseTest {

	@AfterMethod()
	public void tearMethod(ITestResult testResult) throws IOException {
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen , new File("target"+ File.separator + testResult.getName()+"_"+ new Date() +".png"));
	}
		
	@AfterTest()
	public void tearDown() throws IOException {
		DriverFactory.killDriver();
	}
}
