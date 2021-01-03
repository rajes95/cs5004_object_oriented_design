package teamRecords;

/**
 * This class creates a record of a Team with 4 members who competed in 2
 * competitions.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 */
public class Team
{
	// Name for the team
	private String teamName;
	// Names for each team members.
	private String name1, name2, name3, name4;
	// Info on each competition
	private Competition competition1 = new Competition();
	private Competition competition2 = new Competition();

	/**
	 * 
	 * Initializer for the Team which takes a team name, 4 member names and the 2
	 * competitions they competed in.
	 * 
	 * @param teamName
	 * @param name1
	 * @param name2
	 * @param name3
	 * @param name4
	 * @param competition1 - Competition object
	 * @param competition2 - Competition object
	 */
	public Team(String teamName, String name1, String name2, String name3, String name4, Competition competition1,
			Competition competition2)
	{
		this.setTeamName(teamName);
		this.setName1(name1);
		this.setName2(name2);
		this.setName3(name3);
		this.setName4(name4);
		this.setCompetition1(competition1);
		this.setCompetition2(competition2);
	}

	/**
	 * 
	 * Initializer for the Team which takes a team name and 4 member names. It does
	 * not take the 2 competitions they competed in and they default to empty
	 * competition initializers.
	 * 
	 * @param teamName
	 * @param name1
	 * @param name2
	 * @param name3
	 * @param name4
	 */
	public Team(String teamName, String name1, String name2, String name3, String name4)
	{
		this.setTeamName(teamName);
		this.setName1(name1);
		this.setName2(name2);
		this.setName3(name3);
		this.setName4(name4);
	}

	/**
	 * 
	 * Makes a deap copy of another Team object.
	 * 
	 * @param team - attributes of team are re-set to the new team.
	 */
	public Team(Team team)
	{
		if (team == null)
		{
			System.out.println("Fatal error.");
			System.exit(0);
		}
		this.setTeamName(team.getTeamName());
		this.setName1(team.getName1());
		this.setName2(team.getName2());
		this.setName3(team.getName3());
		this.setName4(team.getName4());
		this.setCompetition1(team.getCompetition1());
		this.setCompetition2(team.getCompetition2());

	}

	/**
	 * toString overrides the default toString method for use in print statements
	 * 
	 * @return str - String describing Team
	 * 
	 */
	public String toString()
	{
		String str = "";

		str += "Team name: " + teamName + "\n\nMembers:\n   " + name1 + "\n   " + name2 + "\n   " + name3 + "\n   "
				+ name4 + "\n\n" + competition1 + "\n" + competition2 + "--------------------------\n\n";

		return str;
	}

	/**
	 * 
	 * returns Team Name String
	 * 
	 * @return teamName
	 */
	public String getTeamName()
	{
		return teamName;
	}

	/**
	 * sets new team name string.
	 * 
	 * @param teamName - name to change this.teamName to.
	 */
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	/**
	 * returns name of first member
	 * 
	 * @return name of first member
	 */
	public String getName1()
	{
		return name1;
	}

	/**
	 * sets name1 and changes competition entry if name being changed is a winner or
	 * runner up of either competition.
	 * 
	 * @param name1
	 */
	public void setName1(String name1)
	{

		if (this.name1 == this.getCompetition1().getRunnerUp())
		{
			this.getCompetition1().setRunnerUp(name1);
		}
		else if (this.name1 == this.getCompetition1().getWinner())
		{
			this.getCompetition1().setWinner(name1);
		}

		if (this.name1 == this.getCompetition2().getRunnerUp())
		{
			this.getCompetition2().setRunnerUp(name1);
		}
		else if (this.name1 == this.getCompetition2().getWinner())
		{
			this.getCompetition2().setWinner(name1);
		}

		this.name1 = name1;
	}

	/**
	 * name of second member
	 * 
	 * @return name2 - name of second member
	 */
	public String getName2()
	{
		return name2;
	}

