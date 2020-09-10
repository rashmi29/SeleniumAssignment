package com.clarion.qa.page;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPromisePage {
	public WebDriver driver;
	
	public SearchPromisePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By promisorLoc = By.name("cboEmp");
	private By searchLoc = By.name("btnSearch");
	private By startDateLoc = By.name("txtStartDate");
	private By logoutLoc = By.linkText("LOGOUT");
	private By messageLoc = By.xpath("//font[contains(text(),'Promise added successfully')]");
	
	public void searchPromise(String promisor) {
		LocalDate localDate = LocalDate.now();
		String startDate = localDate.getDayOfMonth()+"-"+localDate.getMonthValue()+"-"+localDate.getYear();
		
		Select selectObj = new Select(driver.findElement(promisorLoc));
		selectObj.selectByVisibleText(promisor);
		
		driver.findElement(startDateLoc).sendKeys(startDate);
		
		driver.findElement(searchLoc).click();
	}
	
	public boolean verifyAdditionOfPromise(String promiseDesc) {
		return driver.findElement(By.xpath("//td[contains(text(),'"+promiseDesc+"')]")).isDisplayed();
		
	}
	
	public LoginPage clickOnLogout() {
		driver.findElement(logoutLoc).click();
		return new LoginPage(driver);
	}
	
	public boolean isMessagePresent() {
		return driver.findElement(messageLoc).isDisplayed();
	}
}
