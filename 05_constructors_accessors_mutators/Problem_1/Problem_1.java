import teamRecords.Team;
import teamRecords.Competition;

/**
 * 
 * Problem_1.java
 * 
 * This class file contains a main function whose purpose is to test the Team
 * class and vis-a-vis the Competition class as well located in the teamRecords
 * package.
 * 
 * The team class is used to keep track of the team members and competition
 * information for a school's entries in programming competitions.
 * 
 * @author Rajesh Sakhamuru
 * @version 6/13/2019
 * 
 */
public class Problem_1
{

	/**
	 * 
	 * In order to test the Team and Competition, a Team, "lhs" is initialized along
	 * with 3 competitions.
	 * 
	 * A deep copy is created and then modified called "lhs_copy" and both it and
	 * the original are printed out (using toString() print statements) to verify
	 * that the changes did not impact the original "lhs" Team.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{

		Team lhs = new Team("Vikings", "Son Heung-min", "Luigi Mario", 
				"Rafael Nadal", "James Bond");

		Competition eastBowl = new Competition("East Bowl", lhs.getName1(), 
				lhs.getName2(), 2001);
		Competition westBowl = new Competition("West Bowl", lhs.getName3(),
				lhs.getName4(), 2002);
		Competition cleganeBowl = new Competition("Clegane Bowl", 
				"Sandor Clegane", "Ser Gregor Clegane", 2003);

		lhs.setCompetition1(eastBowl);
		lhs.setCompetition2(westBowl);

		System.out.println("LHS_Team: \n--------\n" + lhs);

		Team lhs_copy = new Team(lhs);

		// Modify lhs_copy (consequently also testing setters)
		lhs_copy.setTeamName("Bad Intentions");
		lhs_copy.setCompetition1(cleganeBowl);
		lhs_copy.getCompetition1().setYear(2019);
		lhs_copy.setName1(cleganeBowl.getWinner());
		lhs_copy.setName2(cleganeBowl.getRunnerUp());
		lhs_copy.setName4("007");

		System.out.println("LHS_Team Copy after Changes: \n--------\n" + lhs_copy);
		System.out.println("LHS_Team after Changes: \n--------\n" + lhs);
	}

}
