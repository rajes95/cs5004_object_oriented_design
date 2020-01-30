import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Problem_2.java
 * 
 * Given the two textfiles boynames.txt and girlnames.txt, which contain the
 * 1000 most popular boy and girl names respectively in 2005 in the USA, the
 * names in common between the 2 genders are determined and printed.
 * 
 * A hashSet is used to compare the lists, and an arrayList is used to store
 * common names.
 * 
 * @author Rajesh Sakhamuru
 * @version 8/6/2019
 * 
 */
public class Problem_2
{
	public static void main(String[] args)
	{
		try
		{
			// take both files and scan them. If files not found, an exception is thrown and
			// caught
			File boynames = new File("boynames.txt");
			File girlnames = new File("girlnames.txt");

			Scanner boys = new Scanner(boynames);
			Scanner girls = new Scanner(girlnames);

			HashSet<String> names = new HashSet<>();
			ArrayList<String> commonNames = new ArrayList<>();

			// all girls names, and excluding counts, are added to the hashSet
			while (girls.hasNextLine())
			{
				String temp = girls.nextLine();

				String girlName[] = temp.split("[ ]");

				names.add(girlName[0]);

			}

			// boys names are added to the names hashSet as well, and redundant/common names
			// are added to the commonNames ArrayList
			while (boys.hasNextLine())
			{
				String temp = boys.nextLine();

				String boyName[] = temp.split("[ ]");

				if (!names.add(boyName[0]))
				{
					commonNames.add(boyName[0]);
				}
			}

			// all common names are printed.
			for (String name : commonNames)
			{
				System.out.println(name);
			}

			System.out.println(commonNames.size() + " Names in Common.");

			boys.close();
			girls.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: FILE NOT FOUND EXCEPTION.");
			e.printStackTrace();
		}

	}

}
