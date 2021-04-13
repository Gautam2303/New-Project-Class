package org.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static WebDriver driver;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void getUrl(String Url) {
		driver.get(Url);
	}

	public WebElement locatorByXpath(String Data) {
		WebElement element = driver.findElement(By.xpath(Data));
		return element;
	}

	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void maxmize() {
		driver.manage().window().maximize();
	}

	public void quite() {
		driver.quit();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void selectByIndex(WebElement element, int index) {
	 new Select(element).selectByIndex(index);
	}
	public void moveToElement(WebElement element) {
        new Actions(driver).moveToElement(element);
	}
	public WebElement locatorById(String text) {
		WebElement element2 = driver.findElement(By.id(text));
		return element2;
	}
	public WebElement locatorByName( String name ) {
	      WebElement element3 = driver.findElement(By.name(name));
	      return element3;
	}
	public void fullScreen() {
		driver.manage().window().fullscreen();
	}
	public void selectbyValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
