import shapes.Shape;
import shapes.TwoDimentionalShape;
import shapes.ThreeDimentionalShape;
import shapes.Circle;
import shapes.Square;
import shapes.Triangle;
import shapes.Sphere;
import shapes.Cube;
import shapes.Tetrahedron;

/**
 * 
 * Problem_2.java
 * 
 * This program uses an array of Shape references to objects of types: Circle,
 * Square, Triangle, Sphere, Cube and Tetrahedron. The program prints the area
 * (or Surface Area) of the object and the volume of the object (if it applies)
 * depending on whether the object is 2D or 3D.
 * 
 * The heirarchy of classes is as follows:
 * 
 * Shape: {TwoDimentionalShape: Circle, Square, Triangle},
 * {ThreeDimentionalShape: Sphere, Cube, Tetrahedron}
 * 
 * Shape, TwoDimentionalShape and ThreeDimentionalShape are abstract classes
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 * 
 */
public class Problem_2
{

	public static void main(String[] args)
	{
		// 12 different shape objects created here (6 2D and 6 3D objects)
		Circle cir1 = new Circle(4);
		Square sqr1 = new Square(4);
		Triangle tri1 = new Triangle(4, 4);
		Sphere sph1 = new Sphere(4);
		Cube cub1 = new Cube(4);
		Tetrahedron tet1 = new Tetrahedron(4);
		Circle cir2 = new Circle(5);
		Square sqr2 = new Square(5);
		Triangle tri2 = new Triangle(5, 5);
		Sphere sph2 = new Sphere(5);
		Cube cub2 = new Cube(5);
		Tetrahedron tet2 = new Tetrahedron(5);

		int count = 0;

		Shape ShapeArr[] = new Shape[] { cir1, sqr1, tri1, sph1, cub1, tet1, cir2, sqr2, tri2, sph2, cub2, tet2 };

		for (Shape shape : ShapeArr)
		{
			System.out.println("Shape " + count + ":");
			if (shape instanceof TwoDimentionalShape)
			{
				// downcast the Shape object so .getArea() can be accessed
				TwoDimentionalShape TwoDShape = (TwoDimentionalShape) shape;

				System.out.println("Area: " + Double.toString(TwoDShape.getArea()) + " Units^2");
			}
			else if (shape instanceof ThreeDimentionalShape)
			{
				// downcast the object so .getArea() and .getVolume() can be accessed
				ThreeDimentionalShape ThreeDShape = (ThreeDimentionalShape) shape;

				System.out.println("Area: " + Double.toString(ThreeDShape.getArea()) + " Units^2");
				System.out.println("Volume: " + Double.toString(ThreeDShape.getVolume()) + " Units^3");
			}
			count++;
			System.out.println();
		}

	}

}
