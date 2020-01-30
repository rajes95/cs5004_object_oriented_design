package shapes;

/**
 * 
 * This Tetrahedron class is a child class of ThreeDimentionalShape. It has
 * double length private variable.
 * 
 * It implements the getArea and getVolume method from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Tetrahedron extends ThreeDimentionalShape
{

	private double length;

	/**
	 * Constructor for Tetrahedron class uses length parameter to set edge length
	 * for this tetrahedron object
	 * 
	 * @param length - double - length of tetrahedron edge
	 */
	public Tetrahedron(double length)
	{
		this.setLength(length);
	}

	/**
	 * default constructor for Tetrahedron class sets length to 0.
	 */
	public Tetrahedron()
	{
		this.setLength(0);
	}

	/**
	 * returns the length of an edge of this tetrahedron object
	 * 
	 * @return length - double - current length of tetrahedron edge
	 */
	public double getLength()
	{
		return length;
	}

	/**
	 * sets the parameter length as the length of the tetrahedron edge for this object
	 * 
	 * @param length - double - new length of tetrahedron edge
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
	 * returns the area of a Tetrahedron as a double value using the edge length value
	 * 
	 * @return double - area of tetrahedron
	 */
	public double getArea()
	{
		return this.getLength() * this.getLength() * 1.73205080757;
	}

	/**
	 * returns the volume of a Tetrahedron as a double value using the edge length value
	 * 
	 * @return double - volume of tetrahedron
	 */
	public double getVolume()
	{
		return this.getLength() * this.getLength() * this.getLength() * 0.11785113019;
	}

	/**
	 * returns cube's edge length as a string. For use in print statements
	 */
	public String toString()
	{
		return "Tetrahedron edge Length: " + this.getLength();
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
		if (!(o instanceof Tetrahedron))
		{
			return false;
		}
		Tetrahedron tet = (Tetrahedron) o;

		return this.getLength() == tet.getLength();

	}
}
