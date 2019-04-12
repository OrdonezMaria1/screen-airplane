package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private LocalDate date;
	private LocalTime hour;
	private String airline;
	private String destinationCity;
	private int boardingGate;
	
	public Flight(LocalDate date, LocalTime hour, String airline, String destinationCity, int boardingGate) {
		this.date = date; 
		this.hour = hour;
		this.airline = airline;
		this.destinationCity = destinationCity;
		this.boardingGate = boardingGate;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getHour() {
		return hour;
	}
	
	public String getAirline() {
		return airline;
	}
	
	public String getDestinationCity() {
		return destinationCity;
	}
	
	public int getBoardingGate(){
		return boardingGate;
	}
	
	
}
