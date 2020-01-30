import java.util.Scanner;
import cs5004_hw8_problem1.MonthException;
import cs5004_hw8_problem1.DayException;
import cs5004_hw8_problem1.YearException;

/**
 * Problem_1.java
 *
 * This program converts dates from numerical month/day/year format to normal
 * “month day, year” format (for example, 12/25/2000 corresponds to December 25,
 * 2000).
 * 
 * If the user enters input that is not in the format MM/DD/YYYY (where MM and
 * DD can be either single or double-digits), then it asks for an entire
 * re-input of the date. If the user enters anything other than a legal month
 * number (integers from 1 to 12), the program will throw and catch a
 * MonthException and ask the user to reenter the month. Similarly, if the user
 * enters anything other than a valid day number (integers from 1 to either 28,
 * 29, 30, or 31, depending on the month and year), then your program will throw
 * and catch a DayException and ask the user to reenter the day. If the user
 * enters a year that is not in the range 1000 to 3000 (inclusive), then the
 * program will throw and catch a YearException and ask the user to reenter the
 * year.
 * 
 * 
 * @author Rajesh Sakhamuru
 * @version 7/22/2019
 * 
 */
public class Problem_1
{

	final private static String months[] = { null, "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };

	// scanner for user keyboard input for use in this class.
	private static Scanner inp = new Scanner(System.in);

	/**
	 * This main program takes user input of a date in format MM/DD/YYYY, parses it
	 * for the month, day and year as integers, while checking for errors in input.
	 * The program then prints the date in format Month #, YEAR.
	 * 
	 * @param args - String[] - not used.
	 */
	public static void main(String[] args)
	{
		String input = getAndConvertInput();

		int year = getYear(input);
		int month = getMonth(input);
		int day = getDay(input, month, year);

		System.out.println(months[month] + " " + day + ", " + year);
		inp.close();
	}

	/**
	 * takes user input by using getInput(), then splits the String into an array of
	 * strings of size 3, holding day, month and year as given by input but
	 * formatted to have 2 digits for month and day and 4 digits for year with
	 * leading 0s if necessary. The elements of the array are then formatted to a
	 * single string and returned.
	 * 
	 * @return String - a formatted date string with leading 0s if necessary
	 */
	private static String getAndConvertInput()
	{

		String input[] = new String[3];
		String formatted = "";
		try
		{
			String date = getInput();

			// splits input with "/" as delimiter into an array of maximum length 3.
			input = date.split("/", 3);

			if (input[0].length() > 2)
			{
				// will cause MonthException to be thrown later on
				input[0] = "00";
			}
			if (input[1].length() > 2)
			{
				// will cause DayException to be thrown later on
				input[1] = "00";
			}
			if (input[2].length() > 4)
			{
				// will cause YearException to be thrown later on
				input[2] = "0000";
			}

			// adds leading 0s to the input if necessary (this is where a possible error may
			// be thrown
			input[0] = ("00" + input[0]).substring(input[0].length());
			input[1] = ("00" + input[1]).substring(input[1].length());
			input[2] = ("0000" + input[2]).substring(input[2].length());

			// creates the string that is returned in the MM/DD/YYYY date format
			formatted = input[0] + "/" + input[1] + "/" + input[2];

		}
		// triggered if there are less than, or more than 2 '/' characters in the user
		// input.
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("ERROR: INVALID FORMAT.\n");
			System.out.println("(MM and DD can be either single or double-digits)");
			// if invalid input then this function recursively calls itself so it can try
			// and get correctly formatted input again.
			formatted = getAndConvertInput();
		}

		return formatted;
	}

	/**
	 * This program gets input using the inp class scanner for user input and trims
	 * it then returns the string input. If these operations fail (which is
	 * unlikely) then the exception is caught and getInput() is called recursively.
	 * 
	 * @return str - String - trimmed user input.
	 */
	private static String getInput()
	{
		System.out.println("Input date in format MM/DD/YYYY:\n");
		String str = "";
		try
		{
			str = inp.nextLine();
			str = str.trim();
		}
		// unlikely to catch any exceptions, but just in case.
		catch (Exception e)
		{
			System.out.println(e.getMessage() + ": INVALID INPUT PLEASE TRY AGAIN\n");
			str = getInput();
		}
		return str;
	}

	/**
	 * receives the date as MM/DD/YYYY and parses the year from the string, checks
	 * if it is within the acceptable range of 1000 to 3000 and then is returned as
	 * an integer.
	 * 
	 * @param date - String MM/DD/YYYY formatted date.
	 * @return year - int - numerical year parsed from user input.
	 */
	private static int getYear(String date)
	{
		int year = 0;
		try
		{
			// year parsed from input string.
			// will throw an error if there is not numeric value in string date
			year = Integer.valueOf(date.substring(6, 10));

			// only years from 1000 to 3000 are reasonable
			if (year < 1000 || year > 3000)
			{
				throw new YearException("Year value is out of bounds\n");
			}
		}
		// if date is out of bounds (but still acceptable numerical data) the error is
		// caught here
		catch (YearException e2)
		{
			System.err.println(e2.getMessage() + "\n");

			// get year is called recursively after a new year value is collected
			date = newYear();
			year = getYear(date);
		}
		// if the substring of date taken is not numerical, then it is caught here. and
		// YearException is thrown as well anyway
		catch (Exception e)
		{
			try
			{
				throw new YearException();
			}
			catch (YearException e1)
			{
				System.err.println(e1.getMessage() + " :: " + e.getMessage() + "\n");

				date = newYear();
				year = getYear(date);
			}
		}
		return year;
	}

