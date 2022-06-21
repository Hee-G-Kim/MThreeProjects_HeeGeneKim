package com.sg.foundations.basics.arrays;

import java.util.Random;

public class HiddenNuts {

	public static void main(String[] args) {
		
		String[] hidingSpots = new String[100];
		Random squirrel = new Random();
		hidingSpots[squirrel.nextInt(hidingSpots.length)]="Nut";
		System.out.println("The nut has been hidden ...");
		
//		for(int spot=0; spot< hidingSpots.length; spot++) {
//			if(spot !=null && spot.equals("Nut")) {
//				System.out.println("Nut is here" + spot);
//			}
//			else {
//				System.out.println("Nothing found");
//			}
//		}
		for(int spot=0; spot< hidingSpots.length; spot++) {
			if(hidingSpots[spot] == "Nut") {
				System.out.println("Found it! It's in spot# " + spot);
			}
			
		}
	}

}
