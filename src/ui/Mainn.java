package ui;

import java.io.IOException;

import model.ScreenAirplane;

public class Mainn {
	
	private static ScreenAirplane sA;
	public static void main(String[] args) throws IOException {
		sA = new ScreenAirplane(5);
		System.out.println(""+sA.toString());
		System.out.println("---------------");
		sA.sortByDateAndTime();
		System.out.println(""+sA.toString());
	}
}
