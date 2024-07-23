package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDoctorPage {
WebDriver driver;
	
	public ManageDoctorPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//tr[last()]/child::td[last()-2]")
	private WebElement doctorNameEdit;
	
	@FindBy(xpath="//tr[last()]/child::td[last()-3]")
	private WebElement specializationEdit;

	public WebElement getDoctorNameEdit() {
		return doctorNameEdit;
	}

	public WebElement getSpecializationEdit() {
		return specializationEdit;
	}

}
