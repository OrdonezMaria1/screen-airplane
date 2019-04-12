package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScreenAirplane {
	
	private List<Flight> flights;
	
	public ScreenAirplane(){
		this.flights = new ArrayList<Flight>();
	}
	
	public void createFlight(int numFlight) {
		for(int i = 0; i<= numFlight; i++ ) {
			int day = (int) (Math.random()*29)+1;
			int month = (int) (Math.random()*11);
			int year = 2019;
			LocalDate date= LocalDate.of(year, month, day);
			int hour = (int)(Math.random()*24);
			int minutes = (int)(Math.random()*60);
			LocalTime hour1 = LocalTime.of(hour, minutes);
			String[] airlines = {"American Airlines","Aerolínea de Antioquia","EasyFly","VivaColombia","Avianca","Copa Airlines Colombia","Avianca Cargo", "Satena", "LATAM Airlines Colombia"};
			int posAirline = (int) (Math.random()*airlines.length);
			String airline = airlines[posAirline];
			String[] cities = {"Bogotá","Medellin","Cali","Pereira","Barranquilla","Cartagena","Cucuta","Armenia","Yopal"};
			int posCity = (int) (Math.random()*cities.length);
			String destinationCity = cities[posCity];
			int boardingGate = (int) (Math.random()*30)+1;
			Flight flight = new Flight(date,hour1,airline,destinationCity,boardingGate);
			flights.add(flight);
		}
	}
	
}
