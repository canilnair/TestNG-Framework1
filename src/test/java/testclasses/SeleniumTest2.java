package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import supportlibrary.BaseSetup;

public class SeleniumTest2 extends BaseSetup{
	
	@Test
	public void selenium_testmethod2(){
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		
		WebElement emailID = driver.findElement(By.id("signUpDialogemailInputinput"));
		//emailID.click();
		emailID.sendKeys("test1@email.com");
		
		WebElement passwordField1 = driver.findElement(By.id("signUpDialogpasswordInputinput"));		
		passwordField1.sendKeys("abcabc");
		
		WebElement passwordField2 = driver.findElement(By.id("signUpDialogretypePasswordInputinput"));		
		passwordField2.sendKeys("abcabc");
		
		WebElement goButton = driver.findElement(By.id("signUpDialogoklabel"));
		goButton.click();
		
		try{
			Thread.sleep(1000);
			} 
		catch(Exception e){
				
			}
		
		WebElement errorText = driver.findElement(By.id("signUpDialogerrMsg"));
		String actual = errorText.getText();
		Reporter.log("Value taken from screen is: "+ actual, true);
		
		Assert.assertTrue(actual.equals("Email is already taken"));
	}

}
