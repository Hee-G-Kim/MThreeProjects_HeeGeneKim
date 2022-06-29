package com.sg.dvdlibrary.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;

public class UserIOConsoleImpl implements UserIO {

	Scanner scanner = new Scanner(System.in);

	@Override
	public void print(String msg) {
		// TODO Print a given String to the console.
		// The String value displayed should be passed in as a parameter.
		System.out.println(msg);
	}

	@Override
	public double readDouble(String prompt) {
		// TODO display a given message String to prompt the user to enter in a double,
		// then read in the user response and return that double value.
		// The prompt message value should be passed in as a parameter and the
		// value that is read in should be the return of the method.
		
		print(prompt);
		double inputDouble = scanner.nextDouble();
		return inputDouble;
		
	}

	@Override
	public double readDouble(String prompt, double min, double max) {
		/*
		 * // TODO Display a prompt to the user to enter a double between a specified
		 * min and max range, and read in a double. If the user's number does not fall
		 * within the range, keep prompting the user for new input until it does. The
		 * prompt message and min and max values should be passed in as parameters. The
		 * value read in from the console should be the return of the method.
		 */
	

		Double inputDouble;

		do {
			print(prompt);
			inputDouble = scanner.nextDouble();
		} while (inputDouble > max || inputDouble < min);

		return inputDouble;
	}

	@Override
	public float readFloat(String prompt) {
		/*
		 * // TODO Display a given message String to prompt the user to enter a float
		 * and then read in the user response and return that float value. The prompt
		 * message value should be passed in as a parameter and the value that is read
		 * in should be the return of the method.
		 */
		print(prompt);
		float inputFloat = scanner.nextFloat();
		return inputFloat;
		
	}

	@Override
	public float readFloat(String prompt, float min, float max) {
		/*
		 * // TODO Display a prompt to the user to enter a float between a specified min
		 * and max range, and read in a float. If the user's number does not fall within
		 * the range, keep prompting the user for new input until it does. The prompt
		 * message and min and max values should be passed in as parameters. The value
		 * read in from the console should be the return of the method.
		 */ 
		

		float inputFloat;

		do {
			print(prompt);
			inputFloat = scanner.nextFloat();
		} while (inputFloat > max || inputFloat < min);

		return inputFloat;
	}

	@Override
	public int readInt(String prompt) {
		/*
		 * // Display a given message String to prompt the user to enter in an integer,
		 * then read in the user response and return that integer value. The prompt
		 * message value should be passed in as a parameter and the value that is read
		 * in should be the return of the method.
		 */
		print(prompt);
		int inputInt = scanner.nextInt();
		return inputInt;
	
	}

	@Override
	public int readInt(String prompt, int min, int max) {
		
		/*
		 * //Display a prompt to the user to enter an integer between a specified min
		 * and max range, and read in an integer. If the user's number does not fall
		 * within the range, keep prompting the user for new input until it does. The
		 * prompt message and the min and max values should be passed in as parameters.
		 * The value read in from the console should be the return of the method.
		 * 
		 * Prompt example "enter 2 numbers between 1 and 10"
		 */
		
		 

		int inputInt;

		do {
			System.out.println(prompt + "(" + min + " and " + max + ")");
			 inputInt = scanner.nextInt();
		} while (inputInt > max || inputInt < min);

		return inputInt;

	
	}

	@Override
	public long readLong(String prompt) {
		/*
		 * TODO Display a given message String to prompt the user to enter in a long,
		 * then read in the user response and return that long value. The prompt message
		 * value should be passed in as a parameter and the value that is read in should
		 * be the return of the method.;
		 */
		print(prompt);
		long inputLong = scanner.nextLong();
		return inputLong;
	}

	@Override
	public long readLong(String prompt, long min, long max) {
		/*
		 * Display a prompt to the user to enter a long between a specified min and max
		 * range, and read in a long. If the user's number does not fall within the
		 * range, keep prompting the user for new input until it does. The prompt
		 * message and min and max values should be passed in as parameters. The value
		 * read in from the console should be the return of the method.
		 */


		

		long inputLong;

		do {
			print(prompt);
			inputLong = scanner.nextLong();
		} while (inputLong > max || inputLong < min);

		return inputLong;
	}

	@Override
	public String readString(String prompt) {
		// Display a given message String to prompt the user to enter in a String, then
		// read in the user response as a String and return that value. The prompt
		// message should be passed in as a parameter and the String value read in
		// should be the return value of the method.
		print(prompt);
		String inputString = scanner.nextLine();
		return inputString;
	}

	@Override
	public Date readDate(String string) throws DVDLibraryDaoException {
		    
		    Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(string);
			} catch (Exception e) {
				throw new DVDLibraryDaoException("-_- date format error", e);
			}  
		     
		return date;
	}
}
