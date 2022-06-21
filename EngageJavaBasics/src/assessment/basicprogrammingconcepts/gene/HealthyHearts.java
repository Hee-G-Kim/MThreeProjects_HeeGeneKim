package assessment.basicprogrammingconcepts.gene;

import java.util.Scanner;

public class HealthyHearts {

	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("What is your age? \n ");
		int age = myObj.nextInt(); // Read user input
		
		int maxHR = 220 - age;
		double lowHRZOne= 0.5*( 220 - age);
		double highHRZOne= 0.85*( 220 - age);
		
		System.out.println("Your maximum heart rate should be "+ maxHR +" beats per minute");
		System.out.println("Your target HR Zone is "+ lowHRZOne +"-"+ highHRZOne +"beats per minute");
		myObj.close();
	}

}
