package cs5004_hw8_problem1;

/**
 * This class is an Exceeption (extends Exception class) and it is thrown when
 * day input in Problem_1.java is invalid/ out of bounds
 * 
 * @author Rajesh Sakhamuru
 * @version 7/22/2019
 *
 */
@SuppressWarnings("serial")
public class DayException extends Exception
{
	/**
	 * Day exception default constructor with invalid message
	 */
	public DayException()
	{
		super("Day input is invalid");
	}

	/**
	 * Day exception constructor with custom message
	 * 
	 * @param message - custom error message for DayException
	 */
	public DayException(String message)
	{
		super(message);
	}
}