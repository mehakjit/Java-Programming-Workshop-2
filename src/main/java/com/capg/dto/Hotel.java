package com.capg.dto;

public class Hotel {
	String name;
	int weekDayRate;
	int weekEndRate;

	public Hotel(String name, int weekDayRate, int weekEndRate) {
		this.name = name;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
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

	@Override
	public String toString() {
		return "Hotel Name=" + name + ", weekDayRate=" + weekDayRate + ", weekEndRate=" + weekEndRate ;
	}

	
}
