package com.capg.service;

import com.capg.dto.Hotel;

public interface HotelService {
	public void addHotel(Hotel hotel);

	public void showHotel();

	public void cheapestHotel();

	public void bestRatedHotel();
}
