// Author: Rajesh Sakhamuru
// Version: 5/15/2019

public class Calories 
{
	/**This class calculates and outputs the total number 
	 * of calories burned for a 150-pound person who runs for 30 mins
	 * plays basketball for 60 mins and then sleeps for 8 hrs.
	 * */	
	public static void main(String[] args) 
	{
		double weight = 150/2.2;
		double runningTime = 30.0;
		double basketballTime = 60.0;
		double sleepTime = 8 * 60.0;
		double runningCalories = 0.0175 * 10 * weight * runningTime;
		double basketballCalories = 0.0175 * 8 * weight * basketballTime;
		double sleepCalories = 0.0175 * 1 * weight * sleepTime;
		double caloriesBurned = runningCalories + basketballCalories + sleepCalories;
		System.out.printf("Calories Burned: " + "%.3f", caloriesBurned);
	}

}
