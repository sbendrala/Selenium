package com.branch.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.branch.qa.base.TestBase;
import com.branch.qa.util.TestUtil;

public class HomePage extends TestBase {

	// Page Factory Objects
	@FindBy(xpath = "//footer//a[.='Team']")
	WebElement footerteamlink;
	
	@FindBy(xpath = "//header//p[.='Sign In']")
	WebElement signInLink;

	// Initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public TeamPage clickTeamPageLink() {
		// Wait Until Page is Click able
		TestUtil.wait(footerteamlink);
		
		// Bring Element to the View Port
		JavascriptExecutor bringFront = (JavascriptExecutor) driver;
		bringFront.executeScript("arguments[0].scrollIntoView()", footerteamlink);

		footerteamlink.click();
		return new TeamPage();
	}
	
	public SignInPage clickSignInPageLink() {
		// Wait Until Page is Click able
		TestUtil.wait(signInLink);
		
		signInLink.click();
		return new SignInPage();
	}
}
