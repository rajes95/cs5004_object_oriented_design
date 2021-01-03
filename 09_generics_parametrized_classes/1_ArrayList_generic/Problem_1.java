import cs5004_hw9_problem1.Waypoint;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem_1.java
 * 
 * This program uses the ArrayList class to create an expandable array of
 * Waypoint objects which hold a location (x and y coordinates as doubles) and a
 * timestamp as an integer. Total distance and average speed in miles/hr is
 * calculated from the data. Each waypoint is input via user input taking x, y
 * and t separately and then being asked if they would like to input another
 * waypoint.
 * 
 * Errors in input, such as non-consecutive input or non-numeric input, cause
 * the program to ask for that specific input again so the user can correct the
 * error.
 * 
 * 
 * @author Rajesh Sakhamuru
 * @version 7/29/2019
 * 
 */
public class Problem_1
{
	// private static scanner for the whole class to use.
	private static Scanner inp = new Scanner(System.in);

	/**
	 * The main takes x, y and t for each waypoint until all waypoints are input by
	 * user and then total distance and average speed are calculated each step along
	 * the way.
	 * 
	 * @param args - not used
	 */
	public static void main(String[] args)
	{

		// This arrayList can expand to hold any number of waypoints
		ArrayList<Waypoint> gpsRecord = new ArrayList<Waypoint>();

		double distance = 0;
		double speed = 0;

		boolean again = true;

//		user input in while loop
		while (again)
		{
			double x = xInput();
			double y = yInput();
			int t = tInput(gpsRecord);

			gpsRecord.add(new Waypoint(x, y, t));

			distance = totalDistance(gpsRecord);
			speed = averageSpeed(gpsRecord, distance);

			System.out.printf("\nCurrent distance: %.4f miles\nCurrent speed: %.4f mph", distance, speed);

			again = againInput();
		}

		System.out.printf("Total distance: %.4f miles\nTotal speed: %.4f mph\nGoodbye.", distance, speed);
		inp.close();
	}

	/**
	 * This function takes user input of the x-coordinate of the waypoint, and if
	 * the input is invalid it recursively takes input until valid input is
	 * provided.
	 * 
	 * @return x - double - value of x-coordinate of waypoint
	 */
	private static double xInput()
	{
		String in = "";
		double x = 0;
		try
		{
			System.out.println("Input x-coordinate of next waypoint:");
			in = inp.nextLine();
			// parseDouble() throws NumberFormatException if data is invalid
			x = Double.parseDouble(in);

		}
		catch (NumberFormatException e)
		{
			System.out.println("ERROR: Invalid input: " + e.getMessage());
			System.out.println("Enter any numerical double value for 'x'.");
			x = xInput();
		}

		return x;
	}

	/**
	 * This function takes user input of the y-coordinate of the waypoint, and if
	 * the input is invalid it recursively takes input until valid input is
	 * provided.
	 * 
	 * @return y - double - value of y-coordinate of waypoint
	 */
	private static double yInput()
	{
		String in = "";
		double y = 0;
		try
		{
			System.out.println("Input y-coordinate of next waypoint:");
			in = inp.nextLine();
			// parseDouble() throws NumberFormatException if data is invalid
			y = Double.parseDouble(in);
		}
		catch (NumberFormatException e)
		{
			System.out.println("ERROR: Invalid input: " + e.getMessage());
			System.out.println("Enter any numerical double value for 'y'.");
			y = yInput();
		}
		return y;
	}

