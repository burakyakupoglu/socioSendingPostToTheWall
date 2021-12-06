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

public class WebAppPageTest extends TestBase{

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	EventPage eventPage;
	WebAppPage webAppPage;

	   
	public WebAppPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		eventPage = homePage.clickEventName();
		eventPage = eventPage.clickWebAppAction();
		eventPage = eventPage.clickEnableWebApp();
		eventPage = eventPage.clickSaveAction();
		webAppPage = eventPage.clickCopyLinkAction();
	}
	
	@Test(priority=1)
	public void enterWebApp(){	
		
		webAppPage.openNewPage()
		.enterEmail()
		.clickContinueAction()
		.enterPassword()
		.clickLoginAction()
		.clickWall()
		.clickNewPost()
		.enterWhatDoYouThink()
		.addImage()
		.uploadFile()
		.clickSave()
		.clickUpload()
		.clickSend()
		;
		
		webAppPage.goToEventPage();
		eventPage.clickEditEventAction()
		.clickEditWallAction();
		
		String addedPost = eventPage.validateThePost();
		Assert.assertEquals(addedPost, "Hopefully, so close to finish! :)");
				
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
