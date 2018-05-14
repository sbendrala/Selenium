package com.branch.qa.pages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.branch.qa.base.TestBase;
import com.branch.qa.util.BranchTeam;

public class TeamPage extends TestBase {

	@FindBy(xpath = "//div[@class='info-block']/h2")
	@CacheLookup
	List<WebElement> branchMemberName;

	@FindBy(xpath = "//div[@class='info-block']/h4")
	@CacheLookup
	List<WebElement> branchMemberDepartment;

	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'display: inline-block;')]//div[@class='info-block']/h2")
	List<WebElement> branchMembersNamebyDepTab;

	@FindBy(xpath = "//div[@class='row row-centered']//div[contains(@style,'display: inline-block;')]//div[@class='info-block']/h4")
	List<WebElement> branchMembersDeptbyDepTab;

	@FindBy(xpath = "//ul[@class='team-categories']/li")
	@CacheLookup
	List<WebElement> teamCategory;

	// Initialization
	public TeamPage() {
		PageFactory.initElements(driver, this);
	}

	// Verify Title
	public String verifyTeamPageTitle() {
		System.out.println("Verify Page Title on Team Page");
		return driver.getTitle();
	}

	// Print Names
	public boolean printTeamMemberName() {
		for (int i = 0; i < branchMemberName.size(); i++) {

			System.out.print("Name " + branchMemberName.get(i).getText() + "   ");
			System.out.println("Department " + branchMemberDepartment.get(i).getText());

		}
		// Return True
		return true;
	}

	// Verify Employee Number
	public int[] verifyEmployeeNumber() {

		System.out.println("Verify that number of employees match between All tab and sum of other tabs");

		// Store Values Integer arrays
		int[] employees = { 0, 0 };
		employees[0] = branchMemberName.size();

		// Calculate Employee Number by Departments and add it
		for (int i = 1; i < teamCategory.size(); i++) {
			teamCategory.get(i).click();
			// Calculate sum
			employees[1] += branchMembersNamebyDepTab.size();
		}
		System.out.println("Total Employees listed in all tab = " + employees[0]);
		System.out.println("Sum of Employees by department = " + employees[1]);
		return employees;
	}

	public boolean verifyEmployeeNames() {

		System.out.println("Verifying whether employee Names match between All tab and other tabs");
		// Store Values in two Linked List Names and NameByDep
		List<String> Names = new ArrayList<String>();
		List<String> NameByDep = new ArrayList<String>();

		// Set the Flag to True
		boolean flag = true;

		for (int i = 0; i < branchMemberName.size(); i++) {
			Names.add(branchMemberName.get(i).getText());
		}
		for (int i = 1; i < teamCategory.size(); i++) {
			teamCategory.get(i).click();
			for (int j = 0; j < branchMembersNamebyDepTab.size(); j++) {
				NameByDep.add(branchMembersNamebyDepTab.get(j).getText());
			}
		}

		// Test Two Lists and store the Names in a Third List which does not match
		ArrayList<String> namesNotFound = new ArrayList<String>();
		// ArrayList<String> al4 = new ArrayList<String>();
		for (String temp : Names) {
			if (!(NameByDep.contains(temp))) {
				namesNotFound.add(temp);
				flag = false;
			}

			// temp.contains("");
		}
		if (flag)
			System.out.println("employee Names correctly match between All tab and other tabs");
		else
			System.out.println("employee Names does not match between All tab and other tabs "
					+ "Employee Names Not found in other tabs = " + namesNotFound);
		return flag;
	}

	public boolean verifyEmployeeDepartments() {
		// Declare two Linked List object teamAllTab and teamOtherTab to store and
		// compare Name
		// and Dept values
		System.out.println(
				"Verifying whether employee departments are listed correctly between All tab and Department tabs");
		LinkedList<BranchTeam> teamAllTab = new LinkedList<BranchTeam>();
		LinkedList<BranchTeam> teamOtherTab = new LinkedList<BranchTeam>();
		// Set the Flag to True
		boolean flag = true;
		// Store Team Member Details in All Tab
		for (int i = 0; i < branchMemberName.size(); i++) {
			teamAllTab.add(new BranchTeam(branchMemberName.get(i), branchMemberDepartment.get(i)));
		}

		for (int i = 1; i < teamCategory.size(); i++) {
			teamCategory.get(i).click();
			for (int j = 0; j < branchMembersNamebyDepTab.size(); j++) {
				teamOtherTab.add(new BranchTeam(branchMembersNamebyDepTab.get(j), branchMembersDeptbyDepTab.get(j)));
			}
		}
		// Compare Department Values
		for (int i = 0; i < teamAllTab.size(); i++) {
			for (int k = 0; k < teamOtherTab.size(); k++) {
				if (teamAllTab.get(i).employeeName == teamOtherTab.get(k).employeeName
						&& teamAllTab.get(i).employeeDepartment != teamOtherTab.get(k).employeeDepartment) {
					System.out.println("Departments does not match for Employee " + teamAllTab.get(i).employeeName);
					flag = false;
					break;
				}
			}

		}
		if (flag)
			System.out.println("employee departments are listed correctly between All tab and Department tabs");
		else
			System.out.println("employee departments are not listed correctly between All tab and Department tabs");
		return flag;
	}

}
