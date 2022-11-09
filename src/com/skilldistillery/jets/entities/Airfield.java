package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	ArrayList<Jet> fleet = new ArrayList<Jet>();
	
	
	
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

}
