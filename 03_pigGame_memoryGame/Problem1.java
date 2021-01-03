/**
 * @author Rajesh Sakhamuru
 * @version 5/31/2019
 * 
 * This program is an e^x approximation calculator.
 * Takes as command line arguments a value of x and n.
 * 
 * The higher the value of n, the better the approximation of e^x.
 * 
 * */

public class Problem1
{
	/**
	 * This program takes as command line arguments a Double value of x
	 * and an Integer value of n, and approximates the value of e^x.
	 * The higher the value of n, the more accurate the calculated value
	 * of e^x is.
	 * */
	public static void main(String[] args)
	{
		double x = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		double eApprox = 1;
		for (int p = 1; p <= n; p++)
		{
			double tempExp = 1;
			double tempFactorial = 1;
			for (int c = 1; c <= p; c++)
			{
				tempExp *= x;
				tempFactorial *= c;
			}
			eApprox += tempExp / tempFactorial;
		}
		System.out.printf("Approximate value of e^(%.3f) at n=%d is: %.10f\n", x, n, eApprox);
		System.out.printf("Actual value of e^(%.3f): %.10f\n", x, Math.pow(2.718281828459045, x));
	}
}
