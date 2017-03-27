package Artoo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.remote.DesiredCapabilities;

public class whatsApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9500");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.1");
		
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		System.out.println("What's App Launched");
		
		// Message send
		driver.findElementById("com.whatsapp:id/conversations_row_contact_name").click();
		driver.findElementById("com.whatsapp:id/entry").sendKeys("Hi I am Doing Testing");
		driver.findElementById("com.whatsapp:id/send").click();
		System.out.println("Message Send");
		
		Thread.sleep(5000);
		//Image send
		driver.findElementById("com.whatsapp:id/camera_btn").click();
		driver.findElementById("com.whatsapp:id/thumb").click();
		driver.findElementById("com.whatsapp:id/caption").sendKeys("Testing Image Send");
		driver.findElementById("com.whatsapp:id/send").click();
		System.out.println("Image Send");
		
		Thread.sleep(5000);
		
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		driver.findElementById("com.whatsapp:id/tab").click();
		
		
		

	}

}
