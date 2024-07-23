package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class LoginPage{ 
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath="//input[contains(@type,'text')]")
	private WebElement usernameEdit;
	
	@FindBy(xpath="//input[contains(@type,'password')]")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement loginBtn;
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void adminloginToapp(String adminusername, String adminpassword) {
		usernameEdit.sendKeys(adminusername);
		passwordEdit.sendKeys(adminpassword);
		loginBtn.click();
	}
	public void doctorloginToapp(String doctorusername, String doctorpassword) {
		usernameEdit.sendKeys(doctorusername);
		passwordEdit.sendKeys(doctorpassword);
		loginBtn.click();
	}
	public void patientloginToapp(String patientusername, String patientpassword) {
		usernameEdit.sendKeys(patientusername);
		passwordEdit.sendKeys(patientpassword);
		loginBtn.click();
	}
}
