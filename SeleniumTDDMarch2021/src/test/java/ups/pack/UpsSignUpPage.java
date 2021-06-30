package ups.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsSignUpPage {

	WebDriver driver = null;
	public WebDriver driver2;

	public UpsSignUpPage(WebDriver driver2) {
		this.driver2 = driver;
	}

	public void UpsSignUp(WebDriver driver) {
		this.driver = driver;
	}

	public void accountName(String name) {
		WebElement accountName = driver.findElement(By.name("fullName"));
		accountName.sendKeys(name);

	}

	public void emailAccount(String email) {
		WebElement emailAccount = driver.findElement(By.xpath("//*[@id=\"ups-email_input\"]"));
		emailAccount.sendKeys(email);
	}

	public void userID(String user) {
		WebElement userID = driver.findElement(By.id("ups-user_id_input"));
		userID.sendKeys(user);
	}

	public void password(String pass) {
		WebElement password = driver.findElement(By.id("ups-user_password_input"));
		password.sendKeys(pass);
	}

	public void countryCode() {
		WebElement countryCode = driver.findElement(By.name("phoneCountryCode"));
		countryCode.click();
	}

	public void phoneNumberInput(CharSequence string) {
		WebElement phoneNumberInput = driver.findElement(By.name("phoneInput"));
		phoneNumberInput.sendKeys(string);

	}

	public void checkBox() {
		WebElement checkBox = driver.findElement(By.className("ups-checkbox-custom-label"));
		checkBox.click();
	}

	public void signUpButton() {
		WebElement signUpButton = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/fullpage-doa/main-component/div/login-register/div/div/div[2]/div[2]/form/div[4]/div/div/div[2]/div/div/button/span"));
		signUpButton.click();
	}

	public String upsSignUpNoInputError() {
		WebElement errorMessages = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/fullpage-doa/main-component/div/login-register/div/div/div[2]/div[2]/form/div[1]/div/div/h3"));
		String message = errorMessages.getText();
		return message;
	}

}
