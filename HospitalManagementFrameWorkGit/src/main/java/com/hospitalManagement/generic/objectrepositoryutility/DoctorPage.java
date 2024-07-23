package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorPage {
WebDriver driver;
	
	public DoctorPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement doctorDashboardLink;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patientsLink;
	
	@FindBy(xpath="//span[text()=' Add Patient']")
	private WebElement addPatientsLink;
	
	@FindBy(xpath="//span[text()=' Manage Patient ']")
	private WebElement managePatientsLink;
	
	@FindBy(xpath="//span[text()=' Search ']")
	private WebElement doctorPatientSearchLink;

	public WebElement getdoctorDashboardLink() {
		return doctorDashboardLink;
	}

	public WebElement getappointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getPatientsLink() {
		return patientsLink;
	}

	public WebElement getAddPatientsLink() {
		return addPatientsLink;
	}

	public WebElement getManagePatientsLink() {
		return managePatientsLink;
	}

	public WebElement getdoctorPatientSearchLink() {
		return doctorPatientSearchLink;
	}
}
