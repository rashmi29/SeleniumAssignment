package com.clarion.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.clarion.qa.base.Base;
import com.clarion.qa.page.HomePage;
import com.clarion.qa.page.LoginPage;

public class LoginTest extends Base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{	
		driver =initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void verifyLoginValidationMessages() {
		LoginPage loginObj = new LoginPage(driver);		
		loginObj.clickLogin();
		
		Assert.assertTrue(loginObj.isValidationMessagePresent());
	}
	
	@Test(priority = 2)
	public void verifySucessfulLogin() {
		LoginPage loginObj = new LoginPage(driver);
		HomePage homeObj = new HomePage(driver);
		boolean loginResult;
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("pwd");
		
		loginObj.login(uname, pwd);
		loginResult = homeObj.verifyLinkPresent();
		
		Assert.assertTrue(loginResult);		
	}
	
	@AfterTest
	public void teardown()
	{		
		driver.quit();		
	}

}
