package com.socio.qa.pages;

import java.util.ArrayList;
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

public class WebAppPage extends TestBase{
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "(//span[contains(.,'CONTINUE')])[1]")
	WebElement continueAction;
	
	@FindBy(id = "password-input")
	WebElement passwordField;
	
	@FindBy(xpath = "//span[contains(.,'LOG IN')]")
	WebElement loginAction;
	
	@FindBy(xpath = "(//div[contains(.,'Wall')])[10]")
	WebElement wall;
	
	@FindBy(xpath = "//div[@data-testid='new-post-text']")
	WebElement newPost;
	
	@FindBy(xpath = "(//textarea[@rows='1'])[3]")
	WebElement whatDoYouThink;
	
	@FindBy(xpath = "//div[@data-testid='post-modal-add-image'][contains(.,'Add Image')]")
	WebElement addImage;

	@FindBy(xpath = "//span[@class='fsp-source-list__icon fsp-icon fsp-icon--local_file_system']")
	WebElement myDeviceAction;
	
	@FindBy(xpath = "//div[@class='fsp-drop-area']")
	WebElement selectFilesToUpload;
	
	@FindBy(xpath = "//span[contains(@title,'Save')]")
	WebElement saveAction;
	
	@FindBy(xpath = "//span[@title='Upload']")
	WebElement uploadAction;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div/div[3]/div/div[2]/button[2]")
	WebElement sendAction;
	
	
	// Initializing the Page Objects:
			public WebAppPage() {
				PageFactory.initElements(driver, this);
			}
			
			public String verifyPageUrl(){
				return driver.getCurrentUrl();
			}
			
			public String verifyPageTitle(){
				return driver.getTitle();
			}
			
			public WebAppPage openNewPage(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.open('https://staging.app.socio.events/MjQ0Mjc%3D/overview')");
				
				String oldTab = driver.getWindowHandle();
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			    newTab.remove(oldTab);
			    // change focus to new tab
			    driver.switchTo().window(newTab.get(0));
				
				return new WebAppPage();
			}
		    
		
			public WebAppPage enterEmail(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String emailAddress = "testautomation@socio.events";
				
				Actions action = new Actions(driver);
				
				action.moveToElement(email).build().perform();	
				action.sendKeys(emailAddress).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", email);
					
				return new WebAppPage();
			}
			
			public WebAppPage clickContinueAction(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions action = new Actions(driver);
						
				action.moveToElement(continueAction).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", continueAction);
					
				return new WebAppPage();
			}
			
			public WebAppPage enterPassword(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String passwordValue = "ta12345";
				
				Actions action = new Actions(driver);
				
				action.moveToElement(passwordField).build().perform();	
				action.sendKeys(passwordValue).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", passwordField);
					
				return new WebAppPage();
			}
			
			public WebAppPage clickLoginAction(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions action = new Actions(driver);
				
				action.moveToElement(loginAction).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", loginAction);			
				
					
				return new WebAppPage();
			}
			
			public WebAppPage clickWall(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions action = new Actions(driver);
				
				action.moveToElement(wall).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", wall);			
						
				return new WebAppPage();
			}
			

			public WebAppPage clickNewPost(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions action = new Actions(driver);
				
				action.moveToElement(newPost).build().perform();			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", newPost);			
				
					
				return new WebAppPage();
			}
			

			public WebAppPage enterWhatDoYouThink(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String myThought = "Hopefully, so close to finish! :)";
				
				Actions action = new Actions(driver);
				
				action.moveToElement(whatDoYouThink).build().perform();
				action.sendKeys(myThought).build().perform();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", whatDoYouThink);			
				
					
				return new WebAppPage();
			}
			
			public WebAppPage addImage(){
				
				Actions action = new Actions(driver);
				
				action.moveToElement(addImage).build().perform();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", addImage);
				
				return new WebAppPage();
			}

			public WebAppPage uploadFile(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				Actions action = new Actions(driver);
				
				action.moveToElement(selectFilesToUpload).build().perform();
				
				String hooverAction = "var evObj = document.createEvent('MouseEvents');" +
	                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
	                    "arguments[0].dispatchEvent(evObj);";
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				js.executeScript(hooverAction, selectFilesToUpload);
				
				WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
				addFile.sendKeys("/Users/test1/Documents/images/Logo2.png");
					
				return new WebAppPage();
			}
			
			public WebAppPage clickSave(){
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions action = new Actions(driver);
				
				action.moveToElement(saveAction).build().perform();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", saveAction);			
					
				return new WebAppPage();
			}
			
			public WebAppPage clickUpload(){
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(uploadAction));

				Actions action = new Actions(driver);
				
				action.moveToElement(uploadAction).build().perform();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", uploadAction);			
					
				return new WebAppPage();
			}

			public WebAppPage clickSend(){
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				Actions action = new Actions(driver);
				
				action.moveToElement(sendAction).build().perform();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", sendAction);			
				
				return new WebAppPage();
			}
			
			public EventPage goToEventPage(){
				
				String oldTab = driver.getWindowHandle();
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			    newTab.remove(oldTab);
			    // change focus to old tab
			    driver.switchTo().window(newTab.get(0));
				
				return new EventPage();
			}
			


}
