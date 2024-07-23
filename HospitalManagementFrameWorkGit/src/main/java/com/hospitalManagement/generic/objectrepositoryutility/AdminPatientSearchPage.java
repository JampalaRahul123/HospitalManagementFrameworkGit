package com.hospitalManagement.generic.objectrepositoryutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hospitalManagement.generic.webdriverutility.WebDriverUtility;

public class AdminPatientSearchPage extends WebDriverUtility {
WebDriver driver;

	public AdminPatientSearchPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(xpath = "//input[@name='searchdata']")
	private WebElement adminPatientSearchBoxEdit;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement adminPatientSearchButtonEdit;
	
	@FindBy(xpath = "//tr[last()]/td[last()]/descendant::i[contains(@class,'fa')]")
	private WebElement adminPatientDetailsView;

	public WebElement getadminPatientSearchBoxEdit() {
		return adminPatientSearchBoxEdit;
	}

	public WebElement getadminPatientSearchButtonEdit() {
		return adminPatientSearchButtonEdit;
	}

	public WebElement getPatientDetailsEdit() {
		return adminPatientDetailsView;
	}	
	public void adminPatientSearch(String name) throws IOException {
		adminPatientSearchBoxEdit.sendKeys(name);
		adminPatientSearchButtonEdit.click();
		adminPatientDetailsView.click();
		Screenshot(driver, name);
	}
}
