package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObjects;
import pageObjectModel.ResgisterPageObjects;
import resources.baseClass;
import resources.commonMethods;
import resources.testData;

public class registerTestCases extends baseClass {
//changesbygaurav
	@Test(priority=1)
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {


		HomePageObjects hpo = new HomePageObjects(driver);
        commonMethods.handleExplictWait(driver, 3, hpo.clickOnmyaccount());

		hpo.clickOnmyaccount().click();
		hpo.clickOnRegister().click();

		ResgisterPageObjects rpo = new ResgisterPageObjects(driver);

		rpo.EnterFirstName().sendKeys(testData.firstname);
		rpo.EnterLastName().sendKeys(testData.lastname);
		rpo.EnterEMail().sendKeys(emailId);
		rpo.EnterTelephone().sendKeys(testData.telephome);
		rpo.EnterPassword().sendKeys(testData.password);
		rpo.EnterPasswordConfirm().sendKeys("test");
		rpo.clickOnagree().click();
		rpo.clickOnContinue().click();
		
		
		String expected=testData.regisgterationSuccessExpected; //requirement document
		String actual= rpo.getRegisteratipnSuccesfullText().getText(); //after running the scripts
		
		commonMethods.handleAssertion(actual, expected);
	}

	@Test(enabled=false)
	public void verifyRegisterationWithInvalidData() throws IOException, InterruptedException {


		HomePageObjects hpo = new HomePageObjects(driver);

		Thread.sleep(4000);

		hpo.clickOnmyaccount().click();
		hpo.clickOnRegister().click();

		ResgisterPageObjects rpo = new ResgisterPageObjects(driver);

		rpo.EnterFirstName().sendKeys(testData.firstname);
		rpo.EnterLastName().sendKeys(testData.lastname);
		rpo.EnterEMail().sendKeys("testasjdb@gmail.com");
		rpo.EnterTelephone().sendKeys("9235363890");
		rpo.EnterPassword().sendKeys("test");
		rpo.EnterPasswordConfirm().sendKeys("test");
		rpo.clickOnagree().click();
		rpo.clickOnContinue().click();
		
		
	}

	@Test(priority=2)
	public void verifyRegisterationWithBlankData() throws IOException, InterruptedException {

		HomePageObjects hpo = new HomePageObjects(driver);

        commonMethods.handleExplictWait(driver, 3, hpo.clickOnmyaccount());

		hpo.clickOnmyaccount().click();
		hpo.clickOnRegister().click();

		ResgisterPageObjects rpo = new ResgisterPageObjects(driver);

		rpo.clickOnContinue().click();
	
		String fnExpected=testData.firstNameExpectedText;
		String fnActual=rpo.getFIrstNameErrorMessage().getText();
		
		String emailExpected=testData.EmailExpectedText;
		String emailActual=rpo.getEmaliErromsg().getText();
		
		commonMethods.handleAssertion(fnActual, fnExpected);
	
		commonMethods.handleAssertion(emailActual, emailExpected);
		
		
	}
}
