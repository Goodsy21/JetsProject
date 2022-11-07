package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	ArrayList<String> fleet;
	List<String> allPlanes = reader();
	private ArrayList<ArrayList<String>> createAirfield() {
		ArrayList<ArrayList<String>> airfield = new ArrayList<>();
		for (int i = 0; i <= airfield.size(); i++) {
			airfield.add(new ArrayList<>());
		}
		System.out.println(airfield.toString());
		return airfield;
	}
	private ArrayList<String> reader() {
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
		return fleet;
	}
	
}
