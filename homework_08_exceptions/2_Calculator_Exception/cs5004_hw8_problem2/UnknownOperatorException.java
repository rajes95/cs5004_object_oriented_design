package cs5004_hw8_problem2;

/**
 * This class is an Exceeption (extends Exception class) and it is thrown when
 * operator input in Calculator.java is invalid.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/22/2019
 *
 */
@SuppressWarnings("serial")
public class UnknownOperatorException extends Exception
{
	/**
	 * UnknownOperatorException default constructor with invalid message
	 */
	public UnknownOperatorException()
	{
		super("ERROR: UNKNOWN OPERATOR EXCEPTION");
	}

	/**
	 * UnknownOperatorException constructor with custom message
	 * 
	 * @param message - custom error message for UnknownOperatorException
	 */
	public UnknownOperatorException(String message)
	{
		super(message);
	}

}