package assessment.basicprogrammingconcepts.gene;

import java.util.Random;
import java.util.Scanner;
/*Error*/
public class DogGenetic2 {

public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("What is your dog's name?\n ");
		String name = myObj.nextLine(); // Read user input
		//int percentageLeft = 101;
		Random random = new Random();
		double[] percentages = new double[5];
		double TotalPercentage = percentages[0]+percentages[1]
				+percentages[2]+percentages[3]+percentages[4];
		String [] dogs= new String[] {"Bernard", "Chihuahua",
				"Dramatic Red Nosed"+ "Common cur",  "King Doberman"};
		
		//do {
			
				for (int i = 0; i < 5; i++) 
				{
					
					double randomNumber = random.nextDouble();
					if (randomNumber != 0) 
					{
						percentages[i] = randomNumber*100;
						
					}
					else {
						    while (randomNumber==0) 
						    {
						    	randomNumber = random.nextDouble();
							}
						};
				}
				
		//	} 
		//while(TotalPercentage != 100.0);
	
				System.out.println("bye");
		
		for (int i = 0; i < percentages.length; i++) {
			System.out.print(percentages[i]+ " " + dogs[i]);
		}
		
		System.out.println("bye");
       }
}
