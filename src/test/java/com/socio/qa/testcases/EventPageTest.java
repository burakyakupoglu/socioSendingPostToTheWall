package com.socio.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.socio.qa.base.TestBase;
import com.socio.qa.pages.EventPage;
import com.socio.qa.pages.HomePage;
import com.socio.qa.pages.LoginPage;
import com.socio.qa.pages.WebAppPage;
import com.socio.qa.util.TestUtil;

public class EventPageTest extends TestBase{

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	EventPage eventPage;
	WebAppPage webAppPage;
	
	String sheetName = "contacts";
	
	   
	public EventPageTest(){
			super();
			
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		eventPage = homePage.clickEventName();
		webAppPage = new WebAppPage();
	}
	
	@Test(priority=1)
	public void clickWebAppTest(){
		
		String pageTitle = eventPage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Socio Platform - Staging","Page title is not matched");
		
		eventPage = eventPage.clickWebAppAction();
		eventPage = eventPage.clickEnableWebApp();
		eventPage = eventPage.clickSaveAction();
		webAppPage = eventPage.clickCopyLinkAction();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
