package cs5004_hw7_problem2;

import java.security.InvalidParameterException;

/**
 * 
 * This Rectangle class implements Shape. It has double height and width as
 * private variables.
 * 
 * It implements the Area method from Shape.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/13/2019
 *
 */
public class Rectangle implements Shape
{
	private double height;
	private double width;

	/**
	 * Constructor for Rectangle class uses height and width parameters to set the
	 * two for this Rectangle object
	 * 
	 * @param height - double - height of rectangle
	 * @param width  - double - width of rectangle
	 */
	public Rectangle(double height, double width)
	{
		this.setHeight(height);
		this.setWidth(width);
	}

	/**
	 * default constructor for Rectangle class sets height and width to 0.
	 */
	public Rectangle()
	{
		this.setHeight(0);
		this.setWidth(0);
	}

	/**
	 * returns the height of the Rectangle
	 * 
	 * @return height - double - current height
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * sets the parameter height as the height of the rectangle
	 * 
	 * @param height - double - new height length
	 */
	public void setHeight(double height)
	{
		if (height < 0)
		{
			throw new InvalidParameterException("ERROR: negative height is invalid.");
		}
		this.height = height;
	}

	/**
	 * returns the width of the Rectangle
	 * 
	 * @return width - double - current width
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * sets the parameter width as the width of the rectangle
	 * 
	 * @param width - double - new width length
	 */
	public void setWidth(double width)
	{
		if (width < 0)
		{
			throw new InvalidParameterException("ERROR: negative width is invalid.");
		}
		this.width = width;
	}

	/**
	 * returns the area of the rectangle as a double value
	 * 
	 * @return double - area of this rectangle
	 */
	public double area()
	{
		return this.getWidth() * this.getHeight();
	}

	/**
	 * returns rectangle's height and width as a string. For use in print statements
	 */
	public String toString()
	{
		String str = "";
		str += "Rectangle height: " + this.getHeight() + ", width: " + this.getWidth();

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
		if (!(o.getClass() == Rectangle.class))
		{
			return false;
		}
		Rectangle rect = (Rectangle) o;

		return (this.getHeight() == rect.getHeight()) && (this.getWidth() == rect.getWidth());
	}

}
