package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResgisterPageObjects {

	public WebDriver driver;

	private By Firstname = By.xpath("//input[@name='firstname']");
	private By LastName = By.xpath("//input[@name='lastname']");
	private By EMail = By.xpath("//input[@name='email']");
	private By Telephone = By.xpath("//input[@name='telephone']");
	private By Password = By.xpath("//input[@name='password']");
	private By PasswordConfirm = By.xpath("//input[@name='confirm']");
	private By agree = By.xpath("//input[@name='agree']");
	private By Continue = By.xpath("//input[@value='Continue']");
	
	private By registerationSucesfull= By.xpath("//h1[text()='Your Account Has Been Created!']");

	private By FirstNameErrorMsg = By.xpath("(//div[@class='text-danger'])[1]");
	private By LastNameErrorMsg = By.xpath("(//div[@class='text-danger'])[2]");
	private By emailErrorMsg = By.xpath("(//div[@class='text-danger'])[3]");
	private By TelephoneErrorMsg = By.xpath("(//div[@class='text-danger'])[4]");
	private By passwordErrorMsg = By.xpath("(//div[@class='text-danger'])[5]");
	private By privacyPolicyAlert = By.xpath("//div[text()= ' Warning: You must agree to the Privacy Policy!']");
	private By confirmPasswordErrorMessage = By.xpath("//div[@class = 'text-danger']");
	private By emailAlertmsg = By.xpath("//div[text() = ' Warning: E-Mail Address is already registered!']");

	public ResgisterPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement EnterFirstName() {
		return driver.findElement(Firstname);
	}

	public WebElement EnterLastName() {
		return driver.findElement(LastName);
	}

	public WebElement EnterEMail() {
		return driver.findElement(EMail);
	}

	public WebElement EnterTelephone() {
		return driver.findElement(Telephone);
	}

	public WebElement EnterPassword() {
		return driver.findElement(Password);
	}

	public WebElement EnterPasswordConfirm() {
		return driver.findElement(PasswordConfirm);
	}

	public WebElement clickOnagree() {
		return driver.findElement(agree);
	}

	public WebElement clickOnContinue() {
		return driver.findElement(Continue);
	}

	public WebElement getFIrstNameErrorMessage() {
		return driver.findElement(FirstNameErrorMsg);
	}
	public WebElement getEmaliErromsg() {
		return driver.findElement(emailErrorMsg);

	}
	
	public WebElement getRegisteratipnSuccesfullText() {
		return driver.findElement( registerationSucesfull);

	}

}
