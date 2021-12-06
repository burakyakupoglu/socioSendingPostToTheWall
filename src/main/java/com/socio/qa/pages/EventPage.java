package com.socio.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.socio.qa.base.TestBase;

public class EventPage extends TestBase{
	
	@FindBy(xpath = "//span[contains(@class,'gcon gcon-globe rs-icon-menu')]")
	WebElement webApp;
	
	@FindBy(xpath = "(//span[@class='bootstrap-switch-handle-off bootstrap-switch-default'][contains(.,'NO')])[1]")
	WebElement enableWebAppNo;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Save')]")
	WebElement saveAction;
	
	@FindBy(xpath = "//button[contains(.,'Copy Link')]")
	WebElement copyLinkAction;
	
	@FindBy(xpath = "//span[contains(@data-testid,'sidebarItemEditCommunity')]")
	WebElement editEvent;
	
	@FindBy(xpath = "//h4[@class='text-uppercase m-x-sm'][contains(.,'Wall')]")
	WebElement wallGrid;
	
	@FindBy(xpath = "//button[@data-testid='buttonEditFeature']")
	WebElement editWall;
	
	@FindBy(xpath = "(//span[@title='Hopefully, so close to finish! :)'])[1]")
	WebElement addedPost;
	
	@FindBy(xpath = "(//div[contains(.,'Event Analytics')])[14]")
	WebElement eventAnalytics;
	
	// Initializing the Page Objects:
		public EventPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyPageUrl(){
			return driver.getCurrentUrl();
		}
		
		public String verifyPageTitle(){
			return driver.getTitle();
		}
	
		public EventPage clickWebAppAction(){
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Actions action = new Actions(driver);
			action.moveToElement(webApp).build().perform();
			//webApp.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", webApp);
				
			return new EventPage();
		}
		
		public EventPage clickEnableWebApp(){
			
			Actions action = new Actions(driver);
			
			if(driver.findElements(By.xpath("(//span[@class='bootstrap-switch-handle-off bootstrap-switch-default'][contains(.,'NO')])[1]") ).size() == 0) {
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(enableWebAppNo));
				
				action.moveToElement(enableWebAppNo).build().perform();
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", enableWebAppNo);
				
			}
			
			return new EventPage();
		}
		
		public EventPage clickSaveAction(){
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Actions action = new Actions(driver);
			
			action.moveToElement(saveAction).build().perform();	
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", saveAction);
				
			return new EventPage();
		}
		
		public WebAppPage clickCopyLinkAction(){
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Actions action = new Actions(driver);
			
			action.moveToElement(copyLinkAction).build().perform();	
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", copyLinkAction);
				
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			return new WebAppPage();
		}
		
		public EventPage clickEditEventAction(){
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Actions action = new Actions(driver);
			
			action.moveToElement(editEvent).build().perform();			
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", editEvent);
				
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			return new EventPage();
		}

		public EventPage clickEditWallAction(){
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String hooverAction = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(hooverAction, wallGrid);
			js.executeScript("arguments[0].click();", editWall);
				
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
			return new EventPage();
		}
		
		public String validateThePost(){
			
			return addedPost.getText();
		}
		

		
}
