package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage{
WebDriver driver;
	
	public AddPatientPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='patname']")
	private WebElement patientNameEdit;
	
	@FindBy(xpath = "//input[@name='patcontact']")
	private WebElement patientContactEdit;
	
	@FindBy(xpath = "//input[@name='patemail']")
	private WebElement patientEmailEdit;
	
	@FindBy(xpath = "(//div[@class='form-group'])[last()-3]/descendant::label[contains(.,'Female')]")
	private WebElement femaleRadioButton;
	
	@FindBy(xpath = "(//div[@class='form-group'])[last()-3]/descendant::label[contains(.,'Male')]")
	private WebElement maleRadioButton;
	
	@FindBy(xpath = "//textarea[@name='pataddress']")
	private WebElement patientAddressEdit;
	
	@FindBy(xpath = "//input[@name='patage']")
	private WebElement patientAgeEdit;
	
	@FindBy(xpath = "//textarea[@name='medhis']")
	private WebElement patientMedicalHistoryEdit;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement addPatientButton;

	public WebElement getPatientNameEdit() {
		return patientNameEdit;
	}

	public WebElement getPatientContactEdit() {
		return patientContactEdit;
	}

	public WebElement getPatientEmailEdit() {
		return patientEmailEdit;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getPatientAddressEdit() {
		return patientAddressEdit;
	}

	public WebElement getPatientAgeEdit() {
		return patientAgeEdit;
	}

	public WebElement getPatientMedicalHistoryEdit() {
		return patientMedicalHistoryEdit;
	}

	public WebElement getaddPatientButton() {
		return addPatientButton;
	}
	public void addMalePatient(String Name, String Contact, String Email,String Address,String Age,String MedicalHistory) {
		patientNameEdit.sendKeys(Name);
		patientContactEdit.sendKeys(Contact);
		patientEmailEdit.sendKeys(Email);
		femaleRadioButton.click();
		patientAddressEdit.sendKeys(Address);
		patientAgeEdit.sendKeys(Age);
		patientMedicalHistoryEdit.sendKeys(MedicalHistory);
		addPatientButton.click();
}
	public void addFemalePatient(String Name, String Contact, String Email,String Address,String Age,String MedicalHistory) {
		patientNameEdit.sendKeys(Name);
		patientContactEdit.sendKeys(Contact);
		patientEmailEdit.sendKeys(Email);
		maleRadioButton.click();
		patientAddressEdit.sendKeys(Address);
		patientAgeEdit.sendKeys(Age);
		patientMedicalHistoryEdit.sendKeys(MedicalHistory);
		addPatientButton.click();
}
}