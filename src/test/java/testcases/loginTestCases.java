package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObjects;
import pageObjectModel.LoginPageObjects;
import resources.baseClass;
import resources.commonMethods;
import resources.testData;

public class loginTestCases extends baseClass{
	
	
	@Test
	public void verifyLoginWithValidData() throws IOException, InterruptedException {
		

		HomePageObjects hpo = new HomePageObjects(driver);

        commonMethods.handleExplictWait(driver, 5, hpo.clickOnmyaccount());

		hpo.clickOnmyaccount().click();
		hpo.clickOnLogin().click();
		
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		lpo.enterEmail().sendKeys(emailId);
		lpo.enterPassword().sendKeys(testData.password);
		lpo.clickOnLogin().click();
		
		
		String expected=testData.loginExpectedText; //requirement document 
 		String actual= lpo.getLoginSuccessfulText().getText(); //after running the scripts 

 
 		commonMethods.handleAssertion(actual, expected);
 		
	
	}
	
	

	@Test
	public void verifyLoginWithInValidData() throws IOException, InterruptedException {
		


		HomePageObjects hpo = new HomePageObjects(driver);

        commonMethods.handleExplictWait(driver, 3, hpo.clickOnmyaccount());

		hpo.clickOnmyaccount().click();
		hpo.clickOnLogin().click();
		
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		lpo.enterEmail().sendKeys("");
		lpo.enterPassword().sendKeys("test");
		lpo.clickOnLogin().click();
		
		
		String expected=testData.loginErrorTextExpected; //requirement document 
 		String actual= lpo.getLoginFailedText().getText(); //after running the scripts 

 		commonMethods.handleAssertion(actual, expected);
		
	}


}
