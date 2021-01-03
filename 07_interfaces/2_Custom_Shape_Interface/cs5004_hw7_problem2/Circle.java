package cs5004_hw7_problem2;

import java.security.InvalidParameterException;

/**
 * 
 * This Circle class implements Shape. It has double radius private variable.
 * 
 * It implements the Area method from Shape.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/13/2019
 *
 */
public class Circle implements Shape
{
	private double radius;

	/**
	 * default constructor for Circle class sets radius to 0.
	 */
	public Circle()
	{
		this.setRadius(0);
	}

	/**
	 * Constructor for Circle class uses radus parameter to set radius for this
	 * circle object
	 * 
	 * @param radius - double - radius of circle
	 */
	public Circle(double radius)
	{
		this.setRadius(radius);
	}

	/**
	 * returns the radius length of this circle object
	 * 
	 * @return radius - double - current radius length
	 */
	public double getRadius()
	{
		return radius;
	}

	/**
	 * sets the parameter radus as the radius of the circle for this object
	 * 
	 * @param radius - double - new radius length
	 */
	public void setRadius(double radius)
	{
		if (radius < 0)
		{
			throw new InvalidParameterException("ERROR: negative radius is invalid.");
		}
		this.radius = radius;
	}

	/**
	 * returns the area of a circle as a double value using the radius value
	 * 
	 * @return double - area of circle
	 */
	public double area()
	{
		return 3.14159 * this.getRadius() * this.getRadius();
	}

	/**
	 * returns circle's radius as a string. For use in print statements
	 */
	public String toString()
	{
		String str = "";
		str += "Circle radius: " + this.getRadius();

		return str;
	}

	/**
	 * compares the parameter object to this object to determine whether they are
	 * equal or not. returns true if they are equal, otherwise false.
	 * 
	 * @return boolean - true or false if objects are equal or not.
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o.getClass() == Circle.class))
		{
			return false;
		}
		Circle circ = (Circle) o;

		return (this.getRadius() == circ.getRadius());
	}

}
