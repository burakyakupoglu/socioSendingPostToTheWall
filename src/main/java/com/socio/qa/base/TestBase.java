package com.socio.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.socio.qa.util.TestUtil;
import com.socio.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/socio"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Big Sur");
//			caps.setCapability("os", "windows");
//			caps.setCapability("os_version", "11");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "latest");
			caps.setCapability("project", "Socio TA Assessment");
			caps.setCapability("build", "burak_build");
			caps.setCapability("name", "Adding a New Post");
			
//			ChromeOptions options = new ChromeOptions();
//			
//			options.addArguments("use-fake-ui-for-media-stream");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--disable-extensions");
//			options.addArguments("--proxy-server='direct://'");
//			options.addArguments("--proxy-bypass-list=*");
//			options.addArguments("--start-maximized");
//			options.addArguments("--no-sandbox");
//			options.addArguments("--ignore-certificate-errors");
//			options.addArguments("window-size=1920x1080");
			
//			System.setProperty("webdriver.chrome.driver", "/Users/buraky/Downloads/chromedriver");	
			
			  
			final String AUTOMATE_USERNAME = "alihanozbayrak1";
			final String AUTOMATE_ACCESS_KEY = "yYzukxkJ3sAqxT1pyW7B";
			final String URL1 = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
			  
			try {
				driver = new RemoteWebDriver(new URL(URL1), caps);
				//driver = new RemoteWebDriver(new URL(URL1), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//			driver = new ChromeDriver(options);
			
			
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/buraky/Downloads/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	

}

