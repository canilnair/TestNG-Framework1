package supportlibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class MyTestListners implements ITestListener {
	
	protected String name = null;

	public void onStart(ITestContext context) {
		name = context.getName();
		Reporter.log("On Start Listner: Test Group Name = "+name+"\n", true);	
	}
	
	public void onTestStart(ITestResult result) {
		name = result.getMethod().getMethodName();
		Reporter.log("On Test Start Listner: Begining Test name : " +name+" started execution", true);
	}

	public void onTestSuccess(ITestResult result) {
		name = result.getMethod().getMethodName();
		Reporter.log("On Test Success Listner: Test Name : "+name+" Passed successfully", true);		
	}
	
	public void onTestFailure(ITestResult result) {
		name = result.getName();
		Reporter.log("On Test Fail Listner -> I Can Take Screen Shots & Test Method "+name+" has FAILED", true);
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onTestSkipped(ITestResult result) {
		String skipped = result.getName();
		Reporter.log("On Test Skipped Listner - Test Method: "+skipped+" SKIPPED", true);
		
	}

	public void onFinish(ITestContext context) {
		name = context.getName();
		Reporter.log("\nOn Finish Listner: Test Group Name = "+name+" Finished Execution\n", true);
		Reporter.log("Passed Tests: " + context.getPassedTests().size(), true);
		Reporter.log("Failed Tests:" + context.getFailedTests().size(), true);
		Reporter.log("Skipped Tests: "+context.getSkippedTests().size()+"\n", true);
		
	}
}
