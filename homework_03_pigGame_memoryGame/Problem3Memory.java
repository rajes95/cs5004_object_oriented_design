/**
 * @author Rajesh Sakhamuru
 * @version 5/31/2019
 * 
 * Memory game consisting of 16 cards (8 pairs of numbers 1 through 8) arranged
 * in a 4x4 grid.
 * 
 * The 4x4 grid of numbers is randomly generated each time the program is run.
 * 
 * Each turn the user inputs two sets of coordinates in the format (#,#) , where
 * '#' is an integer between 1 and 4. After checking for valid input,
 * if the numbers at both coordinates match, then they are shown for the rest of the 
 * game. If they do not match, then the two numbers are shown briefly for 2 seconds
 * and then flipped back over and the game continues. 
 * 
 * When all 16 cards have been matched, then the game is over and the player wins.
 * 
 * */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Problem3Memory
{
	static String hiddenBoard[][] = {{ "1", "1", "2", "2" },
									 { "3", "3", "4", "4" },
									 { "5", "5", "6", "6" },
									 { "7", "7", "8", "8" }};
	static String shownBoard[][] = {{ "*", "*", "*", "*" },
									{ "*", "*", "*", "*" },
									{ "*", "*", "*", "*" },
									{ "*", "*", "*", "*" }};

	/**
	 * This function randomizes the array of integers of pairs between 1-8
	 * and then assigns them to the hiddenBoard array.
	 * */
	public static void randBoard()
	{
		Integer arr[] = new Integer[] { 1, 1, 2, 2, 3, 3, 4, 4, 
				5, 5, 6, 6, 7, 7, 8, 8 };
		int arrCount = 0;

		List<Integer> list = Arrays.asList(arr);
		Collections.shuffle(list);
		Object[] shuffArray = list.toArray();

		for (int r = 0; r < 4; r++)
		{
			for (int c = 0; c < 4; c++)
			{
				hiddenBoard[r][c] = String.valueOf(shuffArray[arrCount]);
				arrCount++;
			}
		}
	}

	/**
	 * This function takes a board (4x4) as a parameter and prints it out so the user
	 * can see it in console.
	 * */
	public static void printBoard(String board[][])
	{
		System.out.printf("  _1_2_3_4_\n");
		for (int r = 0; r < 4; r++)
		{
			System.out.printf("%d |", r + 1);
			for (int c = 0; c < 4; c++)
			{
				System.out.printf("%s ", board[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * This function takes coordinates as a parameter and verifies that they are valid
	 * for use with the hiddenBoard and shownBoard variables.
	 * 
	 * If they are invalid, the function returns false. Otherwise returns true.
	 * 
	 * */
	public static boolean verifyCoords(int coords[][])
	{
		boolean coordsOkay = true;

		for (int r = 0; r < 2; r++)
		{
			for (int c = 0; c < 2; c++)
			{
				if ((coords[r][c] > 3 || coords[r][c] < 0))
				{
					System.out.println("ERROR: COORDINATES OUT OF RANGE.");
					System.out.println("Coordinates should be NUMERIC and between 1 and 4."
							+ "\nFor example: (1,1) or (4,4) or (3,2)\nTRY AGAIN:\n");
					coordsOkay = false;
					break;
				}
			}
			if (coordsOkay == false)
			{
				break;
			}
		}
		
		if ((coordsOkay == true) && (coords[0][0] == coords[1][0]) && (coords[0][1] == coords[1][1]))
		{
			System.out.println("\nERROR: BOTH COORDINATES CANNOT BE THE SAME. TRY AGAIN:\n");
			coordsOkay = false;
		}
		if ((coordsOkay == true) && (!shownBoard[coords[0][0]][coords[0][1]].equals("*")
				|| !shownBoard[coords[1][0]][coords[1][1]].equals("*")))
		{
			System.out.println("ERROR: One or more "
					+ "coordinate already guessed. TRY AGAIN:\n");
			coordsOkay = false;
		}

		return coordsOkay;
	}

	/**
	 * This function takes coordinates as user input in the format '(Row#, Column#)'. 
	 * 
	 * If the coordinates are not valid, then the function recursively calls itself 
	 * for a new set of coordinates to be input, until a valid set of coordinates are
	 * received. 
	 * 
	 * */
	public static int[][] userInput(Scanner keyboard)
	{
		System.out.println("Enter two sets of coordinates "
				+ "in the format: '(Row#, Column#)'.");
		System.out.println("Enter first Coordinate:");
		String coord1 = keyboard.next();
		System.out.println("Enter second Coordinate:");
		String coord2 = keyboard.next();
		int coords[][] = { { 0, 0 }, { 0, 0 } };
		int c1[] = { 0, 0 };
		int c2[] = { 0, 0 };
		try
		{
			c1[0] = Character.getNumericValue(coord1.charAt(1)) - 1;
			c1[1] = Character.getNumericValue(coord1.charAt(3)) - 1;
			c2[0] = Character.getNumericValue(coord2.charAt(1)) - 1;
			c2[1] = Character.getNumericValue(coord2.charAt(3)) - 1;
			coords[0] = c1;
			coords[1] = c2;
		} 
		catch (Exception e)  // catches non-numeric or too-short input
		{
			System.out.println("\nERROR: INPUT IS INVALID. TRY AGAIN:\n");
			coords = userInput(keyboard);
		}

		if (!(verifyCoords(coords)))
		{
			coords = userInput(keyboard);
		}
		return coords;
	}

	/**
	 * If there is a "*" string in the board visible to the user, then the 
	 * game is not over, and the function returns false. Otherwise it returns true.
	 * */
	public static boolean checkGameOver()
	{
		boolean gameOver = true;
		for (int r = 0; r < 4; r++)
		{
			for (int c = 0; c < 4; c++)
			{
				if (shownBoard[r][c].equals("*"))
				{
					gameOver = false;
					break;
				}
			}
			if (gameOver == false)
			{
				break;
			}
		}
		return gameOver;
	}

	/**
	 * Main of the program.
	 * 
	 * Initializes the game and enters the while loop, which only exits when the game board
	 * is completely uncovered.
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		randBoard();

		System.out.println("Let's play a memory game!!!");
		System.out.println("Each turn input 2 sets of coordinates.");
		while (true)
		{

			printBoard(shownBoard);

			if (checkGameOver()) //exits while loop if checkGameOver() returns true.
			{
				System.out.println("\nCONGRATULATIONS! YOU WIN!\n");
				break;
			}
			int coords[][] = userInput(keyboard);

			if (hiddenBoard[coords[0][0]][coords[0][1]].
					contentEquals(hiddenBoard[coords[1][0]][coords[1][1]]))
			{
				shownBoard[coords[0][0]][coords[0][1]] = 
						hiddenBoard[coords[0][0]][coords[0][1]];
				shownBoard[coords[1][0]][coords[1][1]] = 
						hiddenBoard[coords[1][0]][coords[1][1]];
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("You got a match!!!");
			} 
			else
			{

				shownBoard[coords[0][0]][coords[0][1]] = 
						hiddenBoard[coords[0][0]][coords[0][1]];
				shownBoard[coords[1][0]][coords[1][1]] = 
						hiddenBoard[coords[1][0]][coords[1][1]];

				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("Sorry, those cards don't match.");
				printBoard(shownBoard);
				try
				{
					TimeUnit.SECONDS.sleep(2); // 2 second pause
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				shownBoard[coords[0][0]][coords[0][1]] = "*";
				shownBoard[coords[1][0]][coords[1][1]] = "*";
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}
		}

		keyboard.close();
	}
}
