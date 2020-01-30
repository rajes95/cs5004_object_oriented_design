/**
 * @author Rajesh Sakhamuru
 * @version 6/4/2019
 *
 * class Pizza stores information about a single pizza:
 *     pizza size, 
 *     number of cheese toppings,
 *     number of pepperoni toppings,
 *     number of ham toppings.
 *     
 * class PizzaTest tests the Pizza class by creating 5 different 
 * pizzas and then printing out their descriptions.
 *
 *
 */

/**
 * this class PizzaTest tests the Pizza class by creating 5 different pizzas and
 * then printing out their descriptions using the getDescription() method.
 * 
 */
public class PizzaTest
{
	public static void main(String[] args)
	{
		Pizza defaultPizza = new Pizza();
		System.out.println(defaultPizza.getDescription());
		System.out.println();
		Pizza pizza1 = new Pizza('L', 1, 1, 2);
		System.out.println(pizza1.getDescription());
		System.out.println();
		Pizza pizza2 = new Pizza('S', 7, 0, 0);
		System.out.println(pizza2.getDescription());
		System.out.println();
		Pizza pizza3 = new Pizza('M', 1, 9, 0);
		System.out.println(pizza3.getDescription());
		System.out.println();
		Pizza pizza4 = new Pizza('M', 3, 3, 3);
		System.out.println(pizza4.getDescription());

	}
}

/**
 * class Pizza stores information about a single pizza: pizza size, number of
 * cheese toppings, number of pepperoni toppings, number of ham toppings.
 * 
 * Pizza objects can also use methods to calculate pizza price or get a string
 * description of the pizza.
 */
class Pizza
{
	private char size;
	private int cheeseTops;
	private int pepTops;
	private int hamTops;

	/**
	 * get pizza size char value
	 * 
	 * @return char size : current size char, like 'S', 'M' or 'L'
	 */
	public char getSize()
	{
		return size;
	}

	/**
	 * set a new size for the pizza
	 * 
	 * @param char size = 'S', 'M' or 'L' depending on the pizza size
	 */
	public void setSize(char size)
	{
		this.size = size;
	}

	/**
	 * get current number of cheese toppings
	 * 
	 * @return int cheeseTops : number of cheese toppings
	 * 
	 */
	public int getCheeseTops()
	{
		return cheeseTops;
	}

	/**
	 * set new number of cheese toppings
	 * 
	 * @param int cheeseTops : new number of cheese toppings
	 */
	public void setCheeseTops(int cheeseTops)
	{
		this.cheeseTops = cheeseTops;
	}

	/**
	 * get number of pepperoni toppings for this pizza
	 * 
	 * @return int pepTops : number of pepperoni toppings
	 */
	public int getPepTops()
	{
		return pepTops;
	}

	/**
	 * set new number of pepperoni toppings
	 * 
	 * @param int pepTops : new number of pepperoni toppings
	 */
	public void setPepTops(int pepTops)
	{
		this.pepTops = pepTops;
	}

	/**
	 * get number of Ham toppings for this pizza
	 * 
	 * @return int hamTops : number of ham toppings
	 */
	public int getHamTops()
	{
		return hamTops;
	}

	/**
	 * set new number of ham toppings for pizza
	 * 
	 * @param int hamTops : new number of ham toppings
	 */
	public void setHamTops(int hamTops)
	{
		this.hamTops = hamTops;
	}

	/**
	 * calculate cost of pizza based on number of toppings and size of pizza. Small
	 * pizza = $10 Medium Pizza = $12 Large Pizza = $14 each topping of any type
	 * adds $2
	 * 
	 * @return double cost : cost of pizza
	 */
	public double calCost()
	{
		double cost = 0;

		switch (this.size)
		{
		case 'S':
			cost += 10;
			break;
		case 'M':
			cost += 12;
			break;
		case 'L':
			cost += 14;
			break;
		}

		cost += (this.cheeseTops * 2) + (this.pepTops * 2) + (this.hamTops * 2);
		return cost;
	}

	/**
	 * returns description of pizza telling size, toppings and cost in a single
	 * string.
	 * 
	 * @return String descr : description of the pizza
	 */
	public String getDescription()
	{
		String descr = "";
		String sizeStr = "";
		switch (this.size)
		{
		case 'S':
			sizeStr = "Small";
			break;
		case 'M':
			sizeStr = "Medium";
			break;
		case 'L':
			sizeStr = "Large";
			break;
		}

		descr += sizeStr + " pizza:\n" + this.cheeseTops + " cheese, " + this.pepTops + " peperoni and " + this.hamTops
				+ " ham toppings.\nThis pizza costs $" + this.calCost() + "0";
		return descr;
	}

	/**
	 * Pizza constructor taking initial size and toppings and setting them
	 * 
	 * @param char size : size of pizza
	 * @param int  cheeseTops : number of cheese toppings
	 * @param int  pepTops : number of pepperoni toppings
	 * @param int  hamTops : number of ham toppings
	 * 
	 */
	Pizza(char size, int cheeseTops, int pepTops, int hamTops)
	{
		setSize(size);
		setCheeseTops(cheeseTops);
		setPepTops(pepTops);
		setHamTops(hamTops);
	}

	/**
	 * Pizza default constructor if no parameters are given sets size to Small and 0
	 * for each type of topping.
	 */
	Pizza()
	{
		setSize('S');
		setCheeseTops(0);
		setPepTops(0);
		setHamTops(0);
	}
}