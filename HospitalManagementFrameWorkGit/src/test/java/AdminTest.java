import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hospitalManagement.generic.basetest.BaseClass;
import com.hospitalManagement.generic.objectrepositoryutility.AddDoctorPage;
import com.hospitalManagement.generic.objectrepositoryutility.AdminPage;
import com.hospitalManagement.generic.objectrepositoryutility.AdminPatientSearchPage;
import com.hospitalManagement.generic.objectrepositoryutility.ManageDoctorPage;

public class AdminTest extends BaseClass{
	
	@Test
	public void AddDoctor() throws IOException {
		String Specialization=eLib.getDataFromExcel("doctor", 1, 0);
		String doctor=eLib.getDataFromExcel("doctor", 1, 1)+jLib.getRandomNumber();
		String clinicAddress=eLib.getDataFromExcel("doctor", 1, 2);
		String fees=eLib.getDataFromExcel("doctor", 1, 3);
		String Contact=eLib.getDataFromExcel("doctor", 1, 4)+jLib.getMobileNumber();
		String email=doctor+"@gmail.com";
		String newPassword=eLib.getDataFromExcel("doctor", 1, 5)+jLib.getRandomNumber();
		String confirmPassword=newPassword;
		AdminPage ap = new AdminPage(driver);
		ap.getDoctorsLink().click();
		ap.getAdddoctorLink().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.addDoctor(Specialization, doctor, clinicAddress, fees, Contact, email, newPassword, confirmPassword);
		ap.getDoctorsLink().click();
		ap.getManageDoctorsLink().click();
		ManageDoctorPage mdp = new ManageDoctorPage(driver);
		String actualdoctor = mdp.getDoctorNameEdit().getText();
		String actualspecialization = mdp.getSpecializationEdit().getText();
		boolean status1=actualdoctor.contains(doctor);
		boolean status2=actualspecialization.contains(Specialization);
		Assert.assertEquals(status1, true);
		Assert.assertEquals(status2, true);
	}
	
	@Test
	public void adminManagePatient() throws IOException {
		String name=eLib.getDataFromExcel("patientDetails", 1, 0);
		AdminPage ap = new AdminPage(driver);
		ap.getpatientsearchLink().click();
		AdminPatientSearchPage apsp = new AdminPatientSearchPage(driver);
		apsp.adminPatientSearch(name);
	}
}
