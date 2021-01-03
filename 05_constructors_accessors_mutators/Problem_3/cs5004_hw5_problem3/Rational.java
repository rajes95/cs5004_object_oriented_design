package cs5004_hw5_problem3;

/**
 * 
 * This class represents objects that are Rational numbers (consisting of
 * integer numerator and denominator fraction). The class has methods that allow
 * addition, subtraction, multiplication and division. A toString() class and
 * equals() class are also included.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 *
 */
public class Rational
{
	private int numer;
	private int denom;

	/**
	 * Constructor for Rational class that takes a numerator AND denominator for a
	 * rational number and sets both of their values to the private variables in
	 * this class
	 * 
	 * @param numer - int - rational number numerator
	 * @param denom - int - rational number denominator
	 */
	public Rational(int numer, int denom)
	{
		this.setNumer(numer);
		this.setDenom(denom);
	}

	/**
	 * Constructor that allows a single integer parameter which is used as a whole
	 * rational number and the denominator defaults to 1.
	 * 
	 * @param whole - int - integer value of the rational number
	 */
	public Rational(int whole)
	{
		this.setNumer(whole);
		this.setDenom(1);
	}

	/**
	 * Constructor for Rational class. If no parameters are given this one is used
	 * and numerator and denominator are both set to 0.
	 */
	public Rational()
	{
		this.setNumer(0);
		this.setDenom(0);
	}

	/**
	 * This equals method compares a Rational object with the "this" Rational object
	 * to see if their numerical values are equal.
	 * 
	 * @param other - Rational - object which translates to a rational number value.
	 * @return equal - boolean - returns true or false depending on whether other
	 *         and "this" Rational objects are equivalent numerical values.
	 */
	public boolean equals(Rational other)
	{
		boolean equal = false;

		if (other == null)
		{
			return equal;
		}

		if (other.getDenom() == 0 || this.getDenom() == 0)
		{
			System.err.println("ERROR: DIVIDE-BY-ZERO ERROR");
			return equal;
		}
		double otherValue = other.getNumer() / (double) other.getDenom();
		double thisValue = this.getNumer() / (double) this.getDenom();

		if (otherValue == thisValue)
		{
			equal = true;
		}

		return equal;
	}

	/**
	 * toString() overrides the system toString call in print statements
	 * 
	 * output format is "numerator/denominator"
	 * 
	 * @return str - String - string representation of Rational object
	 */
	public String toString()
	{
		String str = "";
		str += numer + "/" + denom;
		return str;
	}

	/**
	 * This method subtracts the value of the "other" Rational object from the
	 * "this" Rational object and returns the difference as a "difference" rational
	 * object
	 * 
	 * @param other - Rational - value of other is subtracted from "this" object
	 * @return difference - Rational - value of difference between "other" and
	 *         "this"
	 */
	public Rational subtract(Rational other)
	{
		int diffNumer = (getNumer() * other.getDenom()) - (getDenom() * other.getNumer());
		int diffDenom = (getDenom() * other.getDenom());

		Rational difference = new Rational(diffNumer, diffDenom);
		difference.normalize();
		return difference;
	}

	/**
	 * This method adds the value of the "other" Rational object with the "this"
	 * Rational object and returns the sum as a "sum" rational object
	 * 
	 * @param other - Rational - value of other is added to "this" object
	 * @return sum - Rational - value of sum of "other" and "this"
	 */
	public Rational add(Rational other)
	{
		int sumNumer = (getNumer() * other.getDenom()) + (getDenom() * other.getNumer());
		int sumDenom = (getDenom() * other.getDenom());

		Rational sum = new Rational(sumNumer, sumDenom);
		sum.normalize();
		return sum;
	}

	/**
	 * This method multiplies the value of the "other" Rational object with the
	 * "this" Rational object and returns the product as a "product" rational object
	 * 
	 * @param other - Rational - value of other is multiplied with value of "this"
	 *              object
	 * @return product - Rational - value of product between "other" and "this"
	 */
	public Rational multiply(Rational other)
	{
		int multNumer = (getNumer() * other.getNumer());
		int multDenom = (getDenom() * other.getDenom());

		Rational product = new Rational(multNumer, multDenom);
		product.normalize();
		return product;
	}

	/**
	 * This method divides the value of the "this" object from the "other" Rational
	 * object and returns the quotient as a "quotient" rational object
	 * 
	 * @param other - Rational - value of "this" is divided by value of "other"
	 *              object
	 * @return quotient - Rational - value of "this" divided by "other"
	 */
	public Rational divide(Rational other)
	{
		int divNumer = (getNumer() * other.getDenom());
		int divDenom = (getDenom() * other.getNumer());

		Rational quotient = new Rational(divNumer, divDenom);
		quotient.normalize();
		return quotient;
	}

	/**
	 * If a function has a negative denominator, this function moves the negative
	 * sign to the numerator, keeping the same overall value of the Rational object
	 */
	public void normalize()
	{
		if (this.getDenom() < 0)
		{
			this.setDenom(this.getDenom() * (-1));
			this.setNumer(this.getNumer() * (-1));
		}
	}

	/**
	 * gets and returns value of this object's numerator
	 * 
	 * @return numer - int - numarator of rational number
	 */
	public int getNumer()
	{
		return numer;
	}

	/**
	 * sets new numerator for the rational number
	 * 
	 * @param numer - int - new numrator value to be set
	 */
	public void setNumer(int numer)
	{
		this.numer = numer;
	}

	/**
	 * gets rational number's current denominator
	 * 
	 * @return denom - int - current object's denominator
	 */
	public int getDenom()
	{
		return denom;
	}

	/**
	 * sets new denominator value in Rational object
	 * 
	 * @param denom - int - new value to be denominator of this rational number
	 */
	public void setDenom(int denom)
	{
		this.denom = denom;
	}

}
