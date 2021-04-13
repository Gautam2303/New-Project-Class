package org.sample;

import org.openqa.selenium.WebElement;

public class Sample extends Base {
	public static void main(String[] args) {
		Base base = new Base();
		base.getDriver();
		base.getUrl("http://adactinhotelapp.com/index.php");
		base.maxmize();
		WebElement txtUseName = base.locatorByXpath("(//input[@class='login_input'])[1]");
		base.sendKeys(txtUseName, "Gautam2303");
		WebElement txtPass = base.locatorByXpath("(//input[@class='login_input'])[2]");
		base.sendKeys(txtPass, "4BTR90");
		WebElement btnLogin = base.locatorByXpath("//input[@class='login_button']");
		btnLogin.click();
		
		
		
		
		
		
		
		
		
	}


}
