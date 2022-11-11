package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {

	@Override
	public void fly() {
		System.out.println("This is " + this.getModel() + " a basic jet, I can fly for "
				+ this.getRange() / this.getMaxMPH() + " hours");
	}
}
