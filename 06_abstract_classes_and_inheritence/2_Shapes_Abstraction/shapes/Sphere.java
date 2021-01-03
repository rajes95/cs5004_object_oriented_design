package shapes;

/**
 * 
 * This Sphere class is a child class of ThreeDimentionalShape. It has double
 * radius private variable.
 * 
 * It implements the getArea and getVolume methods from its parent class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Sphere extends ThreeDimentionalShape
{

	private double radius;

	/**
	 * Constructor for Sphere class uses radus parameter to set radius for this
	 * sphere object
	 * 
	 * @param radius - double - radius of sphere
	 */
	public Sphere(double radius)
	{
		this.setRadius(radius);
	}

	/**
	 * default constructor for Sphere class sets radius to 0.
	 */
	public Sphere()
	{
		this.setRadius(0);
	}

	/**
	 * returns the radius length of this sphere object
	 * 
	 * @return radius - double - current radius length
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * sets the parameter radus as the radius of the sphere for this object
	 * 
	 * @param radius - double - new radius length
	 */
	public void setRadius(double radius)
	{
		if (radius < 0)
		{
			System.err.println("Invalid Radius for Sphere");
			System.exit(-1);
		}
		this.radius = radius;
	}

	/**
	 * returns the surface area of a sphere as a double value using the radius value
	 * 
	 * @return double - area of sphere
	 */
	public double getArea()
	{
		return this.getRadius() * this.getRadius() * 3.14159 * 4;
	}

	/**
	 * returns the volume of a sphere as a double value using the radius value
	 * 
	 * @return double - volume of sphere
	 */
	public double getVolume()
	{
		return this.getRadius() * this.getRadius() * this.getRadius() * 3.14159 * 4 / 3;
	}

	/**
	 * returns sphere's radius as a string. For use in print statements
	 */
	public String toString()
	{
		return "Sphere Radius: " + this.getRadius();
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
		if (!(o instanceof Sphere))
		{
			return false;
		}
		Sphere sph = (Sphere) o;

		return this.getRadius() == sph.getRadius();

	}
}
