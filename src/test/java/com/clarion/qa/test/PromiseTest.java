package com.clarion.qa.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.clarion.qa.base.Base;
import com.clarion.qa.page.AddPromisePage;
import com.clarion.qa.page.HomePage;
import com.clarion.qa.page.LoginPage;
import com.clarion.qa.page.SearchPromisePage;
import com.clarion.qa.utility.StringUtil;

public class PromiseTest extends Base{
	public WebDriver driver;
	HomePage homeObj;
	String promiseFrom, promise;
	
	@BeforeTest
	public void initialize() throws IOException
	{	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("URL"));
		 driver.manage().window().maximize();
		 LoginPage loginObj = new LoginPage(driver);
		 homeObj = loginObj.login(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@Test(priority = 3)
	public void verifyAddPromise() {
		StringUtil strObj = new StringUtil();
		String randomStr = strObj.generateRandomString(4);
		promiseFrom = prop.getProperty("promiseName");
		promise = prop.getProperty("promise") + randomStr;
		AddPromisePage addPromiseObj = new AddPromisePage(driver);
		SearchPromisePage searchObj = new SearchPromisePage(driver);
		
		homeObj.clickLogPromise();
		
		addPromiseObj.enterPromise(promiseFrom, promise);
		
		Assert.assertTrue(searchObj.isMessagePresent());	
	}
	
	@Test(priority = 4)
	public void verifySucessfullAdditionOfPromise() {
		
		SearchPromisePage searchObj = new SearchPromisePage(driver);
		searchObj.searchPromise(promiseFrom);
		
		boolean result = searchObj.verifyAdditionOfPromise(promise);
		Assert.assertTrue(result);
	}
	
	@Test(priority = 5)
	public void verifySucessfulLogout() {	
		SearchPromisePage searchObj = new SearchPromisePage(driver);
		LoginPage loginObj = new LoginPage(driver);
		
		searchObj.clickOnLogout();
		
		Assert.assertEquals("Promises Log", loginObj.validateLoginPageTitle());
	}
	
	@AfterTest
	public void teardown()
	{		
		driver.quit();		
	}
}
