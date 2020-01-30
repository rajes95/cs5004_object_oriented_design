import simulation.Ant;
import simulation.Doodlebug;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * Problem_1.java
 * 
 * This program is a simple 2D predator-prey simulation. The prey is ants, and
 * the predators are doodlebugs. The critters live in a 20x20 grid of cells, and
 * only one may occupy a cell at a time. The grid is enclosed and critters may
 * not leave the grid or move off of the edge. Time is simulated in time steps,
 * and each critter performs some action every time step.
 * 
 * 
 * Ants can Move or Breed. Doodlebugs can Move, Breed or Starve(die). Doodlebugs
 * move before the ants.
 * 
 * 
 * 
 * @author Rajesh Sakhamuru
 * @version 6/29/2019
 * 
 */
public class Problem_1
{
	/**
	 * 
	 * The main initializes the world and runs the program.
	 * 
	 * @param args - unused
	 */
	public static void main(String[] args)
	{

		// initial numbers of Ants and Doodlebugs. At most, the total (Ants +
		// Doodlebugs) can be 400.
		int initialAnts = 100;
		int initialDoodlebugs = 5;

		Scanner user = new Scanner(System.in);

		Ant.initializeWorld(); // initializes a static 20x20 world for the organisms to live.

		Random rand = new Random();

		int newAntCounter = 0;
		int newBugCounter = 0;

		// creates the number of ants indicated and places them randomly in the static
		// world
		while (newAntCounter < initialAnts)
		{
			for (int r = 0; r < 20; r++)
			{
				for (int c = 0; c < 20; c++)
				{
					int numAntCheck = rand.nextInt(800 / initialAnts);
					if (Ant.world[r][c] == null && numAntCheck == 0)
					{
						new Ant(r, c);
						newAntCounter++;
					}
					if (newAntCounter >= initialAnts)
					{
						break;
					}
				}
				if (newAntCounter >= initialAnts)
				{
					break;
				}
			}
		}
		// creates the number of Doodlebugs indicated and places them randomly in the
		// static world
		while (newBugCounter < initialDoodlebugs)
		{
			for (int r = 0; r < 20; r++)
			{
				for (int c = 0; c < 20; c++)
				{
					int numBugCheck = rand.nextInt(800 / initialDoodlebugs);
					if (Ant.world[r][c] == null && numBugCheck == 0)
					{
						new Doodlebug(r, c);
						newBugCounter++;
					}
					if (newBugCounter >= initialDoodlebugs)
					{
						break;
					}

				}
				if (newBugCounter >= initialDoodlebugs)
				{
					break;
				}
			}
		}

		System.out.println("Number of Ants:       " + initialAnts + "\nNumber of Doodlebugs: " + initialDoodlebugs);

		while (true)
		{
			int antCount = 0;
			int bugCount = 0;

			Doodlebug.printWorld(); // prints the 20x20 grid. doodlebugs are 'X', ants are 'o'

			// This loop finds all doodlebugs in the world and moves them first.
			// The move function checks whether the bug needs to breed or starve and calls
			// those functions respectively.
			// Breeding occurs before starving if both occur after the same turn.
			for (int r = 0; r < 20; r++)
			{
				for (int c = 0; c < 20; c++)
				{
					if (Doodlebug.world[r][c] != null && Doodlebug.world[r][c].isMoved() == false
							&& Doodlebug.world[r][c].getClass() == Doodlebug.class)
					{
						Doodlebug.world[r][c].move();
					}

				}
			}

			// This loop finds all ants in the world and moves them.
			// The move function checks whether the ant needs to breed and calls the
			// function if needed.
			// Breeding occurs in ants after 3 turns.
			for (int r = 0; r < 20; r++)
			{
				for (int c = 0; c < 20; c++)
				{
					if (Ant.world[r][c] != null && Ant.world[r][c].isMoved() == false
							&& Ant.world[r][c].getClass() == Ant.class)
					{
						Ant.world[r][c].move();
					}
				}
			}
			// counts total numbers of Ants and Doodlebugs in the world.
			for (int r = 0; r < 20; r++)
			{
				for (int c = 0; c < 20; c++)
				{
					if (Ant.world[r][c] != null && Ant.world[r][c].getClass() == Ant.class)
					{
						antCount++;
					}
					if (Doodlebug.world[r][c] != null && Doodlebug.world[r][c].getClass() == Doodlebug.class)
					{
						bugCount++;
					}
				}
			}

			// 'moved' is set to true so newly bred organisms are not moved immediatelly.
			// here all the 'moved' values are set to false so for the next time step there
			// are no errors.
			Doodlebug.resetWorldMoved();

			// takes user input to advance time or quit
			System.out.println("Press Enter to advance time. Input anything else to quit.");
			if ((user.nextLine()).length() > 0)
			{
				break;
			}
			// prints number of ants and doodlebugs before the current world grid is printed
			// again
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nNumber of Ants:       " + antCount + "\nNumber of Doodlebugs: " + bugCount);

		}
		user.close();

	}

}
