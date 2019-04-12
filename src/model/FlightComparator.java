package model;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight>{
	
	@Override
	public int compare(Flight one, Flight two) {
		int comparation;
		
		String DateOne = ""+one.getDate();
		String DateTwo = ""+two.getDate();
		if(DateOne.compareTo(DateTwo) > 0) {
			comparation = 1;
		}else if(DateOne.compareTo(DateTwo) < 0) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
	
	public int compareByHour(Flight one, Flight two) {
		int comparation;
		
		String HourOne = ""+one.getHour();
		String HourTwo = ""+two.getHour();
		if(HourOne.compareTo(HourTwo) > 0) {
			comparation = 1;
		}else if(HourOne.compareTo(HourTwo) < 0) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
	
	public int compareByAirline(Flight one, Flight two) {
		int comparation;
		
		if(one.getAirline().compareToIgnoreCase(two.getAirline())>0){
			comparation = 1;
		}else if(one.getAirline().compareToIgnoreCase(two.getAirline())<0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
	public int compareByNumFlight(Flight one, Flight two) {
		int comparation;
		
		if(one.getNumFlight().compareTo(two.getNumFlight())>0) {
			comparation = 1;
		}else if(one.getNumFlight().compareTo(two.getNumFlight())<0) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
	
	public int compareByDestinationCity(Flight one, Flight two) {
		int comparation;
		
		if(one.getDestinationCity().compareToIgnoreCase(two.getDestinationCity())>0){
			comparation = 1;
		}else if(one.getDestinationCity().compareToIgnoreCase(two.getDestinationCity())<0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
	public int compareByBoardingGate(Flight one, Flight two) {
		int comparation;
		
		if(one.getBoardingGate()>two.getBoardingGate()) {
			comparation = 1;
		}else if(one.getBoardingGate()<two.getBoardingGate()) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
}