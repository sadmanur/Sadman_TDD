package rediff.pack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffMailTest {

	WebDriver driver = null;

	public RediffMailTest(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignInButton() {

		WebElement signInButton = driver.findElement(By.name("proceed"));
		signInButton.click();

	}

	public String getAlertText() {

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

}
