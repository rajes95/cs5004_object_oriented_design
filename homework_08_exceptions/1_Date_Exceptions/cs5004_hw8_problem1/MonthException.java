package cs5004_hw8_problem1;

/**
 * This class is an Exceeption (extends Exception class) and it is thrown when
 * month input in Problem_1.java is invalid/ out of bounds
 * 
 * @author Rajesh Sakhamuru
 * @version 7/22/2019
 *
 */
@SuppressWarnings("serial")
public class MonthException extends Exception
{
	/**
	 * Month exception default constructor with invalid message
	 */
	public MonthException()
	{
		super("Month input is invalid");
	}

	/**
	 * Month exception constructor with custom message
	 * 
	 * @param message - custom error message for MonthException
	 */
	public MonthException(String message)
	{
		super(message);
	}
}