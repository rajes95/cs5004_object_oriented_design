import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This program takes as input the specified text file (as inputFileName) an unspecified list of numbers(doubles) 
 * separated by commas and calculates their Average, Minimum, Maximum and Variance.
 * 
 * @author Rajesh Sakhamuru
 * @version 5/22/2019
 *
 */
public class InputMath 
{
	
	public static void main(String[] args) 
	{
		int count = 0;
		double sum = 0;
		double avg = 0;
		double max = 0;
		double min = 0;
		double var = 0;
		String inputFileName = args[0];
		
		Scanner fileIn = null; // initializes fileIn to empty
		try
		{
			// Attempt to open the file
			fileIn = new Scanner(new FileInputStream(inputFileName)); //assumes text file is in same directory as Encrypt.java file FOR LINUX
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found, this code is executed
			// and then the program exits
			System.out.println("File not found.");
			System.exit(0);
		}
		
		fileIn.useDelimiter(",");
		
		while (fileIn.hasNext())
		{
			Double nxtNum = Double.parseDouble(fileIn.next().trim());
			
			if (count == 0)
			{
				max = nxtNum;
				min = nxtNum;
			}
			else if (max < nxtNum)
			{
				max = nxtNum;
			}
			else if (min > nxtNum)
			{
				min = nxtNum;
			}
			sum += nxtNum;
			count++;
		}
		fileIn.close();
		
		avg = sum/count;
		
		Scanner fileInVar = null; // initializes fileInVar to empty
		try
		{
			fileInVar = new Scanner( new FileInputStream(inputFileName));
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found, this code is executed
			// and then the program exits
			System.out.println("File not found.");
			System.exit(0);
		}
		
		fileInVar.useDelimiter(",");
		
		while (fileInVar.hasNext())
		{
			Double nxtNum = Double.parseDouble(fileInVar.next().trim());
			var += ((nxtNum - avg)*(nxtNum - avg));
		}
		fileInVar.close();
		
		var = var/(count-1);
		
		System.out.printf("Average:  %.4f\n", avg);
		System.out.printf("Minimum:  %.4f\n", min);
		System.out.printf("Maximum:  %.4f\n", max);
		System.out.printf("Variance: %.4f\n", var);
	}
}