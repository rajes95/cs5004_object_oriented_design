package cs5004_hw8_problem1;

/**
 * This class is an Exceeption (extends Exception class) and it is thrown when
 * year input in Problem_1.java is invalid/ out of bounds
 * 
 * @author Rajesh Sakhamuru
 * @version 7/22/2019
 *
 */
@SuppressWarnings("serial")
public class YearException extends Exception
{
	/**
	 * Year exception default constructor with invalid message
	 */
	public YearException()
	{
		super("Year input is invalid");
	}

	/**
	 * Year exception constructor with custom message
	 * 
	 * @param message - custom error message for YearException
	 */
	public YearException(String message)
	{
		super(message);
	}
}
