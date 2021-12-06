package com.socio.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.socio.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "(//h3[contains(.,'Test Automation Assessment Event')])[2]")
	WebElement eventName;

	@FindBy(xpath = "//h3[@data-testid='titleDashead']")
	WebElement myEventsTitle;
	
	@FindBy(xpath = "//span[contains(.,'Event App')]")
	WebElement eventAppAction;

	@FindBy(xpath = "//a[contains(@title,'My Events')]")
	WebElement myEventsAction;
	

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public String verifyPageUrl(){
		return driver.getCurrentUrl();
	}

	public HomePage clickMyEventsAction(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(eventAppAction).build().perform();			
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eventAppAction);
		
		action.moveToElement(myEventsAction).build().perform();		
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", myEventsAction);
		
		return new HomePage();
	}
	
	public EventPage clickEventName(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		action.moveToElement(eventName).build().perform();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eventName);
		
		return new EventPage();
	}
	

}
