package ups.pack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.pack.BrowserDrivers;

public class UPSTestRunner extends BrowserDrivers {

	WebDriver driver = null;
	UpsLoginPage upsLoginPage = null;
	UpsSignUpPage upsSignUpPage = null;

	@BeforeMethod(alwaysRun = true)
	void beforeMethod() {

		driver = getChromeDriver();
		upsLoginPage = new UpsLoginPage(driver);
		upsSignUpPage = new UpsSignUpPage(driver);
	}

	@Test(priority = 3, groups= {"SanityTest"})
	void loginErrorMessageTest() {
		driver.get("https://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		upsLoginPage.userId("testUser");
		upsLoginPage.password("myPassword");
		upsLoginPage.clickLoginButton();
		String errorMessage = upsLoginPage.upsLoginErrorMessageTest();
		if (errorMessage.contains("unsuccessful")) {
			System.out.println("PASSED!");
		} else {
			System.out.println("FAILED");
			Assert.fail();
		}
	}
		
		@Test(priority = 1, groups= {"SanityTest"})
		void upsSignUpNoInputError()  {
			driver.get("https://wwwapps.ups.com/doapp/signup");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			upsSignUpPage.accountName("Johnny");
			upsSignUpPage.emailAccount("johnny@gmail.com");
			upsSignUpPage.userID("John123");
			upsSignUpPage.password("L93TQw");
			upsSignUpPage.countryCode();
			upsSignUpPage.phoneNumberInput("7182345641");
			upsSignUpPage.checkBox();
			upsSignUpPage.signUpButton();
			String errorMessage = upsSignUpPage.upsSignUpNoInputError();
			if (errorMessage.contains("unsuccessful")) {
				System.out.println("PASSED!");
			} else {
				System.out.println("FAILED");
				Assert.fail();
			}
		
			
			
		}
		

	

	@Test(priority = 4, groups= {"RegressionTest"})
	public void signUpLinkTest() throws InterruptedException {
		driver.get("https://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		upsLoginPage.clickSignUpLink();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Sign Up | UPS");

	}

	@Test(priority = 2, groups= {"SanityTest"})
	public void myDemoTest1() {
		System.out.println("My DemoTest 1 executed.......");
	}

	@Test(priority = 1, groups= {"RegressionTest"})
	public void myDemoTest2() {
		System.out.println("My DemoTest 2 executed.......");
	}

	@AfterMethod(alwaysRun = true)
	void afterMethod() {
		driver.close();
	}

}
