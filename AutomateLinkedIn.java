package linkedInTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomateLinkedIn {

		public static void main(String[] args) throws InterruptedException, AWTException   {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver LinkedIn = new FirefoxDriver();
		LinkedIn.get("https://www.linkedin.com");		
		LinkedIn.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Code for checking Title of the page
		
		String webTitle = LinkedIn.getTitle();
		System.out.println("LinkedIn's title is --> " +webTitle);
		String ActualTitle = "LinkedIn: Log In or Sign Up";
		Assert.assertEquals(webTitle, ActualTitle);
		
		//Code for Login 
		
		LinkedIn.findElement(By.xpath("//input[@placeholder='Email or phone number']")).sendKeys("youremailid");
		LinkedIn.findElement(By.xpath("//input[contains(@class,'login-password')]")).sendKeys("yourpassword");	
		LinkedIn.findElement(By.xpath("//input[@id='login-submit']")).click();
		Thread.sleep(8000);
		String User = LinkedIn.findElement(By.xpath("//a[@data-control-name='identity_welcome_message']")).getText();
		System.out.println("Login is successful, " +User);
		
		// Code for uploading Profile Photo
		
		LinkedIn.findElement(By.xpath("//label[@for='profile-photo-upload-input']")).click();
		Thread.sleep(1000);
		StringSelection SS = new StringSelection("E:\\Selenium\\bugimage.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		LinkedIn.findElement(By.xpath("//img[@height='64']")).click();
		LinkedIn.findElement(By.xpath("//button[@class='msg-overlay-onboarding-hovercard__dismiss-btn button-tertiary-small-round-inverse']")).click();
		
		//Code for Updating Profile
		
		LinkedIn.findElement(By.xpath("//span[text()='Edit Profile']/following::*[local-name()='svg']")).click();
		LinkedIn.findElement(By.xpath("//textarea[@id='topcard-headline']")).clear();
		LinkedIn.findElement(By.xpath("//textarea[@id='topcard-headline']")).sendKeys("Testing LinkedIn and trying to automate it");
		WebElement menu = LinkedIn.findElement(By.xpath("//select[@id='location-city']"));
		WebElement subMenu = LinkedIn.findElement(By.xpath("//option[contains(.,'North 24 Parganas')]"));
		Actions builder = new Actions(LinkedIn);
		builder.moveToElement(menu).perform();
		Thread.sleep(2000);
		builder.click(subMenu).perform();
		LinkedIn.findElement(By.xpath("//label[@for='osmosis-toggle-switch']")).click();
		Thread.sleep(1000);
		LinkedIn.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Code for messaging using chatbot
		
		LinkedIn.findElement(By.xpath("//button[@data-is-animating-click='true']")).click();
		LinkedIn.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Writing a Test Message");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		LinkedIn.findElement(By.xpath("//button[@class='msg-overlay-conversation-bubble__control']")).click();
		
		LinkedIn.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Artoo");
		
		
		//Code for posting message
		
		WebElement Post = LinkedIn.findElement(By.xpath("//div[@class='sharing-create-share-view__create-content sharing-create-share-view__create-content--is-defaultrounded-button-theme  rounded-button-theme-b']"));
		Post.sendKeys("Writing a demo post");
		LinkedIn.findElement(By.xpath("//button[@id='ember17992']")).click();
		
		//Code for Logging Out
		
		WebElement LogOut = LinkedIn.findElement(By.xpath("//a[@href='/m/logout/']"));
		Actions mouseHover = new Actions(LinkedIn);
		mouseHover.click(LogOut).perform();
		System.out.println(User+ ", you have logged out!");		
   	    
	}
		
}
