package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
WebDriver driver;
	
	public AdminPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()=' Dashboard ']")
	private WebElement admindashboardLink;
	
	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement admindoctorsLink; 
	
	@FindBy(xpath="//span[text()=' Doctor Specialization ']")
	private WebElement doctorSpecializationLink;
	
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement adddoctorLink;
	
	@FindBy(xpath="//span[text()=' Manage Doctors ']")
	private WebElement manageDoctorsLink;
	
	@FindBy(xpath="//span[text()=' Users ']")
	private WebElement usersLink;
	
	@FindBy(xpath="//span[text()=' Manage Users ']")
	private WebElement manageusersLink;
	
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patientsLink;
	
	@FindBy(xpath="//span[text()=' Manage Patients ']")
	private WebElement managepatientsLink;

	@FindBy(xpath="//span[text()=' Patient Search ']")
	private WebElement patientsearchLink;
	
	public WebElement getDoctorsLink() {
		return admindoctorsLink;
	}

	public WebElement getDoctorSpecializationLink() {
		return doctorSpecializationLink;
	}

	public WebElement getAdddoctorLink() {
		return adddoctorLink;
	}

	public WebElement getManageDoctorsLink() {
		return manageDoctorsLink;
	}

	public WebElement getDashboardLink() {
		return admindashboardLink;
	}

	public WebElement getUsersLink() {
		return usersLink;
	}

	public WebElement getManageusersLink() {
		return manageusersLink;
	}

	public WebElement getPatientsLink() {
		return patientsLink;
	}

	public WebElement getManagepatientsLink() {
		return managepatientsLink;
	}
	
	public WebElement getpatientsearchLink() {
		return patientsearchLink;
	}
}
