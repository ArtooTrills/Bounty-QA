package testLinkedIn;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoLinkedIn {

	public static void main(String[] args) throws Exception {
		
				System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver-v0.16.1-win64\\geckodriver.exe");
				final WebDriver LinkedIn = new FirefoxDriver();
				LinkedIn.get("https://www.linkedin.com");		
				LinkedIn.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				// Code for Login 
				
				LinkedIn.findElement(By.xpath("//input[@placeholder='Email or phone number']")).sendKeys("youremailid");
				LinkedIn.findElement(By.xpath("//input[contains(@class,'login-password')]")).sendKeys("yourpassword");	
				LinkedIn.findElement(By.xpath("//input[@id='login-submit']")).click();
				Thread.sleep(8000);
				String User = LinkedIn.findElement(By.xpath("//a[@data-control-name='identity_welcome_message']")).getText();
				System.out.println("Login is successful, " +User);
				
				// Read values of font-size, color, font-family and text-align properties
				
			    @SuppressWarnings("unused") class fontTest { 
								
				@Test
				 public void readFontProperty(){
					
				  //Locate text string element to read It's font properties.
				  WebElement text = LinkedIn.findElement(By.xpath("//a[@data-control-name='identity_welcome_message']"));
				  
				  //Read font-size property and print It In console.
				  String fontSize = text.getCssValue("font-size");
				  System.out.println("Font Size -> "+fontSize);
				  
				  //Read color property and print It In console.
				  String fontColor = text.getCssValue("color");
				  System.out.println("Font Color -> "+fontColor);
				  
				  //Read font-family property and print It In console.
				  String fontFamily = text.getCssValue("font-family");
				  System.out.println("Font Family -> "+fontFamily);
				  
				  //Read text-align property and print It In console.
				  String fonttxtAlign = text.getCssValue("text-align");
				  System.out.println("Font Text Alignment -> "+fonttxtAlign);
				  }		
		    	}   
			       // Test if an mandatory element [e.g. Home Button] is present on the webpage.
				
				   boolean HomeButton = LinkedIn.findElement(By.xpath("//span[contains(@id,'feed-tab-icon')]")).isDisplayed();
				   System.out.println("Result is: " +HomeButton);
				
				   // Test if there is any broken links present in the webpage.
				
				   class BrokenLinks {
					
					public void brokenLink()
					{
					    List<WebElement> links = LinkedIn.findElements(By.tagName("a"));
						System.out.println("Total links present in the page are :" +links.size());
						for(int i=0; i<links.size(); i++)
						{
							WebElement ele = links.get(i);
							String URL = ele.getAttribute("href");
							verifyActiveLinks(URL);
						}
									
						public void verifyActiveLinks(String LinkURL)
						{
							try{
							URL url = new URL (LinkURL);
							HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
							httpURLConnect.setConnectTimeout(3000);
							httpURLConnect.connect();
							if(httpURLConnect.getResponseCode() == 200)
							{
								System.out.println(LinkURL+ " - " +httpURLConnect.getResponseMessage());
							}
							if(httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
							{
								System.out.println(LinkURL+ " - " +httpURLConnect.getResponseMessage()+ " - " +HttpURLConnection.HTTP_NOT_FOUND);
							}			
						}
						catch (Exception e) {
					 }
						LinkedIn.quit();
		           } 
			   }
		   }
				    // Code for taking screenshot in case there is an error.
					
					System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver-v0.16.1-win64\\geckodriver.exe");
					WebDriver LinkedIn = new FirefoxDriver();
					LinkedIn.get("https://www.linkedin.com");		
					LinkedIn.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					LinkedIn.findElement(By.xpath("//input[@placeholder='Email or phone number']")).sendKeys("your incorrect mailid");
					LinkedIn.findElement(By.xpath("//input[contains(@class,'login-password')]")).sendKeys("yourpassword");	
					LinkedIn.findElement(By.xpath("//input[@id='login-submit']")).click();
					
					public void screenshot(testRes result)
					{
						 if (testRes.Failure == result.getStatus())
					     Utility.captureScreenshot(driver, result.getName());
					}
					
					// Code for automating Searchbox
					
					LinkedIn.findElement(By.xpath("//input[@placeholder='Email or phone number']")).sendKeys("your correct mailid");
					LinkedIn.findElement(By.xpath("//input[contains(@class,'login-password')]")).sendKeys("yourpassword");	
					LinkedIn.findElement(By.xpath("//input[@id='login-submit']")).click();
					Thread.sleep(5000);
					LinkedIn.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Artoo");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					List allOptions = driver.findElements(By.xpath("//td/span[text()='Artoo']"));
					
					for (int i = 0; i < allOptions.size(); i++) {
						String option = allOptions.get(i).getText();
						System.out.println(option);
					}
					
					// Browser responsiveness for LinkedIn
					
					System.out.println(LinkedIn.manage().window().getSize());
					Dimension d = new Dimension (420, 600);  
					LinkedIn.manage().window().setSize(d);
	
	}
}
