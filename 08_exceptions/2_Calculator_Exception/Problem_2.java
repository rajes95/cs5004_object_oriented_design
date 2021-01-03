import cs5004_hw8_problem2.Calculator;

/**
 * Problem_2.java
 *
 * This program serves as a simple calculator. It keeps track of a single number
 * (double) which is called result (in class Calculator) and starts as 0.
 * 
 * Each cycle allows the user to repeatedly add, subtract, multiply, or divide
 * by a second number.
 * 
 * If the user enters any operator symbol other than +, −, *, or /, then an
 * UnknownOperatorException is thrown and the user is asked to reenter that line
 * of input.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/23/2019
 * 
 */
public class Problem_2
{

	/**
	 * This main creates a calculator object which keeps track of a single number in
	 * the integer 'result' in the class. Then, the Calculator object is 'run()'
	 * which allows the calculator to be manipulated through user input.
	 * 
	 * @param args - not used
	 */
	public static void main(String[] args)
	{
		Calculator calc = new Calculator();
		calc.run();

	}
}
