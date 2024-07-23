package com.hospitalManagement.generic.objectrepositoryutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hospitalManagement.generic.webdriverutility.WebDriverUtility;

public class DoctorPatientSearchPage extends WebDriverUtility{
WebDriver driver;
	
	public DoctorPatientSearchPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	
	@FindBy(xpath = "//input[@name='searchdata']")
	private WebElement doctorPatientSearchBoxEdit;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement doctorPatientSearchButtonEdit;
	
	@FindBy(xpath ="//tr[last()]/descendant::i[contains(@class,'eye')]")
	private WebElement doctorPatientDetailsView;

	public WebElement getDoctorPatientDetailsView() {
		return doctorPatientDetailsView;
	}
	public void doctorPatientSearch(String name) throws IOException {
		doctorPatientSearchBoxEdit.sendKeys(name);
		doctorPatientSearchButtonEdit.click();
		doctorPatientDetailsView.click();
		Screenshot(driver, name);
}
}