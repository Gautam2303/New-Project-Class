package org.sample;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TicketBooking {
	WebDriver driver;
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;

	@BeforeClass
	private void beforeClass() {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("booking Report.html");
		reports.attachReporter(htmlReporter);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	private void afterClass() {
		driver.quit();
		reports.flush();
	}

	@Test(priority = 1)
	private void tc1() throws IOException {
		test = reports.createTest("checking Dropdown Box");
		test.log(Status.INFO, "verify the Fromport is Enabled and Displayed");
		WebElement departureCity = driver.findElement(By.name("fromPort"));
		if (departureCity.isEnabled() && departureCity.isDisplayed()) {
			test.log(Status.PASS, "departureCity is enabled");
			Select select = new Select(departureCity);
			select.selectByIndex(5);
			File screenshotAs = departureCity.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("departureCity.png"));
			test.addScreenCaptureFromPath("departureCity.png");

		}
	}

	@Test(priority = 2)
	private void tc2() throws IOException {
		test = reports.createTest("checking Dropdown Box ToPort");
		test.log(Status.INFO, "verify the Toport is Enabled and Displayed");
		WebElement dtnToport = driver.findElement(By.name("toPort"));
		if (dtnToport.isEnabled() && dtnToport.isDisplayed()) {
			test.log(Status.PASS, "dtnToport is enabled");
			Select select = new Select(dtnToport);
			select.selectByIndex(3);
			File sS2 = dtnToport.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sS2, new File("dtnToport.png"));
			test.addScreenCaptureFromPath("dtnToport.png");

		}

	}

	@Test(priority = 3)
	private void tc3() throws IOException {
		test = reports.createTest("checking Find Flights Button");
		test.log(Status.INFO, "verify the  Find Flights Button is Enabled and Displayed");
		WebElement btnFindFlights = driver.findElement(By.xpath("//input[@type='submit']"));
		if (btnFindFlights.isEnabled() && btnFindFlights.isDisplayed()) {
			test.log(Status.PASS, "btnFindFlights is enabled");
			btnFindFlights.click();
			File sS3 = btnFindFlights.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sS3, new File("btnFindFlights.png"));
			test.addScreenCaptureFromPath("btnFindFlights.png");

		}

	}

	@Test(priority = 4)
	private void secondPage() {
		test = reports.createTest("Checking For secondpage");
		test.log(Status.INFO, "verify the Second Page");
		if (driver.getCurrentUrl().contains("reserve")) {
			test.log(Status.PASS, "Sucessful attempt");
		} else {
			test.log(Status.FAIL, "Failed Attempt");
		}

	}

	@Test(priority = 5)
	private void chooseFlight() {
		test = reports.createTest("Booking for Least cost Flight");
		test.log(Status.INFO, "verify Least cost Flight is Enabled and Displayed");
		WebElement chsTable = driver.findElement(By.xpath("//table[@class='table']"));
		if (chsTable.isEnabled() && chsTable.isDisplayed()) {
			test.log(Status.PASS, "is Enabled");
			WebElement rbody = driver.findElement(By.tagName("tbody"));
			List<WebElement> tableRow = rbody.findElements(By.tagName("tr"));
			WebElement selectRow = tableRow.get(2);
			List<WebElement> tableData = selectRow.findElements(By.tagName("td"));
			WebElement selectOption = tableData.get(0);
			selectOption.click();

		}

	}

	@Test(priority = 6)
	private void details() throws IOException {
		test = reports.createTest("Personal Details");
		test.log(Status.INFO, "verify Name is Enabled and Displayed");
		WebElement txtName = driver.findElement(By.id("inputName"));
		if (txtName.isEnabled() && txtName.isDisplayed()) {
			test.log(Status.PASS, "txtName is Enabled");
			txtName.sendKeys("Gautam");
		}
		test.log(Status.INFO, "verify address is Enabled and Displayed");
		WebElement txtAddress = driver.findElement(By.id("address"));
		if (txtAddress.isEnabled() && txtAddress.isDisplayed()) {
			test.log(Status.PASS, "txtName is Enabled");
			txtAddress.sendKeys("Omalur");
		}
		test.log(Status.INFO, "verify city is Enabled and Displayed");
		WebElement txtcity = driver.findElement(By.id("city"));
		if (txtcity.isEnabled() && txtcity.isDisplayed()) {
			test.log(Status.PASS, "txtcity is Enabled");
			txtcity.sendKeys("Salem");
		}
		test.log(Status.INFO, "verify State is Enabled and Displayed");
		WebElement txtstate = driver.findElement(By.id("state"));
		if (txtstate.isEnabled() && txtstate.isDisplayed()) {
			test.log(Status.PASS, "txtstate is Enabled");
			txtstate.sendKeys("TamilNadu");
		}
		test.log(Status.INFO, "verify zipCode is Enabled and Displayed");
		WebElement txtzipCode = driver.findElement(By.id("zipCode"));
		if (txtzipCode.isEnabled() && txtzipCode.isDisplayed()) {
			test.log(Status.PASS, "txtzipCode is Enabled");
			txtzipCode.sendKeys("636011");
		}
		test = reports.createTest("checking Credit  cardType");
		test.log(Status.INFO, "verify the Credit cardType is Enabled and Displayed");
		WebElement cardType = driver.findElement(By.id("cardType"));
		if (cardType.isEnabled() && cardType.isDisplayed()) {
			test.log(Status.PASS, "cardType is enabled");
			Select select = new Select(cardType);
			select.selectByIndex(1);
		}
		test.log(Status.INFO, "verify creditCardNumber is Enabled and Displayed");
		WebElement txtcreditCardNumber = driver.findElement(By.id("creditCardNumber"));
		if (txtcreditCardNumber.isEnabled() && txtcreditCardNumber.isDisplayed()) {
			test.log(Status.PASS, "creditCardNumber is Enabled");
			txtcreditCardNumber.sendKeys("9988765432112233");
		}
		test.log(Status.INFO, "verify creditCardMonth is Enabled and Displayed");
		WebElement txtcreditCardMonth = driver.findElement(By.id("creditCardMonth"));
		if (txtcreditCardMonth.isEnabled() && txtcreditCardMonth.isDisplayed()) {
			test.log(Status.PASS, "txtcreditCardMonth is Enabled");
			txtcreditCardMonth.sendKeys("03");
		}
		test.log(Status.INFO, "verify creditCardYear is Enabled and Displayed");
		WebElement txtcreditCardYear = driver.findElement(By.id("creditCardYear"));
		if (txtcreditCardYear.isEnabled() && txtcreditCardYear.isDisplayed()) {
			test.log(Status.PASS, "txtcreditCardYear is Enabled");
			txtcreditCardYear.sendKeys("2023");
		}
		test.log(Status.INFO, "verify nameOnCard is Enabled and Displayed");
		WebElement txtnameOnCard = driver.findElement(By.id("nameOnCard"));
		if (txtnameOnCard.isEnabled() && txtnameOnCard.isDisplayed()) {
			test.log(Status.PASS, "txtnameOnCard is Enabled");
			txtnameOnCard.sendKeys("GOWTHAM");
		}
		test.log(Status.INFO, "verify purchase Flight is Enabled and Displayed");
		WebElement btnPurchase = driver.findElement(By.xpath("//input[@type='submit']"));
		if (btnPurchase.isEnabled() && btnPurchase.isDisplayed()) {
			test.log(Status.PASS, "btnPurchase is Enabled");
			btnPurchase.click();
			File sS1 = btnPurchase.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sS1, new File("btnPurchase.png"));
			test.addScreenCaptureFromPath("btnPurchase.png");
		}
	}

	@Test(priority = 7)
	private void fourthPage() throws IOException {
		test = reports.createTest("Checking For fourthPage");
		test.log(Status.INFO, "verify the fourth Page ");
		if (driver.getCurrentUrl().contains("confirmation")) {
			test.log(Status.PASS, "Sucessful attempt");
		} else {
			test.log(Status.FAIL, "Failed Attempt");
		}
		
		TakesScreenshot ss5 = (TakesScreenshot) driver;
		File file = ss5.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("fourthpage.png"));
		test.addScreenCaptureFromPath("fourthpage.png");
	}
}
