import cs5004_hw5_problem3.Rational;

/**
 * This class is testing the Rational class which is located in the
 * cs5004_hw5_problem3 package. The tests are run in main and methods are called
 * on 7 different rational fractions which are initialized.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 *
 */
public class problem_3
{
	/**
	 * The Rational class is tested in this main() by creating 7 varied Rational objects
	 * The mathematical operators and other methods created in that class are tested
	 * using these objects
	 * 
	 * @param args - String[] - not used
	 */
	public static void main(String[] args)
	{
		Rational frac1 = new Rational(1, 2);
		Rational frac2 = new Rational(1, -4);
		Rational frac3 = new Rational(-3, 7);
		Rational frac4 = new Rational(-22, -7);
		Rational frac5 = new Rational(44, 14);
		Rational frac6 = new Rational(5);
		Rational frac7 = new Rational();

//		test math operators
		System.out.println("Check math manually:");
		System.out.println("(1/2) + (-3/7)   = " + frac1.add(frac3));
		System.out.println("(1/-4) + (44/14) = " + frac2.add(frac5));
		System.out.println("(1/2) - (1/-4)   = " + frac1.subtract(frac2));
		System.out.println("(-3/7) - (-22/-7)= " + frac3.subtract(frac4));
		System.out.println("(-3/7) * (1/2)   = " + frac3.multiply(frac1));
		System.out.println("(1/-4) * (-3/7)  = " + frac2.multiply(frac3));
		System.out.println("(-3/7) / (1/2)   = " + frac3.divide(frac1));
		System.out.println("(1/-4) / (5/1)   = " + frac2.divide(frac6) + "\n");

//		test normalize
		System.out.println("Before normalizing: " + frac2);
		frac2.normalize();
		System.out.println("After normalizing : " + frac2);
		System.out.println("Before normalizing: " + frac4);
		frac4.normalize();
		System.out.println("After normalizing : " + frac4);
		System.out.println("Before normalizing: " + frac3);
		frac3.normalize();
		System.out.println("After normalizing : " + frac3);
		System.out.println("Before normalizing: " + frac1);
		frac1.normalize();
		System.out.println("After normalizing : " + frac1);

//		test equals
		System.out.println("\n22/7 == 44/14 : " + frac4.equals(frac5));
		System.out.println("22/7 == -3/7  : " + frac4.equals(frac3));

//		test empty constructor 
		System.out.println("\nShould be 0/0: " + frac7);

	}
}
