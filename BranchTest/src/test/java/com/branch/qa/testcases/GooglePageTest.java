package com.branch.qa.testcases;

import com.branch.qa.base.TestBase;
import com.branch.qa.pages.GooglePage;
import com.branch.qa.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class GooglePageTest extends TestBase{
	 GooglePage googlePage;
	 HomePage homePage;
	
	public GooglePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		
		 googlePage=new GooglePage();
	}
	
	@Test(priority=1)
	public void navigateBranchTest() {
		homePage= googlePage.clickBranchLink();
	}
	
	
	@AfterMethod
	public void tearDpwn() {
		driver.close();
	}
	
	

}
