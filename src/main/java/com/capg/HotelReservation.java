package com.capg;

import com.capg.dto.Hotel;
import com.capg.service.HotelService;
import com.capg.service.implementation.HotelServiceImpl;

public class HotelReservation {
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");
		Hotel lakewoodHotel = new Hotel("Lakewood", 110);
		Hotel bridgewoodHotel = new Hotel("Bridgewood", 160);
		Hotel ridgewoodHotel = new Hotel("Ridgewood", 220);
		HotelService hotelService = new HotelServiceImpl();
		hotelService.addHotel(lakewoodHotel);
		hotelService.addHotel(bridgewoodHotel);
		hotelService.addHotel(ridgewoodHotel);
		hotelService.showHotel();
	}
}
