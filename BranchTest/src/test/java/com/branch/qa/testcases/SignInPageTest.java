package com.branch.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.branch.qa.base.TestBase;
import com.branch.qa.pages.GooglePage;
import com.branch.qa.pages.HomePage;
import com.branch.qa.pages.SignInPage;
import com.branch.qa.util.TestUtil;

public class SignInPageTest extends TestBase{
	GooglePage googlePage;
	HomePage homePage;
	SignInPage signInPage;
	TestUtil testUtil;

	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		testUtil = new TestUtil();
		googlePage = new GooglePage();
		homePage = googlePage.clickBranchLink();
		signInPage = homePage.clickSignInPageLink();
	}
	
	@Test(priority = 1, enabled = true)
	public void verifySignUpFieldsTest() {
		Assert.assertTrue(signInPage.verifySignUpFields());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
