package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements PassengerInterface {

	public void loadPassengers() {

		System.out.println("This is " + getModel() + " we are now boarding group A");
	}

}