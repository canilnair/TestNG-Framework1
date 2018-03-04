package supportlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	
	public static void testScreenShots(WebDriver driver, String fileName) throws IOException{
		
		File ImageFileName = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String directory = "D:/JavaWorkspace/TestAutomationFramework/screenshots/";
		fileName = fileName+"-"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
		
		FileUtils.copyFile(ImageFileName, new File(directory+fileName));
		
	}
}
