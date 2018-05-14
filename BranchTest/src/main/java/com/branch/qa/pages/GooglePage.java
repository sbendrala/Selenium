package com.branch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.branch.qa.base.TestBase;

public class GooglePage extends TestBase {

	// Page Factory Objects
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchInputField;

	@FindBy(xpath = "//input[@name='btnK']")
	WebElement clickSearch;

	@FindBy(xpath = "//a[contains(.,'Branch - A mobile linking platform powering deep links and mobile')]")
	WebElement clickBranchLink;

	// Initialization
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	// Perform Actions
	
	
	public HomePage clickBranchLink() {
		// Input "Branch" in the search field
		searchInputField.sendKeys("branch");

		// Click Google Search
		clickSearch.click();

		// Click "Branch.io" Link
		clickBranchLink.click();

		return new HomePage();

	}

}
