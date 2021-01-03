package simulation;

import java.util.Random;

/**
 * This is the Organism class which is the parent class for Ant and Doodlebug.
 * 
 * 
 * It hold information on location, whether or not the organism has moved in the
 * current time-step and the age of the organism. A default move method is also
 * included.
 * 
 * This class also contains a public static variable which tracks the world of
 * the organisms. The world is initialized, printed and reset(via moved) through
 * methods in this class.
 * 
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Organism
{
	static public Organism[][] world;

	private int x;
	private int y;
	private boolean moved;
	private int age;

	/**
	 * returns age of organism
	 * 
	 * @return age - int - integer age of organism
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * sets the age of the organism
	 * 
	 * @param age - int - new age of organism.
	 */
	public void setAge(int age)
	{
		if (age < 0 || age > 10)
		{
			System.err.println("age value out of bounds.");
			System.exit(-1);
		}
		this.age = age;
	}

	/**
	 * returns x value of location on world.
	 * 
	 * @return x - int - current x value
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * sets new x value for object. DOES NOT CHANGE LOCATION ON WORLD
	 * 
	 * @param x - int - new x value
	 */
	public void setX(int x)
	{
		if (x < -1 || x > 20)
		{
			System.err.println("X value out of bounds.");
			System.exit(-1);
		}

		this.x = x;

	}

	/**
	 * returns current location y value
	 * 
	 * @return y - int - currenty y value
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * sets parameter to new y value of organism location.
	 * 
	 * 
	 * DOES NOT CHANGE LOCATION ON WORLD
	 * 
	 * @param y - int - new y value
	 */
	public void setY(int y)
	{
		if (y < -1 || y > 20)
		{
			System.err.println("Y value out of bounds.");
			System.exit(-1);
		}

		this.y = y;
	}

	/**
	 * returns current boolean value of whether or not organism has moved during
	 * this time step
	 * 
	 * @return moved - boolean - whether organism has moved or not this time step
	 */
	public boolean isMoved()
	{
		return moved;
	}

	/**
	 * this function is used to set the value of moved of this object to either true
	 * or false via the parameter
	 * 
	 * @param moved - boolean - new value for moved
	 */
	public void setMoved(boolean moved)
	{
		this.moved = moved;
	}

	/**
	 * Default constructor for Organism. sets X and Y to -1, age to 0, and moved to
	 * false.
	 * 
	 */
	public Organism()
	{
		this.setX(-1);
		this.setY(-1);
		this.setAge(0);
		this.setMoved(false);
	}

	/**
	 * Constructor for Organism. sets x and y to the given parameter values. Age
	 * defaults to 0, moved is set to false, and the corresponding world location is
	 * populated with this object.
	 * 
	 * @param x - int - x value of location of this object
	 * @param y - int - y value of location of this object
	 */
	public Organism(int x, int y)
	{

		this.setX(x);
		this.setY(y);
		this.setAge(0);
		this.setMoved(false);
		world[x][y] = this;

	}

	/**
	 * initializes all locations of the public static world variable to null.
	 */
	public static void initializeWorld()
	{
		world = new Organism[20][20];
		for (int r = 0; r < 20; r++)
		{
			for (int c = 0; c < 20; c++)
			{
				world[r][c] = null;
			}
		}
	}

	/**
	 * prints the 20x20 world grid. ants are represented by 'o' and doodlebugs are
	 * represented by 'X'
	 */
	public static void printWorld()
	{
		System.out.println("___01234567890123456789_");
		for (int r = 0; r < 20; r++)
		{
			System.out.printf("%02d|", r);
			for (int c = 0; c < 20; c++)
			{
				if (world[r][c] == null)
				{
					System.out.printf(" ");
				}
				else if (world[r][c].getClass() == Ant.class)
				{
					System.out.printf("o");
				}
				else if (world[r][c].getClass() == Doodlebug.class)
				{
					System.out.printf("X");
				}

			}
			System.out.printf("|");
			System.out.println();
		}
		System.out.println("________________________");
	}

	/**
	 * loops through all of the organism objects in the world array and sets all of
	 * their 'moved' values to false
	 */
	public static void resetWorldMoved()
	{
		for (int r = 0; r < 20; r++)
		{
			for (int c = 0; c < 20; c++)
			{
				if (world[r][c] != null)
				{
					world[r][c].setMoved(false);
				}
			}
		}
	}

	/**
	 * This function moves the current organism object to a randomly chosen location
	 * either left, right, up or down from it's original location. If the new
	 * location is occupied or is off the world 20x20 map, it is not moved. After
	 * moving, 'moved' is set to True.
	 * 
	 * the return value is useful during testing.
	 * 
	 * @return dir - int - inidicates direction that the object moved in. 0 is Up, 1
	 *         is Right, 2 is Down, 3 is Left. -1 means it did not move.
	 */
	public int move()
	{
		Random rand = new Random();
		int dir = rand.nextInt(4);

		int newX = this.getX();
		int newY = this.getY();
		int oldX = this.getX();
		int oldY = this.getY();

		// 0 is Up, 1 is Right, 2 is Down, 3 is Left
		// (0,0) is at top left corner, (19,19) is bottom right corner

		switch (dir)
		{
		case 0:
			if (this.getX() == 0)
			{
				dir = -1;
				break;
			}

			newX = this.getX() - 1;
			newY = this.getY();
			break;

		case 1:
			if (this.getY() == 19)
			{
				dir = -1;
				break;
			}
			newX = this.getX();
			newY = this.getY() + 1;
			break;

		case 2:
			if (this.getX() == 19)
			{
				dir = -1;
				break;
			}
			newX = this.getX() + 1;
			newY = this.getY();
			break;

		case 3:
			if (this.getY() == 0)
			{
				dir = -1;
				break;
			}
			newX = this.getX();
			newY = this.getY() - 1;
			break;
		}

		// If location to move to is unchanged (because of edge of world case) then it
		// is not moved
		if ((newX != this.getX() || newY != this.getY()) && world[newX][newY] == null)
		{
			this.setX(newX);
			this.setY(newY);
			world[newX][newY] = this;
			world[oldX][oldY] = null;
		}
		else
		{
			dir = -1;
		}

		this.setMoved(true);

		return dir;

	}

	/**
	 * prints current location of the object.
	 */
	public String toString()
	{
		String str = "";

		str += "Location on world: (" + this.getX() + "," + this.getY() + ")";

		return str;
	}

	/**
	 * checks if the parameter object is equal to this object by comparing
	 * individual attribtes.
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o instanceof Organism))
		{
			return false;
		}
		Organism org = (Organism) o;

		return this.isMoved() == org.isMoved() && this.getAge() == org.getAge() && this.getX() == org.getX()
				&& this.getY() == org.getY();

	}

}
