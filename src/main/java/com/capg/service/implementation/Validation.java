package com.capg.service.implementation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.service.Validate;

public class Validation implements Validate {
	
	private final String DATE = "^(0?[1-9]|[12][0-9]|3[01])[A-Z][A-z,a-z]{2}202[0-1]$";
	private final String HOTEL_NAME = "^[A-Z][a-z,A-z]{2,}";
	

	private boolean validate(String string, String field) {
		boolean matched = false;
		Pattern pattern = Pattern.compile(field);
		Matcher matcher = pattern.matcher(string);
		matched = matcher.find();
		return matched;
	}

	@Override
	public boolean validateDate(String date) {
		return validate(date, DATE);
	}

	@Override
	public boolean validateHotelName(String hotelName) {
		return validate(hotelName, HOTEL_NAME);
	}

}
