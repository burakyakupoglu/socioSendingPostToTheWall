package com.socio.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.socio.qa.base.TestBase;
import com.socio.qa.pages.EventPage;
import com.socio.qa.pages.HomePage;
import com.socio.qa.pages.LoginPage;
import com.socio.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	EventPage eventPage;

	public HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		eventPage = new EventPage();
	}
	
	
	@Test(priority=1)
	public void clickEventTest(){
		
		String pageTitle = homePage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Socio Platform - Staging","Page title is not matched");
		eventPage = homePage.clickEventName();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
