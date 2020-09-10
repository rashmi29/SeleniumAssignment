package com.clarion.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernNameLoc = By.name("txtUsername");
	private By passwordLoc = By.name("txtPassword");
	private By submitLoc = By.xpath("//input[@name='submit1']");
	private By validationMessageLoc = By.xpath("//font[contains(text(),'Invalid Username')]");
	
	public HomePage login(String username, String pwd) {			
		driver.findElement(usernNameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(pwd);
		driver.findElement(submitLoc).click();
		
		return new HomePage(driver);
	}
	
	public boolean isValidationMessagePresent() {
		return driver.findElement(validationMessageLoc).isDisplayed();		
	}
	
	public void clickLogin() {
		driver.findElement(submitLoc).click();	
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

}
