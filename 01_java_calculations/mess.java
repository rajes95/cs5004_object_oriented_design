// Author: Rajesh Sakhamuru
// Version: 5/15/2019

public class mess
{
	/**This class uses time and distance to calculate pace
	 * and return it to console*/
	public static void main (String[] args)
	{
		double time = 35.5;  //35 minutes and 30 seconds
		double distance = 6.21;
		double pace = time/distance;
		System.out.println("This program calculates pace");
		System.out.printf("Pace is " + "%.3f" + " miles per hour.", pace);
	}
}