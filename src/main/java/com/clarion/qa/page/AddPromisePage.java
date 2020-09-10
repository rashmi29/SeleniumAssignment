package com.clarion.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddPromisePage {
	public WebDriver driver;
	
	public AddPromisePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By promiseFromLoc = By.name("cboEmp");
	private By promiseLoc = By.id("txtPromise");
	private By logPromiseLoc = By.name("btnSubmit");
	
	public SearchPromisePage enterPromise(String promiseName, String promiseDesc) {
		Select selectObj = new Select(driver.findElement(promiseFromLoc));
		selectObj.selectByVisibleText(promiseName);
		
		driver.findElement(promiseLoc).sendKeys(promiseDesc);
		
		driver.findElement(logPromiseLoc).click();
		
		return new SearchPromisePage(driver);
	}

}
