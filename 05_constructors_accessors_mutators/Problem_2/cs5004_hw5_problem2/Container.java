package cs5004_hw5_problem2;

/**
 * This class describes an object which holds 2 values: a maximum Capacity, and
 * a currently held quantity value. The container can be filled, emptied, or
 * liquid can be tranfered between containers. All measurements are in Liters.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 *
 */
public class Container
{
	private double maxCapacity;
	private double quantity;

	/**
	 * This is a constructor for this class that sets initial quantity of container
	 * to 0, and this.maxCapacity to the given parameter.
	 * 
	 * @param maxCapacity - double - maxCapacity of new container
	 */
	public Container(double maxCapacity)
	{
		this.setQuantity(0);
		this.setMaxCapacity(maxCapacity);
	}

	/**
	 * This is method calls and returns getQuantity() so that the user can just call
	 * quantity().
	 * 
	 * @return getQuantity() - double - returns this.quantity
	 */
	public double quantity()
	{
		return getQuantity();

	}

	/**
	 * This method subtracts quantity from max capacity and returns the difference
	 * 
	 * @return double - amount of capacity remaining in container
	 */
	public double leftOver()
	{
		return getMaxCapacity() - getQuantity();
	}

	/**
	 * This method sets the quantity to the max possible capacity
	 */
	public void full()
	{
		setQuantity(getMaxCapacity());
	}

	/**
	 * This method sets the container quantity to 0.
	 */
	public void empty()
	{
		setQuantity(0);
	}

	/**
	 * This method prints a statement displaying the quantity in the container
	 * (using a rounded value)
	 */
	public void displayQuantity()
	{
		System.out.printf("%.3f liters of liquid in Container.\n", this.getQuantity());
	}

	/**
	 * This method first takes another container as an object and then the amount of
	 * liquid as a double to put transfer from the parameter container TO the "this"
	 * container.
	 * 
	 * @param fromCont - Container - liquid is transferred FROM this container
	 * @param amount   - double - amount of liquid transferred
	 */
	public void transfer(Container fromCont, double amount)
	{

		if (((getQuantity() + amount) <= this.getMaxCapacity()) && ((fromCont.quantity() - amount) >= 0))
		{
			setQuantity(getQuantity() + amount);
			fromCont.setQuantity(fromCont.quantity() - amount);
		}
		else
		{
			System.err.println("ERROR: Not enough liquid or not enough space for transfer.");
		}
	}

	/**
	 * gets max capacity value of container
	 * 
	 * @return maxCapacity - double - max capacity of this container
	 */
	public double getMaxCapacity()
	{
		return maxCapacity;
	}

	/**
	 * sets a new maxCapacity for the Container
	 * 
	 * @param maxCapacity - double - new max capacity
	 */
	public void setMaxCapacity(double maxCapacity)
	{
		this.maxCapacity = maxCapacity;
	}

	/**
	 * gets current quantity in container
	 * 
	 * @return quantity - double - current liquid quantity in container
	 */
	public double getQuantity()
	{
		return quantity;
	}

	/**
	 * sets a new quantity value for the container
	 * 
	 * @param quantity - double - new quantity value
	 */
	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

}
