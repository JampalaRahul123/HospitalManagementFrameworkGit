package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hospitalManagement.generic.webdriverutility.WebDriverUtility;

public class BookAppointmentPage extends WebDriverUtility {
WebDriver driver;
	
	public BookAppointmentPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement doctorSpecializationDD;
	
	@FindBy(xpath = "//select[@name='doctor']")
	private WebElement doctorDD;
	
	@FindBy(xpath ="//select[@name='fees']")
	private WebElement feesDD;
	
	@FindBy(xpath ="//input[@name='appdate']")
	private WebElement dateText;
	
	@FindBy(xpath ="//input[@name='apptime']")
	private WebElement timeText;

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement bookAppointmentButton;
	
	@FindBy(xpath = "//button[contains(@class,'default')]")
	private WebElement settings;	
	
	public WebElement getDoctorSpecializationDD() {
		return doctorSpecializationDD;
	}

	public WebElement getDoctorDD() {
		return doctorDD;
	}

	public WebElement getFeesDD() {
		return feesDD;
	}

	public WebElement getDateText() {
		return dateText;
	}

	public WebElement getTimeText() {
		return timeText;
	}
	
	public WebElement getbookAppointmentButton() {
		return bookAppointmentButton;
	}

	public void bookappointment(String Specialization,String date,String time) {
		select(doctorSpecializationDD,Specialization);
		select(doctorDD,2);
		dateText.clear();
		dateText.sendKeys(date);
		settings.click();
		timeText.clear();
		timeText.sendKeys(time);
		settings.click();
		Point loc=bookAppointmentButton.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		bookAppointmentButton.click();
		switchToAlertAndAccept(driver);
	}
}
	
