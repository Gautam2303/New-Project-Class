package org.sample;

import org.omg.CORBA.LocalObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sam23 extends Base {
	@BeforeClass
	private void beforeClass() {
        getDriver();
        getUrl("http://adactinhotelapp.com/index.php");
        maxmize();
	}
	@Parameters({"txtUserName","txtpass"})
	@Test
	private void test1( String s , String s1) {
          WebElement txtUserName = locatorById("username");
          txtUserName.sendKeys(s);
          WebElement txtpass = locatorById("password");
          txtpass.sendKeys(s1);
          WebElement btnLogin = locatorById("login");
          click(btnLogin);
	}
	@Parameters({"location"})
	@Test
	private void test2(String value) {
		selectbyValue(driver.findElement(By.id("location")), "sydney");
	}

}
