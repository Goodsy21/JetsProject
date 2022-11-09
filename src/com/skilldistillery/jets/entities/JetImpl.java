package com.skilldistillery.jets.entities;

public class JetImpl extends Jet{

	@Override
	public void fly() {
		System.out.println("This is " + this.getModel() + " I can fly for " + this.getRange() / this.getMaxMPH() + " hours");		
	}

}
