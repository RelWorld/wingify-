package com.relevelProject.qa.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.relevelProject.qa.testCases.LoginPageFunctionality;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import relevelProject001.pageobjects.landingPage01;

public class baseTest {

	WebDriver driver;
	public landingPage01 landingPage;

	public Properties propertiesFile() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//relevelProject001//resources//globalData.properties");
		prop.load(fis1);
		return (prop);
	}

	public WebDriver initializeDriver() throws IOException {

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: propertiesFile().getProperty("browser");
		// prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));// full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge

			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari"))

		{
			// Edge

			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}



	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	public landingPage01 goTo() throws IOException {
		propertiesFile();

		String URLName = System.getProperty("URL") != null ? System.getProperty("URL")
				: propertiesFile().getProperty("URL");
		landingPage = new landingPage01(driver);
		driver.get(URLName);
		return landingPage;

	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {

		initializeDriver();
		goTo();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
