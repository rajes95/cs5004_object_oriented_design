package shapes;

/**
 * 
 * This Cube class is a child class of ThreeDimentionalShape. It has double
 * length private variable.
 * 
 * It implements the getArea and getVolume method from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Cube extends ThreeDimentionalShape
{

	private double length;

	/**
	 * Constructor for Cube class uses length parameter to set edge length for this
	 * cube object
	 * 
	 * @param length - double - length of cube edge
	 */
	public Cube(double length)
	{
		this.setLength(length);
	}

	/**
	 * default constructor for Cube class sets length to 0.
	 */
	public Cube()
	{
		this.setLength(0);
	}

	/**
	 * returns the length of an edge of this cube object
	 * 
	 * @return length - double - current length of cube edge
	 */
	public double getLength()
	{
		return length;
	}

	/**
	 * sets the parameter length as the length of the cube edge for this object
	 * 
	 * @param length - double - new length of cube edge
	 */
	public void setLength(double length)
	{
		if (length < 0)
		{
			System.err.println("Invalid Length for side of Cube");
			System.exit(-1);
		}

		this.length = length;
	}

	/**
	 * returns the area of a Cube as a double value using the edge length value
	 * 
	 * @return double - area of cube
	 */
	public double getArea()
	{
		return this.getLength() * this.getLength() * 6;
	}

	/**
	 * returns the volume of a Cube as a double value using the edge length value
	 * 
	 * @return double - volume of cube
	 */
	public double getVolume()
	{
		return this.getLength() * this.getLength() * this.getLength();
	}

	/**
	 * returns cube's edge length as a string. For use in print statements
	 */
	public String toString()
	{
		return "Cube edge Length: " + this.getLength();
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
		if (!(o instanceof Cube))
		{
			return false;
		}
		Cube cub = (Cube) o;

		return this.getLength() == cub.getLength();

	}
	
}
