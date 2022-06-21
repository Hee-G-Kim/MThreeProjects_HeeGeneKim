package com.sg.foundations.basics.arrays;

import java.util.Iterator;

public class FruitSalad {

	public static void main(String[] args) {
		
		String[] Fruit = { "Kiwi Fruit", "Gala Apple", "Granny Smith Apple", 
				"Cherry Tomato", "Gooseberry", "Beefsteak Tomato", 
				"Braeburn Apple", "Blueberry", "Strawberry", 
				"Navel Orange", "Pink Pearl Apple", "Raspberry", 
				"Blood Orange", "Sungold Tomato", "Fuji Apple", 
				"Blackberry", "Banana", "Pineapple", "Florida Orange", 
				"Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", 
				"Snozzberry"
		};
		String[] fruitSalad;
		
		
		// Code Recipe for fruit salad should go here!
//		As many berries as possible = 6 berries
//		No more than three kinds of apples =total 3/6 apples
//		No more than two kinds of orange =total 2/4 oranges
//		Definitely no tomatoes
//		No more than twelve kinds of fruit + <=9 other fruits
		
		fruitSalad = new String[24];
		int otherFruit=0;
		int apples=0;
		int oranges=0;
		for (int i = 0; i < Fruit.length; i++) {
				
				if(Fruit[i].contains("berry"))
				{
					fruitSalad[i] = Fruit[i];
				}
				else if(Fruit[i].contains("Apple") && apples <4)
				{
					fruitSalad[i] = Fruit[i];
					apples++;
				}
				else if(Fruit[i].contains("Orange") && oranges <3)
				{
					fruitSalad[i] = Fruit[i];
					oranges++;
				}
				else if(!Fruit[i].contains("Tomato") && otherFruit<10) {
					fruitSalad[i] = Fruit[i];
					otherFruit++;
				}
				
		}
		System.out.println("There are " + (otherFruit +3) + 
				" types of fruit in this salad");
		
		for (int i = 0; i < fruitSalad.length; i++) {
			
			if(fruitSalad[i] !=null) {
				System.out.println(fruitSalad[i]+", ");
				}	
		
		}
		
	}
}
