package com.skilldistillery.jets.entities;

public class Fighter extends Jet implements FighterInterface {

	public void dogFight() {
		System.out.println("This is " + getModel() + " I be fightin'");
	}
}