package com.skilldistillery.jets.entities;

public class Spy extends Jet implements SpyInterface {
	@Override
	public void fly() {
		System.out.println("This is " + this.getModel()
				+ " don't mind me. Just watching you... from a distance. ;) I'll be up here for "
				+ this.getRange() / this.getMaxMPH() + " hours");
	}

	@Override
	public void takePictures() {
		System.out.println("Say cheese");

	}
}
