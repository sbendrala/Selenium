package com.branch.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.branch.qa.base.TestBase;
import com.branch.qa.pages.GooglePage;
import com.branch.qa.pages.HomePage;
import com.branch.qa.pages.TeamPage;
import com.branch.qa.util.TestUtil;

public class TeamPageTest extends TestBase {
	GooglePage googlePage;
	HomePage homePage;
	TeamPage teamPage;
	TestUtil testUtil;

	public TeamPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		testUtil = new TestUtil();
		googlePage = new GooglePage();
		homePage = googlePage.clickBranchLink();
		teamPage = homePage.clickTeamPageLink();
	}


	@Test(priority = 1, enabled = true)
	public void verifyEmployeeNumberTest() {
		int[] employees = teamPage.verifyEmployeeNumber();
		Assert.assertEquals(employees[1], employees[0]);
	}

	@Test(priority = 2, enabled = false)
	public void verifyEmployeeNameTest() {
		Assert.assertTrue(teamPage.verifyEmployeeNames());
	}
	
	@Test(priority = 3, enabled = false)
	public void verifyEmployeeDeptTest() {
		Assert.assertTrue(teamPage.verifyEmployeeDepartments());
	}
	
	@Test(priority = 4, enabled = false)
	public void verifyTitleTest() {
		String pageTitle = teamPage.verifyTeamPageTitle();
		Assert.assertEquals(pageTitle, "Branch Metrics - The Team");
	}
	
	@Test(priority = 5, enabled = false)
	public void printTeamMemberNamesTest() {
		boolean flag = teamPage.printTeamMemberName();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
