package assessment.basicprogrammingconcepts.gene;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
         
         public static int sumIntArray(int[] a) {
                  int sum = 0;
                  for (int i = 0; i < a.length; i++) {
                          sum += a[i];    
                  }
                 return sum;
      }
	public static void main(String[] args) {
		
			Scanner myObj = new Scanner(System.in); // Create a Scanner object
			System.out.println("What is your dog's name?\n");
			String name = myObj.nextLine(); // Read user input
			int percentageLeft = 99;
			Random random = new Random();
			int[] percentages = new int[5];
			
			String [] dogs= new String[] {"Bernard", "Chihuahua",
					"Dramatic Red Nosed Asian Pug", "Common cur",  "King Doberman"};
		
      		for (int i = 0; i < 4; i++) 
      					{
      						int randomNumber = random.nextInt(percentageLeft);
      						if (randomNumber != 0) 
      						{
      						         percentages[i] = randomNumber;
      						         percentageLeft =percentageLeft-randomNumber;
      						}
      						else {
      							    while (randomNumber==0) 
      							    {
      							    	         randomNumber = random.nextInt(percentageLeft);
      							    	         percentageLeft =percentageLeft-randomNumber;
      								}
      						};
      				}
			//Utilise Do while may be better
			
			
			
			percentages[4] = 100-(percentages[0]+percentages[1]
					+percentages[2]+percentages[3]);
			
			System.out.println("Well then, I have this highly reliable report on "+ name +"'s prestigious background right here.\r\n"
			                  + "\r\n"
			                  + name +" is:  " +"\n");
			for (int i = 0; i < percentages.length; i++) {
				System.out.println( dogs[i] + ": " + percentages[i]+"%" );
			}
			System.out.println("\n");
			System.out.println("Wow, that's QUITE the dog!  ");
	
       }
}
