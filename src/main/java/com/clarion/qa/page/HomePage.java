package com.clarion.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logPromiseLoc = By.linkText("Log Promise");
	
	public AddPromisePage clickLogPromise() {
		driver.findElement(logPromiseLoc).click();
		
		return new AddPromisePage(driver);
	}
	
	public boolean verifyLinkPresent() {
		return driver.findElement(logPromiseLoc).isDisplayed();
	}

}
