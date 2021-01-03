package simulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * This is the Doodlebug class which is a child class of Organism (extends
 * Organism).
 * 
 * The Doodlebug objects primary functions are to move each time-step, and every
 * eighth time-step they breed, and if they do not eat any ants while moving for
 * 3 time steps they are starved (killed off). They are used as "predators" in
 * the simulation.
 * 
 * The order of actions is Move > Breed > Starve. Breeding and moving happen
 * during the third timestep and are seen in the 20x20 grid during that
 * time-step itself. Starvation happens at the end of the third turn, and is
 * reflected in the next printing of the static 20x20 World.
 * 
 * 
 * toString() is inherited from parent Organism class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Doodlebug extends Organism
{
	// number of time-steps since the Doodlebug last ate.
	private int lastAte;

	/**
	 * returns the value of lastAte.
	 * 
	 * @return lastAte - int - number of turns since this Doodlebug last ate.
	 */
	public int getLastAte()
	{
		return lastAte;
	}

	/**
	 * sets the given parameter to the new value of lastAte.
	 * 
	 * @param lastAte - int - number of time-steps since Doodlebug ate an Ant
	 */
	public void setLastAte(int lastAte)
	{
		if (lastAte < 0 || lastAte > 3)
		{
			System.err.println("lastAte value out of bounds.");
			System.exit(-1);
		}

		this.lastAte = lastAte;
	}

	/**
	 * 
	 * 
	 * This default constructor invokes the super constructor from Organism class
	 * and sets the location to (-1,-1) which does not exist indicating that the
	 * Doodlebug is not fully initialized. It also sets lastAte to 0.
	 * 
	 */
	public Doodlebug()
	{
		super();
		this.setLastAte(0);
	}

	/**
	 * Constructor for Doodlebug. sets x and y to the given parameter values. Age
	 * defaults to 0, moved is set to false, and the corresponding world location is
	 * populated with this object. This is all done via the super constructor from
	 * the Organism class. lastAte is then set to 0.
	 * 
	 * @param x - int - x value of location of this object
	 * @param y - int - y value of location of this object
	 */
	public Doodlebug(int x, int y)
	{
		super(x, y);
		this.setLastAte(0);
	}

	/**
	 * This function moves the current Doodlebug object to a randomly chosen
	 * location either left, right, up or down from it's original location. If the
	 * new location is occupied or is off the world 20x20 map, it is not moved.
	 * After moving, 'moved' is set to True and the age is incremented by 1. The age
	 * is then checked to see whether or not breeding should occur.
	 * 
	 * BEFORE MOVING, a check is made on lastAte, to see if the bug should be
	 * starved or not, and if it is, it's location is set to null on the world
	 * Organism array.
	 * 
	 * the return value is useful during testing.
	 * 
	 * @return dir - int - inidicates direction that the object moved in. 0 is Up, 1
	 *         is Right, 2 is Down, 3 is Left. -1 means it did not move.
	 */
	public int move()
	{

		int newX = this.getX();
		int newY = this.getY();
		int oldX = this.getX();
		int oldY = this.getY();

		boolean starved = checkStarved();

		if (starved)
		{
			world[this.getX()][this.getY()] = null;
			return -1;
		}

		Random rand = new Random();
		int dir = rand.nextInt(4);

		// 0 is Up, 1 is Right, 2 is Down, 3 is Left
		// (0,0) is at top left corner, (19,19) is bottom right corner

		switch (dir)
		{
		case 0:
			if (this.getX() == 0)
			{
				break;
			}

			newX = this.getX() - 1;
			newY = this.getY();
			break;

		case 1:
			if (this.getY() == 19)
			{
				break;
			}
			newX = this.getX();
			newY = this.getY() + 1;
			break;

		case 2:
			if (this.getX() == 19)
			{
				break;
			}
			newX = this.getX() + 1;
			newY = this.getY();
			break;

		case 3:
			if (this.getY() == 0)
			{
				break;
			}
			newX = this.getX();
			newY = this.getY() - 1;
			break;
		}
		// if this Doodlebug moves to an empty space, lastAte is incremented.
		if ((newX != this.getX() || newY != this.getY()) && world[newX][newY] == null)
		{
			this.setX(newX);
			this.setY(newY);
			world[newX][newY] = this;
			world[oldX][oldY] = null;

			this.setLastAte(this.getLastAte() + 1);

		}
		// if this Doodlebug moves to a space that has an Ant, that ant is replaced by
		// this doodlebug and lastAte is set to 0.
		else if ((newX != this.getX() || newY != this.getY()) && world[newX][newY].getClass() == Ant.class)
		{
			this.setX(newX);
			this.setY(newY);
			world[newX][newY] = this;
			world[oldX][oldY] = null;

			this.setLastAte(0);

		}
		// this else is invoked to not move the doodlebug if it tries to move into a
		// space that already contains another Doodlebug. lastAte is still incremented
		else
		{
			this.setLastAte(this.getLastAte() + 1);

		}

		this.setMoved(true);

		this.setAge(this.getAge() + 1);

		// breeds if age is 8.
		if (this.getAge() >= 8)
		{
			breed();
			this.setAge(0);
		}

		return dir;

	}

	/**
	 * This function is invoked during the time-step where the Doodlebug's age turns
	 * 8 after moving.
	 * 
	 * A new Doodlebug object is created in the World static array in a randomly
	 * chosen empty spot adjacent to the current (this) object. If no spaces are
	 * available on the world, then no new object is created.
	 * 
	 */
	public void breed()
	{

		boolean newMade = false;

		Integer[] oldDir = new Integer[] { 0, 1, 2, 3 };
		// array to list
		List<Integer> ldir = Arrays.asList(oldDir);
		// shuffle the list
		Collections.shuffle(ldir);
		// converts list back to array
		Integer[] dir = ldir.toArray(new Integer[ldir.size()]);

		// 0 is Up, 1 is Right, 2 is Down, 3 is Left
		// (0,0) is at top left corner, (19,19) is bottom right corner

		for (int n = 0; n < 4; n++)
		{
			switch (dir[n])
			{
			case 0:
				if (this.getX() == 0)
				{
					break;
				}
				else if (world[this.getX() - 1][this.getY()] == null)
				{
					new Doodlebug(this.getX() - 1, this.getY());
					world[this.getX() - 1][this.getY()].setMoved(true);
					newMade = true;
				}

				break;

			case 1:
				if (this.getY() == 19)
				{
					break;
				}
				else if (world[this.getX()][this.getY() + 1] == null)
				{
					new Doodlebug(this.getX(), this.getY() + 1);
					world[this.getX()][this.getY() + 1].setMoved(true);
					newMade = true;
				}
				break;

			case 2:
				if (this.getX() == 19)
				{
					break;
				}
				else if (world[this.getX() + 1][this.getY()] == null)
				{
					new Doodlebug(this.getX() + 1, this.getY());
					world[this.getX() + 1][this.getY()].setMoved(true);
					newMade = true;
				}
				break;

			case 3:
				if (this.getY() == 0)
				{
					break;
				}
				else if (world[this.getX()][this.getY() - 1] == null)
				{
					new Doodlebug(this.getX(), this.getY() - 1);
					world[this.getX()][this.getY() - 1].setMoved(true);
					newMade = true;
				}
				break;
			}

			if (newMade)
			{
				break;
			}
		}

	}

	/**
	 * checks if the lastAte value is 3 during each timestep, and if it is, then a
	 * boolean value true is returned and used by breed to kill this Doodlebug.
	 * 
	 * @return - boolean - indicating whether or not this Doodlebug should be
	 *         starved to death or not.
	 */
	public boolean checkStarved()
	{
		if (this.getLastAte() == 3)
		{
			return true;

		}
		return false;
	}

	/**
	 * This function is invoked during the time-step where the Ant's age turns 3
	 * after moving.
	 * 
	 * A new Ant object is created in the World static array in a randomly chosen
	 * empty spot adjacent to the current (this) object. If no spaces are available
	 * on the world, then no new object is created.
	 * 
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o instanceof Doodlebug))
		{
			return false;
		}

		Doodlebug bug = (Doodlebug) o;

		return this.isMoved() == bug.isMoved() && this.getAge() == bug.getAge() && this.getX() == bug.getX()
				&& this.getY() == bug.getY() && this.getLastAte() == bug.getLastAte();

	}

}
