package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {
	ArrayList<Jet> fleet = new ArrayList<Jet>();
	Scanner sc = new Scanner(System.in);

	public void setFleet(ArrayList<Jet> fleet) {
		this.fleet = fleet;
	}

	public ArrayList<Jet> getFleet() {
		return fleet;
	}

	List<String> allPlanes = reader();

	ArrayList<String> reader() {
		BufferedReader br = null;
		ArrayList<String> airfield = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader("Jets.txt"));
			String jet;
			while ((jet = br.readLine()) != null) {
				airfield.add(jet);
				System.out.println();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return airfield;
	}

	public void populateAirfield() {

		ArrayList<Jet> fleetList = new ArrayList<Jet>();
		try (BufferedReader br = new BufferedReader(new FileReader("./Jets.txt"))) {

			String delimiter = ",";
			String line;
			while ((line = br.readLine()) != null) {
				String[] attributes = line.split(delimiter);

				String type = attributes[0];
				String model = attributes[1];
				Double maxMPH = Double.parseDouble(attributes[2]);
				Double range = Double.parseDouble(attributes[3]);
				Double price = Double.parseDouble(attributes[4]);

				if (type.equalsIgnoreCase("Fighter")) {

					Fighter jetFromFile = new Fighter();
					jetFromFile.setType(type);
					jetFromFile.setModel(model);
					jetFromFile.setMaxMPH(maxMPH);
					jetFromFile.setRange(range);
					jetFromFile.setPrice(price);
					fleetList.add(jetFromFile);

				} else if (type.equalsIgnoreCase("Passenger")) {

					Passenger jetFromFile = new Passenger();
					jetFromFile.setType(type);
					jetFromFile.setModel(model);
					jetFromFile.setMaxMPH(maxMPH);
					jetFromFile.setRange(range);
					jetFromFile.setPrice(price);
					fleetList.add(jetFromFile);

				} else if (type.equalsIgnoreCase("Spy")) {

					Spy jetFromFile = new Spy();
					jetFromFile.setType(type);
					jetFromFile.setModel(model);
					jetFromFile.setMaxMPH(maxMPH);
					jetFromFile.setRange(range);
					jetFromFile.setPrice(price);
					fleetList.add(jetFromFile);

				} else {

					JetImpl jetFromFile = new JetImpl();
					jetFromFile.setType(type);
					jetFromFile.setModel(model);
					jetFromFile.setMaxMPH(maxMPH);
					jetFromFile.setRange(range);
					jetFromFile.setPrice(price);
					fleetList.add(jetFromFile);

				}
				System.out.println();
			}
			setFleet(fleetList);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void executeSelectedItem(int menuSelection) {
		switch (menuSelection) {
		case 1:
			printFleet();
			break;
		case 2:
			flyFleet();
			break;
		case 3:
			findAndPrintFastestJet();
			break;
		case 4:
			findAndPrintLongestRange();
			break;
		case 5:
			loadPassengers();
			break;
		case 6:
			startFight();
			break;
		case 7:
			addJet();
			break;
		case 8:
			removeJet();
			break;
		case 9:
			System.out.println("Safe travels");
			break;

		default:
			System.out.println("Invalid entry, select a number from 1-9");
			break;
		}
	}

	private void printFleet() {
		getFleet().forEach(jet -> {
			System.out.println(jet.toString());
		});
	}

	private void flyFleet() {
		char emoji = '\u2708';
		System.out.println(" " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " "
				+ emoji + " " + emoji);
		getFleet().forEach(jet -> {
			jet.fly();
		});
	}

	private void findAndPrintFastestJet() {
		Jet fastestJet = new Passenger();
		fastestJet.setMaxMPH(0.0);
		for (int i = 0; i < getFleet().size(); i++) {
			if (fastestJet.getMaxMPH() < getFleet().get(i).getMaxMPH()) {
				fastestJet = getFleet().get(i);
			}
		}
		System.out.println("The fastest jet in the airfield is: " + fastestJet.getModel());
	}

	private void findAndPrintLongestRange() {
		Jet longestJet = new Passenger();
		longestJet.setRange(0.0);
		for (int i = 0; i < getFleet().size(); i++) {
			if (longestJet.getRange() < getFleet().get(i).getRange()) {
				longestJet = getFleet().get(i);
			}
		}
		System.out.println("The jet with the longest range in the fleet is: " + longestJet.getModel());
	}

	private void loadPassengers() {
		for (int i = 0; i < getFleet().size(); i++) {
			if (getFleet().get(i).getType().equalsIgnoreCase("Passenger")) {
				System.out.println(getFleet().get(i).getModel() + " is loading passengers");
			}
		}
	}

	private void startFight() {
		for (int i = 0; i < getFleet().size(); i++) {
			if (getFleet().get(i) instanceof Fighter) {
				((Fighter) getFleet().get(i)).dogFight();
			}
		}
	}

	private void addJet() {
		System.out.println("What type of plane would you like to add?");
		String type = sc.next();
		System.out.println("What is the model?");
		String model = sc.next();
		System.out.println("What is the top speed in MPH?");
		Double maxMPH = sc.nextDouble();
		System.out.println("What is the flying range in miles?");
		Double range = sc.nextDouble();
		System.out.println("How much does that plane cost?");
		Double price = sc.nextDouble();

		if (type.equalsIgnoreCase("Fighter")) {

			Fighter addedJet = new Fighter();
			addedJet.setType(type);
			addedJet.setModel(model);
			addedJet.setMaxMPH(maxMPH);
			addedJet.setRange(range);
			addedJet.setPrice(price);
			getFleet().add(addedJet);

		} else if (type.equalsIgnoreCase("Passenger")) {

			Passenger addedJet = new Passenger();
			addedJet.setType(type);
			addedJet.setModel(model);
			addedJet.setMaxMPH(maxMPH);
			addedJet.setRange(range);
			addedJet.setPrice(price);
			getFleet().add(addedJet);

		} else if (type.equalsIgnoreCase("Spy")) {

			Spy addedJet = new Spy();
			addedJet.setType(type);
			addedJet.setModel(model);
			addedJet.setMaxMPH(maxMPH);
			addedJet.setRange(range);
			addedJet.setPrice(price);
			getFleet().add(addedJet);

		} else {

			JetImpl addedJet = new JetImpl();
			addedJet.setType(type);
			addedJet.setModel(model);
			addedJet.setMaxMPH(maxMPH);
			addedJet.setRange(range);
			addedJet.setPrice(price);
			getFleet().add(addedJet);

		}
		System.out.println();
	}

	private void removeJet() {
		System.out.println("Please enter the number you'd like to remove.");
		for (int i = 0; i < getFleet().size(); i++) {
			System.out.println("[" + i + "] - " + getFleet().get(i).toString());
		}
		getFleet().remove(sc.nextInt());
	}

}
