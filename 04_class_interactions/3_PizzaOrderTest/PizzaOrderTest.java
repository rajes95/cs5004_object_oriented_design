/**
 * @author Rajesh Sakhamuru
 * @version 6/4/2019
 *
 *          This program tests the PizzaOrder class using the PizzaOrderTest
 *          class which houses the main. The pizza order class should be able to
 *          store between 1 and 3 pizzas, which is also indicated by the
 *          numPizzas The PizzaOrder class can also calculate the cost of the
 *          whole order by calling method calcTotal();
 * 
 *          PizzaOrderTest tests PizzaOrder by creating 3 pizzas and then
 *          creating 3 different pizza orders using 1, 2 and 3 of the pizzas in
 *          different ones. The total price is calculated and verified, and all
 *          three orders utilize the toString() method to print a description of
 *          the whole order.
 *
 *
 */
public class PizzaOrderTest
{
	public static void main(String[] args)
	{
		// Some pizzas used in more than one order
		Pizza pizza1 = new Pizza('L', 1, 0, 1);
		Pizza pizza2 = new Pizza('M', 2, 2, 0);
		Pizza pizza3 = new Pizza('S', 0, 1, 2);

		PizzaOrder order1 = new PizzaOrder(); // order with 3 pizzas
		order1.setNumPizzas(3);
		order1.setPizza1(pizza1);
		order1.setPizza2(pizza2);
		order1.setPizza3(pizza3);
		double total1 = order1.calcTotal();

		System.out.println(order1);
		System.out.println("----------------\norder1 total cost is $54: " + (total1 == 54) + "\n----------------\n");

		PizzaOrder order2 = new PizzaOrder(); // order with 2 pizzas
		order2.setNumPizzas(2);
		order2.setPizza1(pizza1);
		order2.setPizza2(pizza2);
		double total2 = order2.calcTotal();

		System.out.println(order2);
		System.out.println("----------------\norder2 total cost is $38: " + (total2 == 38) + "\n----------------\n");

		PizzaOrder order3 = new PizzaOrder(); // order with 1 piza
		order3.setNumPizzas(1);
		order3.setPizza1(pizza1);
		double total3 = order3.calcTotal();

		System.out.println(order3);
		System.out.println("----------------\norder3 total cost is $18: " + (total3 == 18) + "\n----------------\n");
	}
}

/**
 * This class is for an order of 1 to 3 pizzas and calculating their cost.
 * toString() function is included in this class for the order description
 * 
 */
class PizzaOrder
{
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	private int numPizzas;

	/**
	 * sets the number of pizzas that the order has if the number is less than 1 or
	 * greater than 3 then it prints an error and exits program.
	 * 
	 * @param int numPizzas : new number of pizzas in order
	 */
	public void setNumPizzas(int numPizzas)
	{
		if (numPizzas < 1 || numPizzas > 3)
		{
			System.out.println("ERROR: Incompatible number of pizzas.");
			System.exit(1);
		}
		this.numPizzas = numPizzas;
	}

	/**
	 * sets this.pizza1 to be constructed with properties of parameter given Pizza
	 * pizza1
	 * 
	 * @param Pizza pizza1 : Pizza that we want to be the first pizza in the order
	 */
	public void setPizza1(Pizza pizza1)
	{
		this.pizza1 = new Pizza(pizza1.getSize(), pizza1.getCheeseTops(), pizza1.getPepTops(), pizza1.getHamTops());
	}

	/**
	 * sets this.pizza2 to be constructed with properties of parameter given Pizza
	 * pizza2 will print an error if numPizzas is less than 2
	 * 
	 * @param Pizza pizza2 : Pizza that we want to be the second pizza in the order
	 */
	public void setPizza2(Pizza pizza2)
	{

		if (this.numPizzas >= 2)
		{
			this.pizza2 = new Pizza(pizza2.getSize(), pizza2.getCheeseTops(), pizza2.getPepTops(), pizza2.getHamTops());
		} else
		{
			System.out.println("ERROR: Incompatible number of pizzas. Pizza2 not set.");
		}

	}

	/**
	 * sets this.pizza3 to be constructed with properties of parameter given Pizza
	 * pizza3 will print an error if numPizzas is not equal to 3
	 * 
	 * @param Pizza pizza3 : Pizza that we want to be the third pizza in the order
	 */
	public void setPizza3(Pizza pizza3)
	{
		if (this.numPizzas == 3)
		{
			this.pizza3 = new Pizza(pizza3.getSize(), pizza3.getCheeseTops(), pizza3.getPepTops(), pizza3.getHamTops());
		} else
		{
			System.out.println("ERROR: Incompatible number of pizzas. Pizza3 not set.");
		}
	}

	/**
	 * will calculate the total cost of the order taking into account the numPizzas
	 * value for number of pizza's value to 
	 * 
	 * @return double cost : the dollar amount total cost of the whole order
	 * 
	 */
	public double calcTotal()
	{
		double cost = 0;

		switch (this.numPizzas)
		{
		case 1:
			cost = pizza1.calCost();
			break;
		case 2:
			cost = pizza1.calCost() + pizza2.calCost();
			break;
		case 3:
			cost = pizza1.calCost() + pizza2.calCost() + pizza3.calCost();
			break;
		}

		return cost;
	}

	/**
	 * toString() allows the this object to be used as a parameter for print statements.
	 * Returns a string description of the order including total cost.
	 * 
	 * @return String str : string description of the whole order
	 * 
	 * */
	public String toString()
	{
		String str = "";

		switch (this.numPizzas)
		{
		case 1:
			str = pizza1.getDescription() + "\n\nTotal Cost: $" + calcTotal() + "0";
			break;
		case 2:
			str = pizza1.getDescription() + "\n\n" + pizza2.getDescription() + "\n\nTotal Cost: $" + calcTotal() + "0";
			break;
		case 3:
			str = pizza1.getDescription() + "\n\n" + pizza2.getDescription() + "\n\n" + pizza3.getDescription()
					+ "\n\nTotal Cost: $" + calcTotal() + "0";
			break;
		}

		return str;
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
		setSize('L');
		setCheeseTops(0);
		setPepTops(0);
		setHamTops(0);
	}
}