	/**
	 * sets name 2 and changes competition entry if name being changed is a winner
	 * or runner up of either competition.
	 * 
	 * @param name2
	 */
	public void setName2(String name2)
	{
		if (this.name2 == this.getCompetition1().getRunnerUp())
		{
			this.getCompetition1().setRunnerUp(name2);
		}
		else if (this.name2 == this.getCompetition1().getWinner())
		{
			this.getCompetition1().setWinner(name2);
		}

		if (this.name2 == this.getCompetition2().getRunnerUp())
		{
			this.getCompetition2().setRunnerUp(name2);
		}
		else if (this.name2 == this.getCompetition2().getWinner())
		{
			this.getCompetition2().setWinner(name2);
		}

		this.name2 = name2;

	}

	/**
	 * gets name of third member
	 * 
	 * @return name3 - name of third member
	 */
	public String getName3()
	{
		return name3;
	}

	/**
	 * sets name 3 and changes competition entry if name being changed is a winner
	 * or runner up of either competition.
	 * 
	 * @param name3
	 */
	public void setName3(String name3)
	{
		if (this.name3 == this.getCompetition1().getRunnerUp())
		{
			this.getCompetition1().setRunnerUp(name3);
		}
		else if (this.name3 == this.getCompetition1().getWinner())
		{
			this.getCompetition1().setWinner(name3);
		}

		if (this.name3 == this.getCompetition2().getRunnerUp())
		{
			this.getCompetition2().setRunnerUp(name3);
		}
		else if (this.name3 == this.getCompetition2().getWinner())
		{
			this.getCompetition2().setWinner(name3);
		}

		this.name3 = name3;
	}

	/**
	 * gets name of fourth member
	 * 
	 * @return name4 - name of 4th member
	 */
	public String getName4()
	{
		return name4;
	}

	/**
	 * sets name 4 and changes competition entry if name being changed is a winner
	 * or runner up of either competition.
	 * 
	 * @param name4
	 */
	public void setName4(String name4)
	{
		if (this.name4 == this.getCompetition1().getRunnerUp())
		{
			this.getCompetition1().setRunnerUp(name4);
		}
		else if (this.name4 == this.getCompetition1().getWinner())
		{
			this.getCompetition1().setWinner(name4);
		}

		if (this.name4 == this.getCompetition2().getRunnerUp())
		{
			this.getCompetition2().setRunnerUp(name4);
		}
		else if (this.name4 == this.getCompetition2().getWinner())
		{
			this.getCompetition2().setWinner(name4);
		}

		this.name4 = name4;
	}

	/**
	 * gets competition1 object and returns it.
	 * 
	 * @return competition1 - object of first competition data
	 */
	public Competition getCompetition1()
	{

		return competition1;
	}

	/**
	 * creates a deep copy of the parameter competition1 and sets it to
	 * this.competition1
	 * 
	 * @param competition1 - Competition object
	 */
	public void setCompetition1(Competition competition1)
	{
		if (competition1 == null)
		{
			System.out.println("Fatal error.");
			System.exit(0);
		}
		this.competition1.setName(competition1.getName());
		this.competition1.setRunnerUp(competition1.getRunnerUp());
		this.competition1.setWinner(competition1.getWinner());
		this.competition1.setYear(competition1.getYear());

	}

	/**
	 * gets competition2 object and returns it.
	 * 
	 * @return competition2 - object of second competition data
	 */
	public Competition getCompetition2()
	{
		return competition2;
	}

	/**
	 * creates a deep copy of the parameter competition1 and sets it to
	 * this.competition1
	 * 
	 * @param competition1 - Competition object
	 */
	public void setCompetition2(Competition competition2)
	{
		if (competition2 == null)
		{
			System.out.println("Fatal error.");
			System.exit(0);
		}
		this.competition2.setName(competition2.getName());
		this.competition2.setRunnerUp(competition2.getRunnerUp());
		this.competition2.setWinner(competition2.getWinner());
		this.competition2.setYear(competition2.getYear());
	}

}
