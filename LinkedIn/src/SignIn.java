import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SignIn {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win64/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		//		 Launch the LinkedIn Website
		 
				 driver.get("https://www.linkedin.com/");
				 String expectedTitle = "LinkedIn: Log In or Sign Up";
				 String actualTitle = "";
				 actualTitle = driver.getTitle();
				 if (actualTitle.contentEquals(expectedTitle)){
			            System.out.println("TC1::LinkedIn launch Test Passed!");
			        } else {
			            System.out.println("TC1::LinkedIn launch Test Failed");
			        }
				 
				 
		//		 Login to  the LinkedIn website
				 
				 
				 driver.findElement(By.id("login-email")).sendKeys("revup10.laas@gmail.com");
				 driver.findElement(By.id("login-password")).sendKeys("Pass@123");
				 driver.findElement(By.id("login-submit")).click();
				 Thread.sleep(4000);
				 String expectedHomeTitle = "LinkedIn";
				 String actualHomeTitle = "";
				 Thread.sleep(4000);
				 actualHomeTitle = driver.getTitle();
				 Thread.sleep(2000);
				 if (actualHomeTitle.contentEquals(expectedHomeTitle)){
			            System.out.println("TC2::LinkedIn Login Test Passed!");
			        } else {
			            System.out.println("TC2::LinkedIn Login test Failed");
			        }
				 
		//		 Search a company in LinkedIn
//				
//				 java.util.Scanner scn =new java.util.Scanner(System.in);
//				 System.out.println("Please enter the company to be searched");
//				 String a=scn.next();
//				 Thread.sleep(2000);
				 String a = "Reverie";
				 driver.findElement(By.xpath("//div[@class='type-ahead-input']/input")).sendKeys(a);
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[@class='nav-search-controls']")).click();
				 Thread.sleep(3000);
				 String s = " | Search | LinkedIn";
				 String expectedSearchTitle = "\""+a+"\""+s;
				 String actualSearchTitle = "";
				 Thread.sleep(4000);
				 actualSearchTitle = driver.getTitle();
				 Thread.sleep(2000);
				 if (actualSearchTitle.contentEquals(expectedSearchTitle)){
			            System.out.println("TC3::Search Test Passed!");
			        } else {
			            System.out.println("TC3::Search test Failed");
			        }
				  System.out.println("Company name :"+a); 
				  
//	SignOut from LinkedIn
				  
				 driver.findElement(By.xpath("//div[@id='nav-settings__dropdown']")).click();
				 driver.findElement(By.xpath("//a[text()='Sign out']")).click();
				 Thread.sleep(3000);
				 actualTitle = driver.getTitle();
				 if (actualTitle.contentEquals(expectedTitle)){
			            System.out.println("TC4::LinkedIn SignOut Test Passed!");
			        } else {
			            System.out.println("TC4::LinkedIn SignOut Test Failed");
			        }
		 

}
}
	 
