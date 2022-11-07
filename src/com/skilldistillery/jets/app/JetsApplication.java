package com.skilldistillery.jets.app;
import java.util.Scanner;
import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		Airfield fleet = new Airfield();

//		do {
		System.out.println("Select a menu option");
		System.out.println("1 - List fleet");
		System.out.println("2 - Fly all jets");
		System.out.println("3 - View fastest jet");
		System.out.println("4 - View jet with longest range");
		System.out.println("5 - Load all Cargo Jets");
		System.out.println("6 - DOGFIGHT!");
		System.out.println("7 - Add a jet to the fleet");
		System.out.println("8 - Remove a jet from the fleet");
		System.out.println("9 - Quit Program");

//	} while (sc.nextInt() != 9);
		int menuSelection;

		menuSelection = sc.nextInt();
		sc.nextLine();
		switch (menuSelection) {
		case 1:
			System.out.println(fleet); // I think I need to parseInt here

			break;
		case 2:
			char emoji = '\u2708';
			System.out.println(" " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " " + emoji + " "
					+ emoji + " " + emoji);
			break;
		case 3:
			System.out.println("The fastest jet in the fleet is: ");
			break;
		case 4:
			System.out.println("The jet with the furthest range is: "); //+ jet 
			break;
		case 5: //LoadAllPassengers loadPassengers() sysout "Now boarding group A; that's A as in Awwwwwwwww Yeah
			break;
		case 6: //Dogfight: if Jet type is fighter (use instanceof): call fight method
			break;
		case 7:
//	Add a jet to the fleet
			break;
		case 8:
//		Remove a jet from the fleet
			break;
		case 9:
			System.out.println("Safe travels");
			break;

		default:
			System.out.println("Invalid entry, select a number from 1-9");
			break;
		}
	}
}
