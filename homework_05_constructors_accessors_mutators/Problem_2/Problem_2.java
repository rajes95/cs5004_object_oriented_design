import cs5004_hw5_problem2.Container;

/**
 * This class has a main which is used to test the Container class which is
 * located in the cs5004_hw5_problem2 package.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 */
public class Problem_2
{
	/**
	 * Main tests the Container class by creating 3 containers, and running the
	 * full(), empty(), getMaxCapacity(), quantity(), leftOver(), displayQuantity()
	 * and transfer() methods on them. The outputs need to be verified by user.
	 * 
	 * @param args - none used
	 */
	public static void main(String[] args)
	{
		// Initialize 3 containers for testing
		Container cont1 = new Container(10);
		Container cont2 = new Container(9);
		Container cont3 = new Container(8);

		System.out.println("Container 1 initialized with " + cont1.getMaxCapacity() + " max capacity.");
		System.out.println("Container 2 initialized with " + cont2.getMaxCapacity() + " max capacity.");
		System.out.println("Container 3 initialized with " + cont3.getMaxCapacity() + " max capacity.\n");

		// Test quantity, full, empty and leftOver methods
		System.out.println("Check quantity of 1        : " + cont1.quantity());
		System.out.println("Check left over of 1       : " + cont1.leftOver());
		cont1.full();
		System.out.println("Quantity of 1 after full() : " + cont1.quantity());
		cont1.empty();
		System.out.println("Quantity of 1 after empty(): " + cont1.quantity());
		cont1.full();
		System.out.println("Quantity of 1 after full() : " + cont1.quantity() + "\n");

		// Test transfer from 1 to 2 and 1 to 3
		System.out.println("3 liters transfered from Container 1 to 2");
		cont2.transfer(cont1, 3);
		System.out.println("  Quantity of 1:  " + cont1.quantity());
		System.out.println("  Quantity of 2:  " + cont2.quantity() + "\n");

		System.out.println("3 liters transfered from container 1 to 3");
		cont3.transfer(cont1, 3);

		System.out.printf("  1: ");
		cont1.displayQuantity();
		System.out.println("     Check quantity of 1 : " + cont1.quantity());
		System.out.println("     Check left over of 1: " + cont1.leftOver());

		System.out.printf("\n  2: ");
		cont2.displayQuantity();
		System.out.println("     Check quantity of 2 : " + cont2.quantity());
		System.out.println("     Check left over of 2: " + cont2.leftOver());

		System.out.printf("\n  3: ");
		cont3.displayQuantity();
		System.out.println("     Check quantity of 3 : " + cont3.quantity());
		System.out.println("     Check left over of 3: " + cont3.leftOver());

		System.out.println();

		// TEST ERROR CONDITION
		System.out.println("Error Test:");
		cont3.transfer(cont1, 5);

	}

}
