package com.socio.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.socio.qa.base.TestBase;
import com.socio.qa.pages.HomePage;
import com.socio.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginTest(){
		
		String pageTitle = loginPage.validatePageTitle();
		String pageUrl = loginPage.validatePageUrl();
		boolean flag = loginPage.validateLogoImage();
		
		Assert.assertEquals(pageTitle, "Socio Platform - Staging");
		Assert.assertTrue(flag);
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Assert.assertEquals(pageUrl, "https://staging.platform.socio.events/login");
	}
	
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
	
	
	

}
