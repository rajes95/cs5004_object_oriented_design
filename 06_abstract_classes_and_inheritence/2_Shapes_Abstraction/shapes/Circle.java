package shapes;

/**
 * 
 * This Circle class is a child class of TwoDimentionalShape. It has double
 * radius private variable.
 * 
 * It implements the getArea method from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Circle extends TwoDimentionalShape
{

	private double radius;

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
	 * default constructor for Circle class sets radius to 0.
	 */
	public Circle()
	{
		this.setRadius(0);
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
			System.err.println("Invalid Radius for Circle");
			System.exit(-1);
		}
		this.radius = radius;
	}

	/**
	 * returns the area of a circle as a double value using the radius value
	 * 
	 * @return double - area of circle
	 */
	public double getArea()
	{
		return this.getRadius() * this.getRadius() * 3.14159;
	}

	/**
	 * returns circle's radius as a string. For use in print statements
	 */
	public String toString()
	{
		return "Circle Radius: " + this.getRadius();
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
		if (!(o instanceof Circle))
		{
			return false;
		}
		Circle cir = (Circle) o;

		return this.getRadius() == cir.getRadius();

	}

}
