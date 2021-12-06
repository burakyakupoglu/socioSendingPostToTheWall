package com.socio.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.socio.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath = "//a[contains(@data-testid,'linkLogin')]")
	WebElement logIn;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@data-testid='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='/static/media/socio-logo-orange@1x.926e3cb3.png']")
	WebElement socioLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validatePageUrl(){
		return driver.getCurrentUrl();
	}
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogoImage(){
		return socioLogo.isDisplayed();
	}
	
	public HomePage clickLogin(){
		
		Actions action = new Actions(driver);
		action.moveToElement(logIn).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logIn);
		
		return new HomePage();
	}
	
	public HomePage login(String un, String pwd){
		clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		wait.until(ExpectedConditions.visibilityOf(password));
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}
