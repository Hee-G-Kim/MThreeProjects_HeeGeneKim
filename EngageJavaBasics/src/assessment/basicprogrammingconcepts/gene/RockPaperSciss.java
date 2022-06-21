package assessment.basicprogrammingconcepts.gene;

import java.util.Random;
import java.util.Scanner; // Import the Scanner class

public class RockPaperSciss {

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter Rounds to play:\n ");
		int rounds = myObj.nextInt(); // Read user input

		int ties = 0;
		int playerWins = 0;
		int computerWins = 0;
		for (int i = 0; i < rounds; i++) {

			System.out.println("Enter rock, paper,scissors: \n");
			String playerChoice = myObj.nextLine();

			Random random = new Random();
			int randomNumber = random.nextInt(3);
			String computerChoice = "";
			switch (randomNumber) {
			case 0:
				computerChoice = "rock";
				break;
			case 1:
				computerChoice = "paper";
				break;
			case 2:
				computerChoice = "scissors";
				break;
			}

			if (computerChoice == playerChoice) {
				System.out.println("Tie! ");
				ties++;
			} else if (computerChoice == "rock" && playerChoice == "scissors"
					|| computerChoice == "paper" && playerChoice == "rock"
					|| computerChoice == "scissors" && playerChoice == "paper") {
				System.out.println("You lose! ");
				computerWins++;
			} else if (playerChoice == "rock" && computerChoice == "scissors"
					|| playerChoice == "paper" && computerChoice == "rock"
					|| playerChoice == "scissors" && computerChoice == "paper") {
				System.out.println("You win! ");
				playerWins++;
			}
		}

		if (computerWins > playerWins) {
			System.out.println(
					"You Lose: " + "User wins:  " + playerWins + "Computer wins: " + computerWins + "Ties: " + ties);
		} else if (playerWins > computerWins) {
			System.out.println(
					"You Win: " + "User wins:  " + playerWins + "Computer wins: " + computerWins + "Ties: " + ties);
		}else{System.out.println("Tie");}

	}

}
