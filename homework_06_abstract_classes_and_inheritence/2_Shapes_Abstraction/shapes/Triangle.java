package shapes;

/**
 * 
 * This Triangle class is a child class of TwoDimentionalShape. It has double
 * base and double height private variables.
 * 
 * It implements the getArea method from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Triangle extends TwoDimentionalShape
{

	private double base;
	private double height;

	/**
	 * Constructor for Triangle class uses base and height parameters to set base
	 * and height for this object
	 * 
	 * @param base   - double - base length of triangle
	 * @param height - double - height of triangle
	 */
	public Triangle(double base, double height)
	{
		this.setBase(base);
		this.setHeight(height);
	}

	/**
	 * default constructor for Triangle class sets base and hight to 0.
	 */
	public Triangle()
	{
		this.setBase(0);
		this.setHeight(0);
	}

	/**
	 * returns the base length of this triangle object
	 * 
	 * @return base - double - current base length
	 */
	public double getBase()
	{
		return base;
	}

	/**
	 * sets the parameter base as the base length of the triangle for this object
	 * 
	 * @param base - double - new base length
	 */
	public void setBase(double base)
	{
		if (base < 0)
		{
			System.err.println("Invalid Base for Triangle");
			System.exit(-1);
		}
		this.base = base;
	}

	/**
	 * returns height of this triangle
	 * 
	 * @return height - double - current triangle height
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * sets the parameter height as the height of the triangle for this object
	 * 
	 * @param height - double - new height of triangle
	 */
	public void setHeight(double height)
	{
		if (height < 0)
		{
			System.err.println("Invalid Height for Triangle");
			System.exit(-1);
		}
		this.height = height;
	}

	/**
	 * returns the area of a triangle as a double value using base and height values
	 * 
	 * @return double - area of triangle
	 */
	public double getArea()
	{
		return this.getBase() * this.getHeight() / 2;
	}

	/**
	 * returns triangle's base and height as a string. For use in print statements
	 */
	public String toString()
	{
		return "Triangle Base: " + this.getBase() + "\nTriangle Height: " + this.getHeight();
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
		if (!(o instanceof Triangle))
		{
			return false;
		}
		Triangle tri = (Triangle) o;

		return this.getBase() == tri.getBase() && this.getHeight() == tri.getHeight();

	}

}
