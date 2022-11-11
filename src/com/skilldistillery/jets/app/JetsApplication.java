package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();
	}

	Scanner sc = new Scanner(System.in);

	private int displayMenu() {
		System.out.println("Select a menu option");
		System.out.println("1 - List fleet");
		System.out.println("2 - Fly all jets");
		System.out.println("3 - View fastest jet");
		System.out.println("4 - View jet with longest range");
		System.out.println("5 - Load all Passenger Jets");
		System.out.println("6 - DOGFIGHT!");
		System.out.println("7 - Add a jet to the fleet");
		System.out.println("8 - Remove a jet from the fleet");
		System.out.println("9 - Quit Program");

		int menuSelection;

		menuSelection = sc.nextInt();
		return menuSelection;
	}

	private void run() {
		Airfield airfield = new Airfield();
		airfield.populateAirfield();

		int selection;
		do {
			selection = displayMenu();
			airfield.executeSelectedItem(selection);
		} while (selection != 9);
	}
}
