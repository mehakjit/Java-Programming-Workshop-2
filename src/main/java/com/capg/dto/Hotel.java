package com.capg.dto;

public class Hotel {
	String name;
	int weekDayRate;
	int weekEndRate;
	int ratings;
	int rewWeekDayRate;
	int rewWeekEndRate;

	public Hotel(String name, int weekDayRate, int weekEndRate, int ratings, int rewWeekDayRate, int rewWeekEndRate) {
		this.name = name;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
		this.ratings = ratings;
		this.rewWeekDayRate = rewWeekDayRate;
		this.rewWeekEndRate = rewWeekEndRate;
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

	public int getRewWeekDayRate() {
		return rewWeekDayRate;
	}

	public void setRewWeekDayRate(int rewWeekDayRate) {
		this.rewWeekDayRate = rewWeekDayRate;
	}

	public int getRewWeekEndRate() {
		return rewWeekEndRate;
	}

	public void setRewWeekEndRate(int rewWeekEndRate) {
		this.rewWeekEndRate = rewWeekEndRate;
	}

	@Override
	public String toString() {
		return "Hotel Name=" + name + ", Weekday Rate=" + weekDayRate + ", Weekend Rate=" + weekEndRate + ", Ratings="
				+ ratings  + " For loyalty customers , Weekday Rate=" + weekDayRate + ", Weekend Rate=" + weekEndRate;
	}

}
