package org.cleartrip.maincontroller;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.cleartrip.utils.Screenshot;
import org.cleartrip.utils.SearchData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class MainController{
 public static WebDriver driver ;
/*
 * @author Hemanth.Sridhar
 */
 
	
 	@BeforeSuite
 	public void screenshotCleanUp() throws IOException{
 		System.out.println("clean up screenshots folder");
 		FileUtils.cleanDirectory(new File("./Screenshots"));
 		
 	}
 	
	@BeforeMethod
	public void setUp() throws IOException{
		driver.get(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties","url"));
		
	}
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		
		if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties","browser").trim().equalsIgnoreCase("HTMLUnit"))
		{
			driver = new HtmlUnitDriver();
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("Ghost"))
		{
			 DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("phantomjs.binary.path", "resources/drivers/phantomjs.exe");
	        driver = new PhantomJSDriver(caps);
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("cannot load driver");
		}
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult testResult) throws IOException{
 if (testResult.getStatus() == ITestResult.FAILURE)
 {
	System.out.println(testResult.getStatus()); 
	 //type casting to takescreenshot INTERFACE!!!
Screenshot.captureScreenShot(driver, testResult.getName());
 } 
}
	@AfterSuite
	public void tearDownClass(){
		System.out.println("Ending Test Suite");
		driver.close();
		driver.quit();
	}
}
