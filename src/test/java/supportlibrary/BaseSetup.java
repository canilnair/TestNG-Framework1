package supportlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public abstract class BaseSetup {
	
	protected SoftAssert ass =new SoftAssert();
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class\n");
	}
	
	
	protected WebDriver driver;
	private String baseUrl;	
	
	@BeforeMethod
	public void beforeMethod(){
		baseUrl = "http://www.letskodeit.com/";		
		Reporter.log("Before Method", true);
		driver = new FirefoxDriver();

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		Reporter.log("After Method", true);
		
		if (!result.isSuccess()) {
			ScreenShots.testScreenShots(driver, ("FAIL-"+result.getName()));			
		} else {
				
			ScreenShots.testScreenShots(driver, ("PASS-"+result.getName()));			
		}

		driver.quit();
	}	
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}

	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}	

	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}

}
