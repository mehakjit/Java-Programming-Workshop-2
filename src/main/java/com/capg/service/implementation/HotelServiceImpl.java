package com.capg.service.implementation;

import com.capg.dto.Hotel;
import com.capg.service.HotelService;

import java.util.ArrayList;
import java.util.List;


public class HotelServiceImpl implements HotelService{
	List<Hotel> hotelList = new ArrayList<Hotel>();
	
	@Override
	public void addHotel(Hotel hotel) {
		hotelList.add(hotel);
	}

	public void showHotel() {
		hotelList.stream().forEach(hotel -> System.out.println(hotel));
	}
	
}