	/**
	 * if error message is called in getYear(), then newYear is called to get a new
	 * year value and put it through getYear() recursively.
	 * 
	 * @return String - date format with just the Year value filled in.
	 */
	private static String newYear()
	{
		System.out.println("PLEASE INPUT A NEW YEAR\n(1000 to 3000 accepted):");

		String temp = inp.nextLine();

		if (temp.length() != 4)
		{
			temp = "0000";
		}
		// new 'date' because getYear function doesnt use month or day.
		return "--/--/" + temp;
	}

	/**
	 * receives the date as MM/DD/YYYY and parses the month from the string, checks
	 * if it is within the acceptable range depending on month and then is returned
	 * as an integer.
	 * 
	 * @param date - String MM/DD/YYYY formatted date.
	 * @return month - int - numerical integer parsed from user input.
	 */
	private static int getMonth(String date)
	{

		int month = 0;
		try
		{
			// month parsed from input string.
			// will throw an error if there is not numeric value in string
			month = Integer.valueOf(date.substring(0, 2));

			// month must be between 1 through 12
			if (month > 12 || month <= 0)
			{
				throw new MonthException("Month value is out of bounds\n");
			}
		}
		// caatches exception if numerical month input is not an integer between (or
		// equal to) 1 through 12.
		catch (MonthException e2)
		{
			System.err.println(e2.getMessage() + "\n");
			// new month input is taken and getMonth is called recursively using that month
			date = newMonth();
			month = getMonth(date);
		}
		// catches an error if date year substring is not numeric
		catch (Exception e)
		{
			try
			{
				throw new MonthException();
			}
			catch (MonthException e1)
			{
				System.err.println(e1.getMessage() + " :: " + e.getMessage() + "\n");
				date = newMonth();
				month = getMonth(date);
			}
		}

		return month;
	}

	/**
	 * In the case of an exception being thrown, a new month input is needed and
	 * this function is called so it's return value string can be used in the
	 * recursive calle of getMonth()
	 * 
	 * @return String - new month inputted by user in a MM/DD/YYYY format
	 */
	private static String newMonth()
	{
		System.out.println("PLEASE INPUT A NEW MONTH\n(January is '1', February is '2',... December is '12'):\n");
		String temp = inp.nextLine();

		if (temp.length() == 1) // if the input is single-digit
		{
			temp = "0" + temp;
		}
		else if (temp.length() >= 3) // if the input is greater than 3 digits
		{
			temp = "00";
		}

		return temp + "/--/----";
	}

	/**
	 * the getDay method is given the date string and a previously parsed month and
	 * year as integers. The integer value of the day given in input is parsed from
	 * the string and checked to see if it is valid taking into account month, year
	 * and potential leap years.
	 * 
	 * @param date  - String - MM/DD/YYYY formatted date input
	 * @param month - int - month previously parsed from date string
	 * @param year  - int - year previously parsed from date string
	 * @return day - int - integer value of day parsed from date
	 */
	private static int getDay(String date, int month, int year)
	{

		int day = 0;
		try
		{
			// throws an exception if substring is not an integer compatible value
			day = Integer.valueOf(date.substring(3, 5));

			// if month has 31 days
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				if (day > 31 || day <= 0)
				{

					throw new DayException("Day value is out of bounds\n");
				}
			}
			// if month has 30 days
			else if (month == 4 || month == 6 || month == 9 || month == 11)
			{
				if (day > 30 || day <= 0)
				{

					throw new DayException("Day value is out of bounds\n");
				}
			}
			// february accounting for leap years
			else if (month == 2)
			{
				if (year % 4 == 0)
				{
					if (day > 29 || day <= 0)
					{
						throw new DayException("Day value is out of bounds\n");
					}
				}
				else if (day > 28 || day <= 0)
				{
					throw new DayException("Day value is out of bounds\n");
				}
			}

		}
		// catches DayException, thrown if integer day is out of bounds
		catch (DayException e2)
		{
			System.err.println(e2.getMessage() + "\n");
			date = newDay();
			day = getDay(date, month, year);
		}
		// if day can't be parsed from the string successfully, it is caught here.
		catch (Exception e)
		{
			try
			{
				throw new DayException();
			}
			catch (DayException e1)
			{
				System.err.println(e1.getMessage() + " :: " + e.getMessage() + "\n");
				date = newDay();
				day = getDay(date, month, year);
			}
		}
		return day;
	}

	/**
	 * newDay method is called to collect a new Day input as integer if the getDay
	 * method throws an exception
	 * 
	 * @return String - user input day in MM/DD/YYYY format (with just the day value
	 *         with rest as '-'s)
	 */
	private static String newDay()
	{
		System.out.println("PLEASE INPUT A NEW DAY\n(1 through 31 are accepted depending on the month):");

		String temp = inp.nextLine();

		if (temp.length() == 1)
		{
			temp = "0" + temp;
		}
		else if (temp.length() >= 3)
		{
			temp = "00";
		}

		return "--/" + temp + "/----";
	}

}
