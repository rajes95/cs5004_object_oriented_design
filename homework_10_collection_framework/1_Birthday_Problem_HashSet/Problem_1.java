import java.util.HashSet;
import java.util.Random;

/**
 * Problem_1.java
 * 
 * This program approximates the probability that 2 or more people in the same
 * room have the same birthday, for 2 to 50 people in the room. The program uses
 * simulation to approximate the answer. For each number of people in the room,
 * 5000 trials are done where birthdays are randomly assigned and a hashset is
 * used to determine if there are 2 people with the same birthday in the room.
 * 
 * @author Rajesh Sakhamuru
 * @version 8/6/2019
 * 
 */
public class Problem_1
{
	/**
	 * All code for this program is in the main. the number of trials can be changed
	 * to increase or decrease accuracy.
	 * 
	 * @param args - String[] - not used
	 */
	public static void main(String[] args)
	{
		final int totalTrials = 5000;

		int people = 0;
		int day = 0;
		int count = 0;
		double totalProbability = 0;

		Random rnd = new Random();

		// trials with 2 people all the way to trials with 50 people
		for (int ppl = 2; ppl < 51; ppl++)
		{
			people = ppl;
			HashSet<Integer> birthdays = new HashSet<>(people);

			// 5000 trials per subset of people
			for (int trial = 0; trial < totalTrials; trial++)
			{

				// each person is assigned a birthday, and if there is overlap count is
				// incremented
				for (int i = 0; i < people; i++)
				{
					day = rnd.nextInt(365);

					if (birthdays.contains(day))
					{
						count++;
						break;
					}
					else
					{
						birthdays.add(day);
					}
				}

				// resets for the next trial
				birthdays.clear();
			}

			totalProbability = (double) count / totalTrials;
			// resets count for the next number of people
			count = 0;

			System.out.printf("For %d people, the probability of two birthdays is about %.4f\n", people,
					totalProbability);

		}

	}

}
