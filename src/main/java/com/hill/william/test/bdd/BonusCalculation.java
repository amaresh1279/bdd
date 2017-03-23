package com.hill.william.test.bdd;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BonusCalculation {

	private String calculatedDay;

	public String calculateDay(String day) throws ParseException {
		//System.out.println("Day is :" + day);
		// this.day = 15;
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		int iYear = Calendar.getInstance().get(Calendar.YEAR);
		int iMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String yourDate = 15 + "/" + iMonth + "/" + iYear;
		// String string = yourDate;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date date = format.parse(yourDate);
		this.calculatedDay = simpleDateformat.format(date);
		//System.out.println("Calculated Day :: " + this.calculatedDay);
		return calculatedDay;
	}

	public String get15thDay() {
		return calculatedDay;
	}
	
	public String calculateHoliday(){
		return "holiday";
	}

}
