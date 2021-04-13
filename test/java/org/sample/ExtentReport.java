package org.sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	WebDriver driver;

	@BeforeClass
	private void beforeClassMethod() {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("report.html");
		reports.attachReporter(htmlReporter);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@AfterClass
	private void afterClass() {
		driver.quit();
		reports.flush();
	}

	@Test
	private void tc0() {
		ExtentTest test = reports.createTest("verify url");
		test.log(Status.INFO, "verify Fb Url");
		if (driver.getCurrentUrl().contains("facebook")) {
			test.log(Status.PASS, "url is Valid");
		} else {
			test.log(Status.FAIL, "Invalid Url");

		}
	}

	@Test
	private void tc1() throws IOException {
		ExtentTest createTest = reports.createTest("entering values into Facebook");
		createTest.log(Status.INFO, "verfy Username textbox is Enabled");
		WebElement txtUserName = driver.findElement(By.id("email"));
		if (txtUserName.isEnabled() && txtUserName.isDisplayed()) {
			createTest.log(Status.PASS, "userName field is enabled");
			txtUserName.sendKeys("Gautam");
			File screenshotAs = txtUserName.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("fb page.png"));
			createTest.addScreenCaptureFromPath("fb page.png");

		}

	}

}
