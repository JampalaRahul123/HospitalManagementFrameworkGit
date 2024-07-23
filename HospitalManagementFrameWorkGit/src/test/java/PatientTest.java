import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hospitalManagement.generic.fileutility.ExcelUtility;
import com.hospitalManagement.generic.fileutility.FileUtility;
import com.hospitalManagement.generic.objectrepositoryutility.BookAppointmentPage;
import com.hospitalManagement.generic.objectrepositoryutility.HomePage;
import com.hospitalManagement.generic.objectrepositoryutility.LoginPage;
import com.hospitalManagement.generic.objectrepositoryutility.PatientPage;
import com.hospitalManagement.generic.webdriverutility.JavaUtility;

public class PatientTest {

	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	@Test
	public void AppointmentBook() throws IOException{
		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		String url = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String patientusername = System.getProperty("patientusername",fLib.getDataFromPropertiesFile("patientusername"));
		String patientpassword = System.getProperty("patientpassword",fLib.getDataFromPropertiesFile("patientpassword"));
		String Specialization=eLib.getDataFromExcel("doctor", 1, 0);
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
		hp.patientLogin(url);
		LoginPage lp = new LoginPage(driver);
		lp.patientloginToapp(patientusername, patientpassword);
		PatientPage pp = new PatientPage(driver);
		pp.getbookAppointmentLink().click();
		BookAppointmentPage bap = new BookAppointmentPage(driver);
		String date=jLib.getRequiredDateYYYYDDMM(30);
		String time=jLib.TimeGenerator();
		bap.bookappointment(Specialization, date, time);
		pp.getappointmentHistoryLink().click();
		String actualdateandtime=pp.getappointmentDateTimeField().getText();
		boolean status1=actualdateandtime.contains(date);
		Assert.assertEquals(status1, true);
		boolean status2=actualdateandtime.contains(time);
		Assert.assertEquals(status2, true);
		hp.logOut();
		driver.close();
	}
}
