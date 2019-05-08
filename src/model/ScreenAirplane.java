package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class ScreenAirplane {
	
	private Flight firstFlights;
	private String[] airlines;
	private FlightComparator flightComparator;
	private String[] destinationCities;
	private String[] prefixAirlines;
	
	public ScreenAirplane(int num) throws IOException {
		firstFlights = null;
		flightComparator = new FlightComparator();
		createFlight(num);
	}
	
	public Flight getfirFlights() {
		return firstFlights;
	}
	
	public String[] airlines() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("data/airline.txt"));
		
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			airlines = new String[parts.length];
			for(int i = 0; i<parts.length; i++) {
				String airline = parts[i];
				airlines[i] = airline;
			}
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return airlines;
	}
	
	public String[] destinationCities() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("data/city.txt"));
		
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			destinationCities = new String[parts.length];
			for(int i = 0; i<parts.length; i++) {
				String destination = parts[i];
				destinationCities[i] = destination;
			}
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return destinationCities;
	}
	
	public String[] prefixAirline() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("data/prefix.txt"));
		
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			prefixAirlines = new String[parts.length];
			for(int i = 0; i<parts.length; i++) {
				String prefix = parts[i];
				prefixAirlines[i] = prefix;
			}
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return prefixAirlines;
	}
	
	public void createFlight(int numFlight) throws IOException {
		for(int I = 0; I< numFlight; I++ ) {
			int month = (int)(Math.random()*11)+1;
			int day = (int)(Math.random()*29)+1;
			int year = 2019;
			LocalDate date= LocalDate.of(year, month, day);
			int hour = (int)(Math.random()*24);
			int minutes = (int)(Math.random()*60);
			LocalTime hour1 = LocalTime.of(hour, minutes);
			int posAirline = (int) (Math.random()*airlines().length-1);
			String airline = airlines()[posAirline];
			String numFlight1 = prefixAirline()[posAirline]+(int) (Math.random()*4000);
			int posCity = (int) (Math.random()*destinationCities().length-1);
			String destinationCity = destinationCities()[posCity];
			int boardingGate = (int) (Math.random()*30)+1;
			Flight flight = new Flight(date,hour1,airline,numFlight1,destinationCity,boardingGate);
			if(firstFlights == null) {
				firstFlights = flight;
			}else {
				Flight current = firstFlights;
				while(current.getNext() != null) {
					current = current.getNext();
					
				}
				current.setNext(flight);
				flight.setPrev(current);
			}
		}
	}
	
	public void sortByDateAndTime(){
		
	}
	
	/*
		for(int i = 0; i<nums.length-1; i++) {
			for(int j = 0; j<nums.length-i-1; j++) {
				if(nums[j]> nums[j+1]) {
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
	}
	
	
	public void sortByDate(){
		Arrays.sort(firstflights, flightComparator);
	}
	
	public void sortByHour(){
		for(int I = 0; I<firstflights.length; I++) {
			for(int J = 0; J<firstflights.length-I-1; J++) {
				if(flightComparator.compareByHour(firstflights[J],firstflights[J+1])> 0) {
					Flight temp = firstflights[J];
					firstflights[J] = firstflights[J+1];
					firstflights[J+1] = temp;
				}
			}
		}
	}
	
	public void sortByAirline(){
		for(int I = 1; I<firstflights.length; I++) {
			for(int J = I; (J>0) && (flightComparator.compareByAirline(firstflights[J-1],firstflights[J])> 0); J--) {
				Flight temp = firstflights[J];
				firstflights[J] = firstflights[J-1];
				firstflights[J-1] = temp;
			}
		}
	}

	public void sortByNumFlight(){
		for(int I = 0; I<firstflights.length-1; I++) {
			Flight flightLess = firstflights[I];
			int with = I;
			for(int J = I+1; J<firstflights.length; J++) {
				if(flightComparator.compareByNumFlight(firstflights[J],flightLess) < 0) {
					flightLess = firstflights[J];
					with = J;
				}
			}
			Flight temp = firstflights[I];
			firstflights[I] = flightLess;
			firstflights[with] = temp;
		}
	}
	
	public void sortByDestinationCity(){
		for(int I = 0; I<firstflights.length-1; I++) {
			Flight flightLess = firstflights[I];
			int with = I;
			for(int J = I+1; J<firstflights.length; J++) {
				if(flightComparator.compareByDestinationCity(firstflights[J],flightLess) < 0) {
					flightLess = firstflights[J];
					with = J;
				}
			}
			Flight temp = firstflights[I];
			firstflights[I] = flightLess;
			firstflights[with] = temp;
		}
	}
	
	public void sortByBoardingGate(){
		for(int I = 0; I<firstflights.length; I++) {
			for(int J = 0; J<firstflights.length-I-1; J++) {
				if(flightComparator.compareByBoardingGate(firstflights[J],firstflights[J+1])> 0) {
					Flight temp = firstflights[J];
					firstflights[J] = firstflights[J+1];
					firstflights[J+1] = temp;
				}
			}
		}
	}
	
	public Flight searchByDate(LocalDate date) {
		Flight flight = null;
		for(int I = 0; I<firstflights.length || firstflights[I].getDate().equals(date); I++) {
			if(firstflights[I].getDate().equals(date)) {
				flight = firstflights[I];
			}
		}
		return flight;
	}

	public Flight searchByHour(LocalTime hour) {
		Flight flight = null;
		Boolean found = false;
		for(int I = 0; I<firstflights.length && found == false; I++) {
			if(firstflights[I].getHour().equals(hour)) {
				flight = firstflights[I];
				found = true;
			}
		}
		return flight;
	}
	
	public Flight searchByAirline(String airline) {
		Flight flight = null;
		Boolean found = false;
		for(int I = 0; I<firstflights.length && found == false; I++) {
			if(firstflights[I].getAirline().equals(airline)) {
				flight = firstflights[I];
				found = true;
			}
		}
		return flight;
	}
	
	public Flight searchByNumFlight(String numFlight) {
		Flight flight = null;
		boolean find = false;
		int start = 0;
		int finish = firstflights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(firstflights[medium].getNumFlight().equals(numFlight)) {
				flight = firstflights[medium];
				find = true;
			}else if(firstflights[medium].getNumFlight().compareTo(numFlight)>0) {
				finish = medium-1;
			}else {
				start = medium+1;
			}
		}
		return flight;
	}
	
	public Flight searchByDestinationCity(String destinationCity) {
		Flight flight = null;
		boolean find = false;
		int start = 0;
		int finish = firstflights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(firstflights[medium].getDestinationCity().equals(destinationCity)) {
				flight = firstflights[medium];
				find = true;
			}else if(firstflights[medium].getDestinationCity().compareTo(destinationCity)>0) {
				finish = medium-1;
			}else {
				start = medium+1;
			}
		}
		return flight;
	}
	
	public Flight searchByBoardingGate(int boardingGate) {
		Flight flight = null;
		boolean find = false;
		int start = 0;
		int finish = firstflights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(firstflights[medium].getBoardingGate() == boardingGate)	 {
				flight = firstflights[medium];
				find = true;
			}else if(firstflights[medium].getBoardingGate()> boardingGate) {
				finish = medium-1;
			}else {
				start = medium+1;
			}
		}
		return flight;
	}
	*/
}


