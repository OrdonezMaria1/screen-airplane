package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Flight implements Comparable<Flight>{
	private LocalDate date;
	private LocalTime hour;
	private String airline;
	private String numFlight;
	private String destinationCity;
	private int boardingGate;
	private Flight next;
	private Flight prev;
	
	public Flight(LocalDate date, LocalTime hour, String airline,String numFlight, String destinationCity, int boardingGate) {
		this.date = date; 
		this.hour = hour;
		this.airline = airline;
		this.numFlight = numFlight;
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
	
	public String getNumFlight() {
		return numFlight;
	}
	
	public String getDestinationCity() {
		return destinationCity;
	}
	
	public int getBoardingGate(){
		return boardingGate;
	}
	
	@Override
	public int compareTo(Flight other) {
		int comparation ;
		String TimeOne = ""+date+""+hour;
		String TimeTwo = ""+other.date+""+other.hour;
		if(TimeOne.compareTo(TimeTwo) > 0) {
			comparation = 1;
		}else if(TimeOne.compareTo(TimeTwo) < 0) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
	
	public String toString() {
		String time = hour.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
		return ""+date+"	"+time+"	"+airline+"	"+numFlight+"	"+destinationCity+"	"+boardingGate;
	}

	public Flight getNext() {
		return next;
	}

	public void setNext(Flight next) {
		this.next = next;
	}

	public Flight getPrev() {
		return prev;
	}

	public void setPrev(Flight prev) {
		this.prev = prev;
	}
}
