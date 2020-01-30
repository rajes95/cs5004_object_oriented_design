package cs5004_hw8_problem2;

import java.util.Scanner;

/**
 * This Calculator class allows the creation of a calculator object that can
 * either be manipulated by calling the add(), subtract(), multiply() and
 * divide() methods or by calling run() and allowing manipulation through user
 * input.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/23/2019
 */
public class Calculator
{
	// class-wide scanner for user input which is closed at the end of run()
	private static Scanner sc = new Scanner(System.in);

	// result is modified by the +,-,*,/ methods or by user input through run
	private double result;

	/**
	 * This is the default and only constructor for the Calculator class. Prints out
	 * that the calculator is on and sets result to the default value of 0.
	 */
	public Calculator()
	{
		System.out.println("Calculator is on.");
		this.setResult(0);
	}

	/**
	 * returns the current value of result
	 * 
	 * @return - result - double - current value held by calculator
	 */
	public double getResult()
	{
		return result;
	}

	/**
	 * sets the value of result to the value of the given double parameter.
	 * 
	 * @param result - double - new result value to be set
	 */
	public void setResult(double result)
	{
		this.result = result;
	}

	/**
	 * multiplies the current result value with the parameter num
	 * 
	 * @param num - double - multiplied by current result for new result value
	 */
	public void multiply(double num)
	{
		this.setResult(this.getResult() * num);
		System.out.printf("result * %.1f = %.1f\n", num, this.getResult());
		System.out.printf("updated result = %.1f\n", this.getResult());
	}

	/**
	 * divides the current result value by the parameter num
	 * 
	 * @param num - double - divides the current result for new result value
	 */
	public void divide(double num)
	{
		this.setResult(this.getResult() / num);
		System.out.printf("result / %.1f = %.1f\n", num, this.getResult());
		System.out.printf("updated result = %.1f\n", this.getResult());
	}

	/**
	 * adds the current result value to the parameter num
	 * 
	 * @param num - double - added to current result for new result value
	 */
	public void add(double num)
	{
		this.setResult(this.getResult() + num);
		System.out.printf("result + %.1f = %.1f\n", num, this.getResult());
		System.out.printf("new result = %.1f\n", this.getResult());
	}

	/**
	 * subtracts from the current result value the parameter num
	 * 
	 * @param num - double - subtracted from current result for new result value
	 */
	public void subtract(double num)
	{
		this.setResult(this.getResult() - num);
		System.out.printf("result - %.1f = %.1f\n", num, this.getResult());
		System.out.printf("new result = %.1f\n", this.getResult());
	}

	/**
	 * run() can be called to interact with calculator through user input. Each
	 * cycle allows the user to repeatedly add, subtract, multiply, or divide by a
	 * second number. The calculation ends when the user enters the letter R for
	 * “result” (either in upper- or lowercase). The user is allowed to do another
	 * calculation from the beginning as often as desired. Any and all output is
	 * printed to console screen.
	 */
	public void run()
	{
		// should print result as 0 here, but can be manipulated before calling run() so
		// it is different.
		System.out.printf("result = %.1f\n", this.getResult());

		// takes unprompted user input for mathematical operation to perform
		String input = sc.nextLine();
		input = input.trim();

		while (!(input.equals("r") || input.equals("R")))
		{
			try
			{
				// first character string of the input is tried to evaluate as the operator
				if (input.substring(0, 1).equals("+"))
				{
					// the rest of the string is tried to evaluate as a double value
					this.add(Double.parseDouble(input.substring(1, input.length())));
				}
				else if (input.substring(0, 1).equals("-"))
				{
					this.subtract(Double.parseDouble(input.substring(1, input.length())));
				}
				else if (input.substring(0, 1).equals("*"))
				{
					this.multiply(Double.parseDouble(input.substring(1, input.length())));
				}
				else if (input.substring(0, 1).equals("/"))
				{
					double divisor = Double.parseDouble(input.substring(1, input.length()));
					this.divide(divisor);
				}
				else
				{
					// thrown if none of the accepted operators are called
					throw new UnknownOperatorException(input.substring(0, 1) + " is an unknown operation.");
				}
				// takes unprompted input again in a loop
				input = sc.nextLine();
				input = input.trim();
			}
			// custom Exception caught if operator is invalid
			catch (UnknownOperatorException e)
			{
				System.out.println(e.getMessage());
				System.out.println("Reenter, your last line:");
				input = sc.nextLine();
				input = input.trim();
			}
			// if substring after operator fails to evaluate as a double it is caught here
			catch (NumberFormatException n)
			{
				System.out.println(n.getMessage() + " is not a number.");
				System.out.println("Reenter, your last line:");
				input = sc.nextLine();
				input = input.trim();
			}
		}
		// prints final result and allows potential recursive calling of run().
		System.out.printf("Final result = %.1f\n", this.getResult());
		System.out.println("Again? (y/n)");
		input = againInput();
		sc.close();
	}

	/**
	 * input is taken for whether or not the user wants to reset and run the
	 * calculator again
	 * 
	 * @return input - String - user input, yes or no to restart calculator
	 */
	private String againInput()
	{
		String input = "";
		try
		{
			input = sc.nextLine();
			input = input.trim();

			// user inputs yes
			if (input.substring(0, 1).equals("y") || input.substring(0, 1).equals("Y"))
			{
				this.setResult(0);
				run();
			}
			// user inputs no
			else if (input.substring(0, 1).equals("n") || input.substring(0, 1).equals("N"))
			{
				System.out.println("End of Program");
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
			System.out.println("Again?(y/n)");
			againInput();
		}
		return input;
	}
}