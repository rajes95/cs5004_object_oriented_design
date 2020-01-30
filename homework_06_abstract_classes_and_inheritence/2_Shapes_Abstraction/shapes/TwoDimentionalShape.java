package shapes;

/**
 * 
 * This is a child class of the Shape class.
 * 
 * It is an abstract class and only contains 1 method, getArea, which is
 * implimented through it's child classes which are 2D shapes
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public abstract class TwoDimentionalShape extends Shape
{

	/**
	 * Can be implemented by the child classes of TwoDimentionalShape class
	 * 
	 * @return double - area of the shape implementing this function
	 */
	public abstract double getArea();

}