	/**
	 * This function takes user input of the timestamp of the waypoint, and if the
	 * input is invalid it recursively takes input until valid input is provided.
	 * 
	 * @return t - int - value of timestamp of waypoint
	 */
	private static int tInput(ArrayList<Waypoint> gpsRecord)
	{
		String in = "";
		int t = 0;

		try
		{
			System.out.println("Input t, timestamp of next waypoint:");
			in = inp.nextLine();
			// parseInt() throws NumberFormatException if data is invalid
			t = Integer.parseInt(in);

			// ensures that timestamp is consecutive (after the previously input waypoint)
			if ((t < 0) || ((gpsRecord.size() > 0) && (t <= gpsRecord.get(gpsRecord.size() - 1).getT())))
			{
				throw new IllegalArgumentException(
						"'t' must be positive and greater than the value of 't' of the previous waypoint.");
			}

		}
		catch (NumberFormatException e)
		{
			System.out.println("ERROR: Invalid input:" + e.getMessage());
			System.out.println("Enter any numerical integer value greater than the previous value for 't'.");
			t = tInput(gpsRecord);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("ERROR: Invalid input:\n" + e.getMessage());
			t = tInput(gpsRecord);
		}
		return t;
	}

	/**
	 * totalDistance cycles through the gpsRecord and measures the distance between
	 * each consecutive waypoint and adds them up to calculate total distance
	 * 
	 * @param gpsRecord - ArrayList<Waypoint> - All waypoints input so far by the
	 *                  user
	 * @return distance - double - total distane in MILES traveled so far
	 */
	private static double totalDistance(ArrayList<Waypoint> gpsRecord)
	{
		double distance = 0;

		double startX = 0;
		double startY = 0;
		double endX = 0;
		double endY = 0;

		// distance = sqrt((x2 − x1)2 + (y2 − y1)2)
		for (int n = 0; n < gpsRecord.size() - 1; n++)
		{
			startX = gpsRecord.get(n).getX();
			startY = gpsRecord.get(n).getY();

			endX = gpsRecord.get(n + 1).getX();
			endY = gpsRecord.get(n + 1).getY();

			// distance = sqrt((x2 − x1)^2 + (y2 − y1)^2)
			distance += Math.sqrt(Math.pow((endX - startX), 2) + Math.pow((endY - startY), 2));
		}

		// map scaling factor of 1 = 0.1 miles
		distance = distance / 10;

		return distance;
	}

	/**
	 * uses the total distance previously calculated (in miles) and the total time
	 * (calculated by subtracting the most recent waypoint time from the first
	 * waypoint time in gpsRecord) to calculate the averageSpeed from the fist to
	 * the most recent waypoint.
	 * 
	 * @param gpsRecord     - ArrayList<Waypoint> - all waypoints input by user
	 * @param distanceMiles - total distance traveled so far calculated
	 * @return mph - double - in miles per hour average speed of whole trip
	 */
	private static double averageSpeed(ArrayList<Waypoint> gpsRecord, double distanceMiles)
	{
		int totalTime = 0;
		double mph = 0;
		totalTime = gpsRecord.get(gpsRecord.size() - 1).getT() - gpsRecord.get(0).getT();

		// 3600 seconds per hour
		double timeHours = (double) totalTime / 3600;

		if (timeHours != 0)
		{
			mph = distanceMiles / timeHours;
		}
		else
		{
			mph = 0;
		}

		return mph;
	}

	/**
	 * takes input of either yes or no (or y or n) as to whether a new waypoint
	 * would be liked to be input or whether the user is done inputting waypoints.
	 * 
	 * @return again - boolean - true if the user would like to input another
	 *         waypoint
	 */
	private static boolean againInput()
	{

		boolean again = false;

		try
		{
			System.out.println("\nEnter another coordinate? (y/n)");
			String input = inp.nextLine();
			input = input.trim();
			System.out.println();

			// user inputs yes
			if (input.substring(0, 1).equals("y") || input.substring(0, 1).equals("Y"))
			{
				return true;
			}
			// user inputs no
			else if (input.substring(0, 1).equals("n") || input.substring(0, 1).equals("N"))
			{
				return false;
			}
			// user inputs anything else
			else
			{
				throw new IllegalArgumentException("ERROR: input must either begin with 'y'/'Y' or 'n'/'N'.");
			}
		}
		// catches invalid input and recursively calls againInput() again.
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			again = againInput();
		}
		return again;
	}

}
