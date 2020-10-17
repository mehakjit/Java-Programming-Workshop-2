package com.capg;

import java.util.Scanner;

import com.capg.dto.Hotel;
import com.capg.service.HotelService;
import com.capg.service.Validate;
import com.capg.service.implementation.HotelServiceImpl;
import com.capg.service.implementation.Validation;


public class HotelReservation {
	static Hotel lakewoodHotel = new Hotel("Lakewood", 110);
	static Hotel bridgewoodHotel = new Hotel("Bridgewood", 160);
	static Hotel ridgewoodHotel = new Hotel("Ridgewood", 220);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");
		HotelService hotelService = new HotelServiceImpl();
		Validate validate = new Validation();
		Scanner sc = new Scanner(System.in);
		hotelService.addHotel(lakewoodHotel);
		hotelService.addHotel(bridgewoodHotel);
		hotelService.addHotel(ridgewoodHotel);
		hotelService.showHotel();
		int options = 1;
		while(options!=0) {
			System.out.println("\nPress 1 to add another Hotel with their custom rate. \n" +
							   "Press 2 to find the cheapest Hotel from given List. \n" +
							   "Press 0 to Exit");
			options = sc.nextInt();
			switch(options) {
			case 0:
				System.out.println("Exit.");
				break;
			case 1:
				System.out.println("Enter the name of the hotel");
				String hotelName = sc.next();
				boolean valid = validate.validateHotelName(hotelName);
				while (!valid) {
					System.out.println("Invalid Name, Try Again Correct Name starts with capital letter and should have minimum of 3 Alphabets");
					hotelName = sc.next();
					valid = validate.validateHotelName(hotelName);
				}
				System.out.println("Enter the amount for regular customers");
				int regCoustmerRate = sc.nextInt();
				System.out.println("Successfull Entry");
				Hotel hotel = new Hotel(hotelName, regCoustmerRate);
				hotelService.addHotel(hotel);
				hotelService.showHotel();
				break;
			case 2:
				System.out.println(
						"\nPlease enter the duration of your stay in format ddMMMyyyy to find the cheapest stay rate in the above mentioned hotels");
				hotelService.cheapestHotel();
				break;
			default:
				System.out.println("Wrong input, Try Agin");
				break;
			}
		}
	}
}
