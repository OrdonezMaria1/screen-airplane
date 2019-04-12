package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class ScreenAirplane {
	
	private Flight[] flights;
	private String[] airlines;
	private FlightComparator flightComparator;
	private String[] destinationCities;
	private String[] prefixAirlines;
	
	public ScreenAirplane(int num) throws IOException {
		flights = new Flight[num];
		flightComparator = new FlightComparator();
	}
	
	public Flight[] getFlights() {
		return flights;
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
			flights[I] = flight;
		}
	}
	
	public void sortByDateAndTime(){
		Arrays.sort(flights);
	}
	
	public void sortByDate(){
		Arrays.sort(flights, flightComparator);
	}
	
	public void sortByHour(){
		for(int I = 0; I<flights.length; I++) {
			for(int J = 0; J<flights.length-I-1; J++) {
				if(flightComparator.compareByHour(flights[J],flights[J+1])> 0) {
					Flight temp = flights[J];
					flights[J] = flights[J+1];
					flights[J+1] = temp;
				}
			}
		}
	}
	
	public void sortByAirline(){
		for(int I = 1; I<flights.length; I++) {
			for(int J = I; (J>0) && (flightComparator.compareByAirline(flights[J-1],flights[J])> 0); J--) {
				Flight temp = flights[J];
				flights[J] = flights[J-1];
				flights[J-1] = temp;
			}
		}
	}

	public void sortByNumFlight(){
		for(int I = 0; I<flights.length-1; I++) {
			Flight flightLess = flights[I];
			int with = I;
			for(int J = I+1; J<flights.length; J++) {
				if(flightComparator.compareByNumFlight(flights[J],flightLess) < 0) {
					flightLess = flights[J];
					with = J;
				}
			}
			Flight temp = flights[I];
			flights[I] = flightLess;
			flights[with] = temp;
		}
	}
	
	public void sortByDestinationCity(){
		for(int I = 0; I<flights.length-1; I++) {
			Flight flightLess = flights[I];
			int with = I;
			for(int J = I+1; J<flights.length; J++) {
				if(flightComparator.compareByDestinationCity(flights[J],flightLess) < 0) {
					flightLess = flights[J];
					with = J;
				}
			}
			Flight temp = flights[I];
			flights[I] = flightLess;
			flights[with] = temp;
		}
	}
	
	public void sortByBoardingGate(){
		for(int I = 0; I<flights.length; I++) {
			for(int J = 0; J<flights.length-I-1; J++) {
				if(flightComparator.compareByBoardingGate(flights[J],flights[J+1])> 0) {
					Flight temp = flights[J];
					flights[J] = flights[J+1];
					flights[J+1] = temp;
				}
			}
		}
	}
	
	public Flight searchByDate(LocalDate date) {
		Flight flight = null;
		for(int I = 0; I<flights.length || flights[I].getDate().equals(date); I++) {
			if(flights[I].getDate().equals(date)) {
				flight = flights[I];
			}
		}
		return flight;
	}

	public Flight searchByHour(LocalTime hour) {
		Flight flight = null;
		Boolean found = false;
		for(int I = 0; I<flights.length && found == false; I++) {
			if(flights[I].getHour().equals(hour)) {
				flight = flights[I];
				found = true;
			}
		}
		return flight;
	}
	
	public Flight searchByAirline(String airline) {
		Flight flight = null;
		Boolean found = false;
		for(int I = 0; I<flights.length && found == false; I++) {
			if(flights[I].getAirline().equals(airline)) {
				flight = flights[I];
				found = true;
			}
		}
		return flight;
	}
	
	public Flight searchByNumFlight(String numFlight) {
		Flight flight = null;
		boolean find = false;
		int start = 0;
		int finish = flights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(flights[medium].getNumFlight().equals(numFlight)) {
				flight = flights[medium];
				find = true;
			}else if(flights[medium].getNumFlight().compareTo(numFlight)>0) {
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
		int finish = flights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(flights[medium].getDestinationCity().equals(destinationCity)) {
				flight = flights[medium];
				find = true;
			}else if(flights[medium].getDestinationCity().compareTo(destinationCity)>0) {
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
		int finish = flights.length-1;
		while(start <= finish && !find ) {
			int medium =(start+finish)/2;
			if(flights[medium].getBoardingGate() == boardingGate)	 {
				flight = flights[medium];
				find = true;
			}else if(flights[medium].getBoardingGate()> boardingGate) {
				finish = medium-1;
			}else {
				start = medium+1;
			}
		}
		return flight;
	}
}


