package teamRecords;

/**
 * 
 * The Competition class stores info about a competition including the
 * Competition name, winner, runner-up and year it happened.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 *
 */
public class Competition
{

	private String name;
	private String winner;
	private String runnerUp;
	private int year;

	/**
	 * Competition object constructor that takes as parameters each of the four
	 * variables stored by this object.
	 * 
	 * @param name     - String - name of competition
	 * @param winner   - String - winner of competition
	 * @param runnerUp - String - Runner-up of competition
	 * @param year     - int - year that competition occured
	 */
	public Competition(String name, String winner, String runnerUp, int year)
	{
		this.setName(name);
		this.setWinner(winner);
		this.setRunnerUp(runnerUp);
		this.setYear(year);
	}

	/**
	 * This constructor creates a deep copy of another competition object
	 * 
	 * @param competition - competition with attributes being mimiced
	 */
	public Competition(Competition competition)
	{
		if (competition == null)
		{
			System.out.println("Fatal error.");
			System.exit(0);
		}
		this.setName(competition.getName());
		this.setRunnerUp(competition.getRunnerUp());
		this.setWinner(competition.getWinner());
		this.setYear(competition.getYear());
	}

	/**
	 * Competition object constructor with no parameters defaulting them to NOT SET
	 * or 0.
	 */
	public Competition()
	{
		this.setName("NOT SET");
		this.setWinner("NOT SET");
		this.setRunnerUp("NOT SET");
		this.setYear(0);
	}

	/**
	 * toString overrides the default toString method for use in print statements
	 * 
	 * @return str - String describing Competition
	 * 
	 */
	public String toString()
	{
		String str = "";

		str += "Competition name: " + name + "\n   Winner: " + winner + "\n   Runner up: " + runnerUp + "\n   Year: "
				+ year + "\n";

		return str;
	}

	/**
	 * returns competition name
	 * 
	 * @return name - String - name of competition
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets a new Competition name
	 * 
	 * @param name - String - New name of competition
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * gets the winner string via return
	 * 
	 * @return winner - String - name of competition winner
	 */
	public String getWinner()
	{
		return winner;
	}

	/**
	 * sets a new winner for competition
	 * 
	 * @param winner - String - Name of new winner of competition
	 */
	public void setWinner(String winner)
	{
		this.winner = winner;
	}

	/**
	 * Gets the runner up's name in string form
	 * 
	 * @return runnerUp - String - name of competition runner up
	 */
	public String getRunnerUp()
	{
		return runnerUp;
	}

	/**
	 * sets new runner up for competition
	 * 
	 * @param runnerUp - String - new runner up of competition
	 */
	public void setRunnerUp(String runnerUp)
	{
		this.runnerUp = runnerUp;
	}

	/**
	 * gets year competition occured
	 * @return year - int - returns year of competition
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * sets new year for when competition happened
	 * @param year - int - year of competition
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

}
