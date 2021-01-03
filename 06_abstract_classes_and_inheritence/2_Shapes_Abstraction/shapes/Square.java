package shapes;

/**
 * 
 * This Square class is a child class of TwoDimentionalShape. It has double
 * length private variable.
 * 
 * It implements the getArea method from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Square extends TwoDimentionalShape
{

	private double length;

	/**
	 * Constructor for Square class uses length parameter to set length for this
	 * square object
	 * 
	 * @param length - double - length of square
	 */
	public Square(double length)
	{
		this.setLength(length);
	}

	/**
	 * default constructor for Square class sets length to 0.
	 */
	public Square()
	{
		this.setLength(0);
	}

	/**
	 * returns the length of an edge of this square object
	 * 
	 * @return length - double - current length of square edge
	 */
	public double getLength()
	{
		return length;
	}

	/**
	 * sets the parameter length as the length of the square edge for this object
	 * 
	 * @param length - double - new length of square edge
	 */
	public void setLength(double length)
	{
		if (length < 0)
		{
			System.err.println("Invalid Length for side of Square");
			System.exit(-1);
		}

		this.length = length;
	}

	/**
	 * returns the area of a Square as a double value using the edge length value
	 * 
	 * @return double - area of square
	 */
	public double getArea()
	{
		return this.getLength() * this.getLength();
	}

	/**
	 * returns square's edge length as a string. For use in print statements
	 */
	public String toString()
	{
		return "Square edge Length: " + this.getLength();
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
		if (!(o instanceof Square))
		{
			return false;
		}
		Square squ = (Square) o;

		return this.getLength() == squ.getLength();

	}
}
