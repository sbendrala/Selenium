package com.branch.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.branch.qa.base.TestBase;
import com.branch.qa.pages.GooglePage;
import com.branch.qa.pages.HomePage;
import com.branch.qa.pages.TeamPage;

public class HomePageTest extends TestBase {
	GooglePage googlePage;
	 HomePage homePage;
	 TeamPage teamPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		
		 googlePage=new GooglePage();
		 homePage=new HomePage();
	}
	
	@Test(priority=1)
	public void navigateBranchTest() {
		homePage= googlePage.clickBranchLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
