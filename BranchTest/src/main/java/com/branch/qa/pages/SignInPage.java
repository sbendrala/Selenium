package com.branch.qa.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.branch.qa.base.TestBase;
import com.branch.qa.util.TestUtil;

public class SignInPage extends TestBase {

	// Page Factory Objects
	@FindBy(xpath = "//div[@class='sign-up-1']/div[@class='input-control']")
	List<WebElement> signUpFields;

	@FindBy(xpath = "//button[.='Sign up']")
	WebElement signUpButton;

	// Initialization
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifySignUpFields() {
		boolean flag = true;
		System.out.println("Verify Input Fiels in SignUp Page");
		try {
			TestUtil.wait(signUpButton);
			for (int i = 0; i < signUpFields.size(); i++) {
				if (!signUpFields.get(i).isDisplayed()) {
					System.out.println("Input Field " + signUpFields.get(i).getText() + " is not Displayed");
					flag = false;
				}
			}
			if (!signUpButton.isDisplayed()) {
				System.out.println("Sign Up button is not Displayed");
				flag = false;
			}
			if (flag)
				System.out.println("All Input Fields have been verified successfully");
			else
				System.out.println("Input Fields have not been verified successfully");
			return flag;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element " + e.getMessage());
			flag = false;
			return flag;
		}

	}

	@FindBy(xpath = "//header//p[.='Sign In']")
	WebElement signInLink;

}
