package com.branch.qa.util;

import org.openqa.selenium.WebElement;

public class BranchTeam {
	public String employeeName;
	public String employeeDepartment;
	public BranchTeam(){
		employeeName="";
		employeeDepartment="";
	}
	
	public BranchTeam(WebElement name, WebElement dept ){
		employeeName=name.getText();
		employeeDepartment=dept.getText();
	}
	
	public BranchTeam(String name, String dept ){
		employeeName=name;
		employeeDepartment=dept;
	}
	

}
