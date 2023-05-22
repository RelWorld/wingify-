package com.relevelProject.qa.testCases;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.relevelProject.qa.testComponents.baseTest;
import relevelProject001.data.GetExcelData;

public class LoginPageFunctionality extends baseTest {


  //valid username and password
	@Test(priority = 1,enabled = true)
	public void validLogIn() throws IOException, InterruptedException {

		List <Map<String,String>> testDataInMap =GetExcelData.getTestdatInMap();
		landingPage.typeUserName(testDataInMap.get(0).get("username"));
		landingPage.typePassword(testDataInMap.get(0).get("password"));
		//Thread.sleep(5000);
		landingPage.clickLogInButton();
		//Thread.sleep(5000);

	}
//	valid credentials by using enter button
	@Test(priority = 2,enabled = true)
	public void validLogInByEnter() throws IOException, InterruptedException {
		List <Map<String,String>> testDataInMap =GetExcelData.getTestdatInMap();
		landingPage.typeUserName(testDataInMap.get(1).get("username"));
		landingPage.typePassword(testDataInMap.get(1).get("password"));
		//Thread.sleep(5000);
		landingPage.pressEnterButtonOnPassword();
		//Thread.sleep(5000);
	}

	//blank username and password
	@Test(priority = 4,enabled = true)
	public void blankLogIn() throws IOException, InterruptedException {
		landingPage.clickLogInButton();
		String warningText=landingPage.getErrorMessage();
		Assert.assertEquals(warningText,"Both Username and Password must be present");
	}

	//check box functionality , enable or not
	@Test(priority = 3,enabled = true)
	public void pasBoxenable() throws IOException, InterruptedException {
		List <Map<String,String>> testDataInMap =GetExcelData.getTestdatInMap();
		landingPage.typeUserName(testDataInMap.get(2).get("username"));
		landingPage.typePassword(testDataInMap.get(2).get("password"));
		landingPage.CheckBoxCheck();
		boolean enable = landingPage.checkBoxEnale();
		Assert.assertTrue(enable);


	}
	//social media integration
	@Test(priority = 8,enabled = false)
	public void twiterNavigation() throws IOException, InterruptedException {
		landingPage.twitterLogin();
		String title =initializeDriver().getTitle();
		Assert.assertNotEquals(title,"Demo App");
	}

	//social media integration
	@Test(priority = 9,enabled = false)
	public void faceBookNavigation() throws IOException, InterruptedException {
		landingPage.facebookLogin();
		String title =initializeDriver().getTitle();
		Assert.assertNotEquals(title,"Demo App");
	}


	//social media integration
	@Test(priority = 10,enabled = false)
	public void linkedinNavigation() throws IOException, InterruptedException {
		landingPage.linkedinLogin();
		String title =initializeDriver().getTitle();
		Assert.assertNotEquals(title,"Demo App");
	}
	//blank username and valid password
	@Test(priority = 5,enabled = true)
	public void blankU_validP_combo() throws IOException, InterruptedException {
		List <Map<String,String>> testDataInMap =GetExcelData.getTestdatInMap();
		landingPage.typePassword(testDataInMap.get(0).get("password"));
		//Thread.sleep(5000);
		landingPage.login.click();
		//Thread.sleep(5000);
		String warningText = landingPage.getErrorMessage();
		Assert.assertEquals(warningText,"Username must be present");
	}

	//valid username and blank password
	@Test(priority = 6,enabled = true)
	public void validU_blankP_combo() throws IOException, InterruptedException {
		List <Map<String,String>> testDataInMap =GetExcelData.getTestdatInMap();
		landingPage.typeUserName(testDataInMap.get(0).get("password"));
		//Thread.sleep(5000);
		landingPage.clickLogInButton();
		//Thread.sleep(5000);
		String warningText = landingPage.getErrorMessage();
		Assert.assertEquals(warningText,"Password must be present");
	}



}
