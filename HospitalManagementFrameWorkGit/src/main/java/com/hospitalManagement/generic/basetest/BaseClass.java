package com.hospitalManagement.generic.basetest;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hospitalManagement.generic.databaseutility.*;
import com.hospitalManagement.generic.fileutility.*;
import com.hospitalManagement.generic.objectrepositoryutility.*;
import com.hospitalManagement.generic.webdriverutility.JavaUtility;

public class BaseClass {
	/*Create Object */
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public WebDriver driver = null;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB, Report Config===");
		dbLib.getDbconnection();
		}
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("===launch browser===");
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		// Run-time Polymorphism.In order to achieve run-time polymorphism, we need to follow three rules.
		// They are : 1.Up casting, 2. Inheritance 3. overriding
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("=login=");
		String url = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		HomePage hp = new HomePage(driver);
		hp.adminLogin(url);
		LoginPage lp = new LoginPage(driver);
		String adminusername = fLib.getDataFromPropertiesFile("adminusername");
		String adminpassword = fLib.getDataFromPropertiesFile("adminpassword");
		lp.adminloginToapp(adminusername, adminpassword);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("=logout=");
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}

	@AfterClass
	public void configAC() {
		System.out.println("===close the browser===");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close Db, Report backup===");
		dbLib.closeDbConnection();
	}
}
