package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {
	WebDriver driver;
	
	public PatientPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement patientDashboardLink;
	
	@FindBy(xpath="//span[text()=' Book Appointment ']")
	private WebElement bookAppointmentLink;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath="//span[text()=' Medical History ']")
	private WebElement medicalHistoryLink;
	
	@FindBy(xpath="//tr[last()]/child::td[last()-3]")
	private WebElement appointmentDateTimeField;
	
	public WebElement getpatientDashboardLink() {
		return patientDashboardLink;
	}
	public WebElement getbookAppointmentLink() {
		return bookAppointmentLink;
	}

	public WebElement getappointmentHistoryLink() {
		return appointmentHistoryLink;
	}
	public WebElement getmedicalHistoryLink() {
		return medicalHistoryLink;
	}
	public WebElement getappointmentDateTimeField() {
		return appointmentDateTimeField;
	}
}