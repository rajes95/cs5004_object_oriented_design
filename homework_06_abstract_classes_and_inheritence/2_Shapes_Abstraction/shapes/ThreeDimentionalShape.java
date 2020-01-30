package shapes;

/**
 * 
 * This is a child class of the Shape class.
 * 
 * It is an abstract class and only contains 2 methods, getArea and getVolume, which are
 * implimented through its child classes which are 3D shapes
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public abstract class ThreeDimentionalShape extends Shape
{
	/**
	 * Can be implemented by the child classes of ThreeDimentionalShape class
	 * 
	 * @return double - area of the shape implementing this function
	 */
	public abstract double getArea();
	
	/**
	 * Can be implemented by the child classes of ThreeDimentionalShape class
	 * 
	 * @return double - volume of the 3D shape implementing this function
	 */
	public abstract double getVolume();

}
