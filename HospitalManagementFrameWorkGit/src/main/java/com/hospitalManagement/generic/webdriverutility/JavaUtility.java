package com.hospitalManagement.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	public long getMobileNumber() {
		Random random = new Random();
		long mobileNumber=random.nextLong(1234567890);
		return mobileNumber;
	}
	public String TimeGenerator() {
		LocalTime currentTime = LocalTime.now();
		LocalTime futureTime=currentTime.plusHours(24);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		String futureTimeFormat = futureTime.format(formatter);
		return futureTimeFormat;
	}
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
	public String getRequiredDateYYYYDDMM(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		cal.setTime(dateObj);
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
