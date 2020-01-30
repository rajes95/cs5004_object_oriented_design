/**
 * @author Rajesh Sakhamuru
 * @version 5/31/2019
 * 
 * The game of Pig is a simple two-player dice game in which the player to reach
 * 100 or more points wins. 
 * If a player rolls a 1, they get 0 points that turn and the turn is over.
 * If a player rolls 2-6, then they can roll again or hold, which ends their turn
 * 		and they get to keep the points they have accumulated that turn.
 * 
 * This implementation of Pig is the user playing against the computer which utilizes
 * the strategy of rolling until it gets 20 or more points and then holding.
 * 
 * */

import java.util.Scanner;
import java.util.Random;

public class Problem2Pig
{
	static int userScore = 0;  // keeps track of total user score
	static int compScore = 0;  // keeps track of total computer score
	static int userCount = 0;  // keeps track of user's score in a single turn
	static int compCount = 0;  // keeps track of computer's score in a single turn

	/**
	 * This funcion is called when it is the computers turn, and is called every time 
	 * the computer re-rolls, in order to generate a new die roll.
	 * */
	public static int compTurn()
	{

		int roll = roll();
		if (roll == 1)
		{
			System.out.printf("Computer rolled a 1.\nIt gets 0 points and its turn is over.\n\n");
			compCount = 0;
		} else
		{
			System.out.printf("Computer rolled a %d.\n", roll);
			compCount += roll;
		}

		return compCount;
	}

	/**
	 * This function is called whenever it is the users turn or when the user decides 
	 * to re-roll (based on user input taken in main.
	 * */
	public static int userTurn()
	{
		int roll = roll();
		if (roll == 1)
		{
			System.out.printf("You rolled a 1.\nYou get 0 points and your turn is over.\n\n");
			userCount = 0;
		} else
		{
			System.out.printf("You rolled a %d.\n", roll);
			userCount += roll;
		}
		return userCount;
	}

	/**
	 * This function returns a random integer between 1 and 6 to simulate a dice-roll.
	 * */
	public static int roll()
	{
		Random rand = new Random();
		int roll = rand.nextInt(6) + 1;
		return roll;
	}

	/**
	 * Runs the main pig program.
	 * It runs the game in a while loop, and takes user input every time it is their turn.
	 * The game exits the while loop when someone has 100 points or more.
	 * */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Let's Play PIG!\n");
		System.out.printf("You will play against the Computer.\n");
		System.out.printf("Your score:     %d\n", userScore);
		System.out.printf("Computer score: %d\n\n", compScore);
		System.out.printf("You go first.\n");
		while ((userScore < 100) && (compScore < 100))
		{
			System.out.printf("\nIt's your turn.\n");
			while ((userTurn() != 0) && (userCount + userScore < 100))
			{
				System.out.printf("Type 'r' to ROLL AGAIN\nType 'h' to HOLD\n");
				String inp = keyboard.next();
				if (inp.equals("r"))
				{
					System.out.println("You are rolling again.");
				} else
				{
					System.out.println("You are holding.\n");
					break;
				}

			}
			userScore += userCount;
			if (userScore >= 100)    // user win condition
			{
				System.out.println("You are holding because you have won.\n");
				break;
			}

			System.out.printf("Your score:     %d\n", userScore);
			System.out.printf("Computer score: %d\n\n", compScore);
			userCount = 0;  // resets score to restart counting for the next turn.

			System.out.printf("\nIt's the computer's turn.\n");
			while ((compCount < 20) && (compCount + compScore < 100))
			{
				if (compCount > 0)
				{
					System.out.println("Computer is rolling again.\n");
				}
				if (compTurn() == 0) // if computer rolls a 1, compTurn() returns 0. 
				{
					break;
				}
			}
			if (compCount >= 20)
			{
				System.out.println("Computer is holding.\n");
			}

			compScore += compCount;
			if (compScore >= 100)
			{
				System.out.println("Computer is holding because it has won.\n");
				break;
			}
			System.out.printf("\nYour score:     %d\n", userScore);
			System.out.printf("Computer score: %d\n\n", compScore);
			compCount = 0;  // resets score to restart counting for the next turn.
		}
		if (userScore > compScore)
		{
			System.out.printf("CONGRATULATIONS! YOU WIN!\n");
		} else
		{
			System.out.printf("SORRY! YOU LOSE!\n");
		}
		System.out.printf("Your final score is:       %d\n", userScore);
		System.out.printf("Computer's final score is: %d\n", compScore);
		keyboard.close();
	}
}
