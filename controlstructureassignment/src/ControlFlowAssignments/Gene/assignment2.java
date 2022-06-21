package ControlFlowAssignments.Gene;

public class assignment2 {

	public static void main(String[] args) {
		/* Assignment 2
		a. Create a class ForLoopTest with main() method
		b. Declare and initialize an integer variable to any value
		c. Find and print the factorial of the variable using for loop*/
	
		int number = 4;
		int factorial=0;
		
		for (int i =1; i <number; i++) {		
			    factorial +=1*(number-(number-i)); 
			   
			}
		
		factorial = factorial *number;
		
		System.out.println(factorial);
		
		
	}

}
