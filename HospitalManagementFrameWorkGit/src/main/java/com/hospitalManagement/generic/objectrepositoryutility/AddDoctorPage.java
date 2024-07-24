package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hospitalManagement.generic.webdriverutility.WebDriverUtility;

public class AddDoctorPage extends WebDriverUtility {
WebDriver driver;
	
	public AddDoctorPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement specializationDD;
	
	@FindBy(xpath = "//input[@name='docname']")
	private WebElement doctorNameEdit;
	
	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement clinicAddressEdit;
	
	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement doctorFeesEdit;
	
	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement doctorContactEdit;
	
	@FindBy(xpath = "//input[@name='docemail']")
	private WebElement doctorEmailEdit;
	
	@FindBy(xpath = "//input[@name='npass']")
	private WebElement newPasswordEdit;
	
	@FindBy(xpath = "//input[@name='cfpass']")
	private WebElement confirmPasswordEdit;
	
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement addDoctorButton;

	public WebElement getDoctorspecializationDD() {
		return specializationDD;
	}

	public WebElement getDoctorNameEdit() {
		return doctorNameEdit;
	}

	public WebElement getClinicAddressEdit() {
		return clinicAddressEdit;
	}

	public WebElement getDoctorFeesEdit() {
		return doctorFeesEdit;
	}

	public WebElement getDoctorContactEdit() {
		return doctorContactEdit;
	}

	public WebElement getDoctorEmailEdit() {
		return doctorEmailEdit;
	}

	public WebElement getNewPasswordEdit() {
		return newPasswordEdit;
	}

	public WebElement getConfirmPasswordEdit() {
		return confirmPasswordEdit;
	}

	public WebElement getaddDoctorButton() {
		return addDoctorButton;
	}
	public void addDoctor(String Specialization, String Doctor, String ClinicAddress, String fees, String Contact, String Email,String NewPassword,String ConfirmPassword) {
		select(getDoctorspecializationDD(), Specialization);
		doctorNameEdit.sendKeys(Doctor);
		clinicAddressEdit.sendKeys(ClinicAddress);
		doctorFeesEdit.sendKeys(fees);
		doctorContactEdit.sendKeys(Contact);
		doctorEmailEdit.sendKeys(Email);
		newPasswordEdit.sendKeys(NewPassword);
		confirmPasswordEdit.sendKeys(ConfirmPassword);
		Point loc=addDoctorButton.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		addDoctorButton.click();
		switchToAlertAndAccept(driver);
	}
}
