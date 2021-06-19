package rediff.pack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver.pack.BrowserDrivers;

public class RediffTestRunner extends BrowserDrivers {
	WebDriver driver = null;
	RediffMailTest rediffMailTest = null;

	@BeforeMethod(alwaysRun = true)
	void beforeMethod() {
		driver = getChromeDriver();
		rediffMailTest = new RediffMailTest(driver);
	}

	@Test(groups= {"RegressionTest"})
	public void rediffMailAlertTest() throws InterruptedException {

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		rediffMailTest.clickSignInButton();
		Thread.sleep(2000);
		String expectedAlertText = "Please enter a valid user name";
		String actualAlertText = rediffMailTest.getAlertText();
		Assert.assertEquals(actualAlertText, expectedAlertText);

	}

	@AfterMethod(alwaysRun = true)
	void afterMethod() {
		driver.close();
	}

}
