package com.sg.foundations.basics.arrays;

public class FruitBasket {

	public static void main(String[] args) {


		String[] fruitBasket={"Orange", "Apple", "Orange", "Apple", "Orange", 
				"Apple",
		
			"Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", 
			"Orange",
			"Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", 
			"Apple",
			"Orange", "Orange", "Apple", "Apple", "Apple", "Banana", "Apple", 
			"Orange",
			"Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange",
			"Apple",
			"Apple", "Apple", "Apple", "Orange", "Orange", "PawPaw", "Apple",
			"Orange","Orange", "Apple", "Orange", "Orange", "Apple", 
			"Apple", "Orange", "Orange", "Apple", "Orange", "Apple", 
			"Kiwi", "Orange", "Apple", "Orange",
			"Dragonfruit", "Apple", "Orange", "Orange"};
		int numOranges = 0;
		int numApples = 0;
		int numOtherFruit =0;
		
		// Fruit counting code goes here!
		for(int i=0; i< fruitBasket.length; i++)
		{
			
			switch(fruitBasket[i]) {
				case "Orange": {
					numOranges++;
					break;
				}	
				case "Apple": {
					numApples++;
					break;
				}	
				default: {
					numOtherFruit++;
				}	
			}
		}

		System.out.println("Number of Appples: "+numApples);
		System.out.println("Number of Oranges: " +numOranges);
		System.out.println("Number of Other Fruit: " +numOtherFruit);
		
		// Print The Results!

	  
	}

 
}