import cs5004_hw7_problem2.Shape;
import cs5004_hw7_problem2.Circle;
import cs5004_hw7_problem2.Rectangle;

/**
 * Problem_2.java
 * 
 * This class contains a main which tests the Shape, Circle and Rectangle
 * classes.
 * 
 * This creates 1 of each Circle and Rectangle objects and then runs ShowArea on
 * both. area() is inherited from the Shape interface.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/13/2019
 * 
 */
public class Problem_2
{

	/**
	 * creates circle and rectangle objects and shows both their areas
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Circle c = new Circle(4); // Radius of 4
		Rectangle r = new Rectangle(4, 3); // Height = 4, Width = 3
		ShowArea(c);
		ShowArea(r);
	}

	/**
	 * calls the area() method inherited from Shape interface (and overridden based
	 * on the class). It then prints the area of the shape.
	 * 
	 * @param s - Shape object with area() method.
	 */
	public static void ShowArea(Shape s)
	{
		double area = s.area();
		System.out.println("The area of the shape is " + area);
	}

}
