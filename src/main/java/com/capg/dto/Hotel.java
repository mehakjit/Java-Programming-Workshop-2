package com.capg.dto;

public class Hotel {
	String name;
	int weekDayRate;
	int weekEndRate;
	int ratings;

	public Hotel(String name, int weekDayRate, int weekEndRate, int ratings) {
		this.name = name;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
		this.ratings = ratings;
	}

	public Hotel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeekDayRate() {
		return weekDayRate;
	}

	public void setWeekDayRate(int weekDayRate) {
		this.weekDayRate = weekDayRate;
	}

	public int getWeekEndRate() {
		return weekEndRate;
	}

	public void setWeekEndRate(int weekEndRate) {
		this.weekEndRate = weekEndRate;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Hotel Name=" + name + ", Weekday Rate=" + weekDayRate + ", Weekend Rate=" + weekEndRate + ", Ratings=" + ratings;
	}

	
}
