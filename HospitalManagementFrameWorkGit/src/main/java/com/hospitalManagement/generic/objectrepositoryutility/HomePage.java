package com.hospitalManagement.generic.objectrepositoryutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hospitalManagement.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'admin')]")
	private WebElement adminLink;

	@FindBy(xpath = "//a[contains(@href,'doctor')]")
	private WebElement doctorsLink;

	@FindBy(xpath = "//a[contains(@href,'user')]")
	private WebElement patientsLink;

	@FindBy(xpath = "(//a[contains(@href,'contact')])[last()-1]")
	private WebElement contactLink;

	@FindBy(xpath = "//img[contains(@src,'assets')]")
	private WebElement profileImg;

	@FindBy(linkText = "Log Out")
	private WebElement logOutLink;


	public WebElement getcontactLink() {
		return contactLink;
	}

	public void adminLogin(String URL) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		Point loc=adminLink.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		adminLink.click();
		}
	
	public void doctorLogin(String URL) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		Point loc=doctorsLink.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		doctorsLink.click();
		}
	
	public void patientLogin(String URL) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		Point loc=patientsLink.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		patientsLink.click();
		}
	
	public void logOut() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",profileImg);
		logOutLink.click();
	}
}
