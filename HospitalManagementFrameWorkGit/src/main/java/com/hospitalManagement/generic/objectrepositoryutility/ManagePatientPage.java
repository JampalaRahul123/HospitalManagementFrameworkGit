package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientPage {
WebDriver driver;
	
	public ManagePatientPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//tr[last()]/child::td[last()-5]")
	private WebElement patientNameEdit;
	
	public WebElement getPatientNameEdit() {
		return patientNameEdit;
	}
}
