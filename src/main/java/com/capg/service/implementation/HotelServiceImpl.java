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

public class HotelServiceImpl implements HotelService {
	List<Hotel> hotelList = new ArrayList<Hotel>();
	Validate validate = new Validation();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy");
	Scanner sc = new Scanner(System.in);
	static int No_of_days;
	static int weekendDays;
	static int minRate;

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
		minRate = minRate < expenditure(hotel) ? minRate : expenditure(hotel);
	}

	int expenditure(Hotel hotel) {
		int price = hotel.getWeekDayRate() * (No_of_days - weekendDays) + hotel.getWeekEndRate() * weekendDays;
		return price;
	}
	
	void setDatesDaysAndwwekDays() {
		No_of_days = 0;
		weekendDays = 0;
		minRate = 1000;
		System.out.println("Check In Date : ");
		Date inDate = validatedDate();
		System.out.println("Check Out Date : ");
		Date outDate = validatedDate();
		try {
			long difference_In_Time = outDate.getTime() - inDate.getTime();
			No_of_days = ((int) ((difference_In_Time / (1000 * 60 * 60 * 24)) % 365) + 1);
			int day = inDate.getDay();
			int tempDay = day;
			for (int i = 0; i < No_of_days; i++) {
				if (tempDay == 0 || tempDay == 6) {
					weekendDays++;
				}
				tempDay = (tempDay + 1) % 7;
			}
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cheapestHotel() {
			setDatesDaysAndwwekDays();
			hotelList.stream().forEach(hotel -> getMinRate(hotel));
			Integer rating = hotelList.stream().filter(hotel -> expenditure(hotel) == minRate)
					.map(e -> e.getRatings()).max(Integer::compare).get();
			hotelList.stream().filter(hotel -> expenditure(hotel)== minRate).filter(hotel -> hotel.getRatings()==rating)
					.forEach(i -> System.out.println(i.getName()+ ", Rating : " + i.getRatings() + " and Total Rates: $" + minRate)); 
		} 

	@Override
	public void bestRatedHotel() {
		setDatesDaysAndwwekDays();
		Integer rating = hotelList.stream().map(e -> e.getRatings()).max(Integer::compare).get();
		hotelList.stream().filter(hotel -> hotel.getRatings()==rating).forEach(i->System.out.println(i.getName()+" and Total Rates $"+expenditure(i)));
	}
}