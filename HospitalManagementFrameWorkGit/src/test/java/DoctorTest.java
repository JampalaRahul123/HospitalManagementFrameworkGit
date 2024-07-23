import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hospitalManagement.generic.fileutility.ExcelUtility;
import com.hospitalManagement.generic.fileutility.FileUtility;
import com.hospitalManagement.generic.objectrepositoryutility.AddPatientPage;
import com.hospitalManagement.generic.objectrepositoryutility.DoctorPage;
import com.hospitalManagement.generic.objectrepositoryutility.DoctorPatientSearchPage;
import com.hospitalManagement.generic.objectrepositoryutility.HomePage;
import com.hospitalManagement.generic.objectrepositoryutility.LoginPage;
import com.hospitalManagement.generic.objectrepositoryutility.ManagePatientPage;
import com.hospitalManagement.generic.webdriverutility.JavaUtility;

public class DoctorTest {

	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	@Test
	public void AddMalePatient() throws IOException {
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		String url = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String doctorusername = System.getProperty("doctorusername",fLib.getDataFromPropertiesFile("doctorusername"));
		String doctorpassword = System.getProperty("doctorpassword",fLib.getDataFromPropertiesFile("doctorpassword"));
		String Name=eLib.getDataFromExcel("patient",1,0)+jLib.getRandomNumber();
		String Contact=eLib.getDataFromExcel("patient", 1, 1)+jLib.getMobileNumber();
		String Email=Name+"@gmail.com";
		String Address=eLib.getDataFromExcel("patient", 1, 2);
		String Age=eLib.getDataFromExcel("patient", 1, 3);
		String ms=eLib.getDataFromExcel("patient", 1, 4);
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		HomePage hp = new HomePage(driver);
		hp.doctorLogin(url);
		LoginPage lp = new LoginPage(driver);
		lp.doctorloginToapp(doctorusername, doctorpassword);
		DoctorPage dp = new DoctorPage(driver);
		dp.getPatientsLink().click();
		dp.getAddPatientsLink().click();
		AddPatientPage app = new AddPatientPage(driver);
		app.addMalePatient(Name, Contact, Email, Address, Age, ms);
		dp.getPatientsLink().click();
		dp.getManagePatientsLink().click();
		ManagePatientPage mpp = new ManagePatientPage(driver);
		String actualPatient=mpp.getPatientNameEdit().getText();
		boolean status1=actualPatient.contains(Name);
		Assert.assertEquals(status1, true);
		hp.logOut();
		driver.close();
	}
	@Test
	public void AddFemalePatient() throws IOException {
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		String url = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String doctorusername = System.getProperty("doctorusername",fLib.getDataFromPropertiesFile("doctorusername"));
		String doctorpassword = System.getProperty("doctorpassword",fLib.getDataFromPropertiesFile("doctorpassword"));
		String Name=eLib.getDataFromExcel("patient",2,0)+jLib.getRandomNumber();
		String Contact=eLib.getDataFromExcel("patient", 2, 1)+jLib.getMobileNumber();
		String Email=Name+"@gmail.com";
		String Address=eLib.getDataFromExcel("patient", 2, 2);
		String Age=eLib.getDataFromExcel("patient", 2, 3);
		String ms=eLib.getDataFromExcel("patient", 2, 4);
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		HomePage hp = new HomePage(driver);
		hp.doctorLogin(url);
		LoginPage lp = new LoginPage(driver);
		lp.doctorloginToapp(doctorusername, doctorpassword);
		DoctorPage dp = new DoctorPage(driver);
		dp.getPatientsLink().click();
		dp.getAddPatientsLink().click();
		AddPatientPage app = new AddPatientPage(driver);
		app.addFemalePatient(Name, Contact, Email, Address, Age, ms);
		dp.getPatientsLink().click();
		dp.getManagePatientsLink().click();
		ManagePatientPage mpp = new ManagePatientPage(driver);
		String actualPatient=mpp.getPatientNameEdit().getText();
		boolean status1=actualPatient.contains(Name);
		Assert.assertEquals(status1, true);
		hp.logOut();
		driver.close();
	}
	@Test
	public void doctorManagePatient() throws IOException {
	String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
	String url = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
	String doctorusername = System.getProperty("doctorusername",fLib.getDataFromPropertiesFile("doctorusername"));
	String doctorpassword = System.getProperty("doctorpassword",fLib.getDataFromPropertiesFile("doctorpassword"));
	String name=eLib.getDataFromExcel("patientDetails", 2, 0);
	WebDriver driver = null;
	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	} else if (BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	} else {
		driver = new ChromeDriver();
	}
	HomePage hp = new HomePage(driver);
	hp.doctorLogin(url);
	LoginPage lp = new LoginPage(driver);
	lp.doctorloginToapp(doctorusername, doctorpassword);
	DoctorPage dp = new DoctorPage(driver);
	dp.getdoctorPatientSearchLink().click();
	DoctorPatientSearchPage dpsp = new DoctorPatientSearchPage(driver);
	dpsp.doctorPatientSearch(name);
	hp.logOut();
	driver.close();
	}
	}
