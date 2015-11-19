package org.cleartrip.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.cleartrip.maincontroller.MainController;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/*
 * @author Hemanth.Sridhar
 */
public class Screenshot extends MainController {
	final static String sourcefile = "C:/Users/USER/workspace/Hemanth_Framework/resources/screenshot"
	 		+ "screenshot.jpg";
public static void captureScreenShot(WebDriver driver, String screenshotName) throws IOException{
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png"));
}
}
