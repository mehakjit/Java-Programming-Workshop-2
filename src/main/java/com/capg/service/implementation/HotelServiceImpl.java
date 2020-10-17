package com.capg.service.implementation;

import com.capg.dto.Hotel;
import com.capg.service.HotelService;
import com.capg.service.Validate;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//import java.util.stream.IntStream;


public class HotelServiceImpl implements HotelService {
	List<Hotel> hotelList = new ArrayList<Hotel>();
	Validate validate = new Validation();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy");
	Scanner sc = new Scanner(System.in);
	static int minRate = 1000;
	static String HotelName = null;
	@Override
	public void addHotel(Hotel hotel) {
		hotelList.add(hotel);
	}

	public void showHotel() {
		hotelList.stream().forEach(hotel -> System.out.println(hotel));
	}

	Date validatedDate() {
		try {
			String date = sc.next();
			boolean valid = validate.validateDate(date);
			while (!valid) {
				System.out.println(
						"Invalid Date, Try Again Correct Date Format ddMMMyyyy and date should be in the year 2020");
				date = sc.next();
				valid = validate.validateDate(date);
			}
			Date dte = simpleDateFormat.parse(date);
			return dte;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	void getMinRate(Hotel hotel) {
		minRate = minRate < hotel.getRateForRegCoustomer() ? minRate : hotel.getRateForRegCoustomer();
	}
	
	@Override
	public void cheapestHotel() {
		System.out.println("Check In Date : ");
		Date inDate = validatedDate();
		System.out.println("Check Out Date : ");
		Date outDate = validatedDate();
		try {
			long difference_In_Time = outDate.getTime() - inDate.getTime();
			long noOfDays = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
			System.out.println("Total no. of Days : " + (noOfDays + 1));
			hotelList.stream().forEach(hotel -> getMinRate(hotel));
			hotelList.stream().filter(hotel -> hotel.getRateForRegCoustomer()==minRate)
					 .forEach(hotel -> System.out.println("The Hotel with minimum rate of Rs." + minRate + " is "+ hotel.getName()));
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
	}
}