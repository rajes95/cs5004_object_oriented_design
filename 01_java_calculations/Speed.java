// Author: Rajesh Sakhamuru
// Version: 5/15/2019

public class Speed
{
	/**This class calculates the speed of a cyclist with a gear size
	 * of 100 inches and a cadence of 90rpm*/
	public static void main(String[] args) 
	{
		double gearSize = 100; // inches
		double cadence = 90; // rpm
		double speed = (gearSize * 3.141592 * cadence * 60) / (12*5280);
		System.out.printf("Speed is: " + "%.3f" + " mph", speed);
	}
}