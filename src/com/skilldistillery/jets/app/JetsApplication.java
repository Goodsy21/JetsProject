package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApplication {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();
	}

	private void run() {

		Airfield fleet = new Airfield();
		populateAirfield(fleet);

		int selection;
		do {
			selection = displayMenu();

			executeSelectedItem(selection, fleet);
		} while (selection != 9);

	}

	private void populateAirfield(Airfield fleet) {

		ArrayList<Jet> fleetList = new ArrayList<Jet>();
		try (BufferedReader br = new BufferedReader(new FileReader("./Jets.txt"))) {

			String delimiter = ",";
			String line;
			while ((line = br.readLine()) != null) {
				String[] attributes = line.split(delimiter);

				Jet jetFromFile = new JetImpl();
				jetFromFile.setType(attributes[0]);
				jetFromFile.setModel(attributes[1]);
				jetFromFile.setMaxMPH(Double.parseDouble(attributes[2]));
				jetFromFile.setRange(Double.parseDouble(attributes[3]));
				jetFromFile.setPrice(Double.parseDouble(attributes[4]));

				fleetList.add(jetFromFile);
				System.out.println();
			}
			fleet.setFleet(fleetList);
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	private void executeSelectedItem(int menuSelection, Airfield fleet) {
		switch (menuSelection) {
		case 1:
			printFleet(fleet);
			break;
		case 2:
			flyFleet(fleet);
			break;
		case 3:
			findAndPrintFastestJet(fleet);
			break;
		case 4:
			findAndPrintLongestRange(fleet);
			break;
		case 5:
			loadPassengers(fleet);
			break;
		case 6: 
			dogfight(fleet);
			break;
		case 7:
			addJet(fleet);
			break;
		case 8:
			removeJet(fleet);
			break;
		case 9:
			System.out.println("Safe travels");
			break;

		default:
			System.out.println("Invalid entry, select a number from 1-9");
			break;
		}

	}

	private void dogfight(Airfield fleet) {
		for (int i = 0; i < fleet.getFleet().size(); i++) {
			if (fleet.getFleet().get(i).getType().equalsIgnoreCase("Fighter")) {
				System.out.println(fleet.getFleet().get(i).getModel() + " be fightin'");
			}
		}
	}

	private void removeJet(Airfield fleet) {
		System.out.println("Please enter the number you'd like to remove.");
		for (int i = 0; i < fleet.getFleet().size(); i++) {
			System.out.println("["+ i +"] - " + fleet.getFleet().get(i).toString());
		}
		fleet.getFleet().remove(sc.nextInt());
	}

	private void addJet(Airfield fleet) {
		System.out.println("What type of plane would you like to add?");
		String addedJetType = sc.next();
		System.out.println("What is the model?");
		String addedJetModel = sc.next();
		System.out.println("What is the top speed in MPH?");
		Double addedJetMPH = sc.nextDouble();
		System.out.println("What is the flying range in miles?");
		Double addedJetRange = sc.nextDouble();
		System.out.println("How much does that plane cost?");
		Double addedJetPrice = sc.nextDouble();

		Jet addedJet = new JetImpl();
		addedJet.setType(addedJetType);
		addedJet.setModel(addedJetModel);
		addedJet.setMaxMPH(addedJetMPH);
		addedJet.setRange(addedJetRange);
		addedJet.setPrice(addedJetPrice);

		fleet.getFleet().add(addedJet);

	}

	private void loadPassengers(Airfield fleet) {
		for (int i = 0; i < fleet.getFleet().size(); i++) {
			if (fleet.getFleet().get(i).getType().equalsIgnoreCase("Passenger")) {
				System.out.println(fleet.getFleet().get(i).getModel() + " is loading passengers");
			}
		}
	}

	private void findAndPrintLongestRange(Airfield fleet) {
		Jet longestJet = new JetImpl();
		longestJet.setRange(0.0);
		for (int i = 0; i < fleet.getFleet().size(); i++) {
			if (longestJet.getRange() < fleet.getFleet().get(i).getRange()) {
				longestJet = fleet.getFleet().get(i);
			}
		}
		System.out.println("The jet with the longest range in the fleet is: " + longestJet.getModel());

	}

	private void findAndPrintFastestJet(Airfield fleet) {
		Jet fastestJet = new JetImpl();
		fastestJet.setMaxMPH(0.0);
		for (int i = 0; i < fleet.getFleet().size(); i++) {
			if (fastestJet.getMaxMPH() < fleet.getFleet().get(i).getMaxMPH()) {
				fastestJet = fleet.getFleet().get(i);
			}
		}
		System.out.println("The fastest jet in the fleet is: " + fastestJet.getModel());

	}

	private void flyFleet(Airfield fleet) {
		char emoji = '\u2708';
		System.out.println(" " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " "
				+ emoji + " " + emoji);
		fleet.getFleet().forEach(jet -> {
			jet.fly();
		});
	}

	private void printFleet(Airfield fleet) {
		fleet.getFleet().forEach(jet -> {

			System.out.println(jet.toString());
		});

	}

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
}
