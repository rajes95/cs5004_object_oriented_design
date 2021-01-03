package simulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * This is the Ant class which is a child class of Organism (extends Organism).
 * It does not add any new private variables, so the constructors function with
 * just super().
 * 
 * The Ant objects primary functions are to move each time-step, and every third
 * time-step they breed. They are used as "prey" in the simulation.
 * 
 * move() is overridden to take into account breeding due to age of the Ants,
 * but reuses the code from Organism using super.move().
 * 
 * toString() is inherited from parent Organism class.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/3/2019
 *
 */
public class Ant extends Organism
{

	/**
	 * This default constructor invokes the super constructor from Organism class
	 * and sets the location to (-1,-1) which does not exist indicating that the Ant
	 * is not fully initialized.
	 */
	public Ant()
	{
		super();
	}

	/**
	 * Constructor for Ant. sets x and y to the given parameter values. Age defaults
	 * to 0, moved is set to false, and the corresponding world location is
	 * populated with this object. This is all done via the super constructor from
	 * the Organism class.
	 * 
	 * @param x - int - x value of location of this object
	 * @param y - int - y value of location of this object
	 */
	public Ant(int x, int y)
	{
		super(x, y);

	}

	/**
	 * This function moves the current Ant object to a randomly chosen location
	 * either left, right, up or down from it's original location. If the new
	 * location is occupied or is off the world 20x20 map, it is not moved. After
	 * moving, 'moved' is set to True and the age is incremented by 1. The age is
	 * then checked to see whether or not breeding should occur.
	 * 
	 * the parent's (Organism) move() function is invoked for simplicity.
	 * 
	 * the return value is useful during testing.
	 * 
	 * @return dir - int - inidicates direction that the object moved in. 0 is Up, 1
	 *         is Right, 2 is Down, 3 is Left. -1 means it did not move.
	 */
	public int move()
	{

		int dir = super.move();

		this.setAge(this.getAge() + 1);

		if (this.getAge() >= 3)
		{
			breed();
			this.setAge(0);
		}

		return dir;

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
	public void breed()
	{

		boolean newMade = false;

		Integer[] oldDir = new Integer[] { 0, 1, 2, 3 };
		// array to list
		List<Integer> ldir = Arrays.asList(oldDir);
		// shuffles list
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
					new Ant(this.getX() - 1, this.getY());
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
					new Ant(this.getX(), this.getY() + 1);
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
					new Ant(this.getX() + 1, this.getY());
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
					new Ant(this.getX(), this.getY() - 1);
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
	 * checks if the parameter object is equal to this object by comparing
	 * individual attribtes.
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o instanceof Ant))
		{
			return false;
		}

		Ant ant = (Ant) o;

		return this.isMoved() == ant.isMoved() && this.getAge() == ant.getAge() && this.getX() == ant.getX()
				&& this.getY() == ant.getY();

	}

}
