import java.util.Random;

import java.util.Scanner;

public class RandomNum {

	public static void main(String[] args) {
		Random rng = new Random();
		
		/*double randomValue = rng.nextDouble();
		boolean coinIsHeads = randomValue < 0.5;
        System.out.println(randomValue);
		System.out.println(coinIsHeads);*/
		
		// maximum is 5.0
		 //minimum is -5.0
		double rn = rng.nextDouble();
		//double desiredOutput = rng.nextDouble() * (5 - -5) + -5.0;
		double desiredOutputStep1=rn* (5 - -5);
	    double desiredOutputStep2=desiredOutputStep1	 + -5.0;
		System.out.println(rn);
		System.out.println(desiredOutputStep1);
		System.out.println(desiredOutputStep2);
		

		
	}

}
