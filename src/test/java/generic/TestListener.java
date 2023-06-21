package generic;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{

	 

		public void onTestFailure(ITestResult result)
		{
			
			String testName = result.getName();
			String timeStamp = Util.getTimeStamp();
			ScreenShot.takeDesktopScreenShot("./images/"+testName+timeStamp+".png");

			
		}


}
