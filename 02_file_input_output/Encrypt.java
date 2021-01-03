import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This program is run via command-line, with the file to be encrypted, and name of the encrypted copy of the file passed
 * as arguments for the program, for example:
 *     java Encrypt inputFile.txt encryptedFile.txt
 *     
 * The encryption key provided by user input in the console is used to encrypt the characters in the file.
 * 
 * @author Rajesh Sakhamuru
 * @version 5/22/2019 
 * 
 */
public class Encrypt 
{
	/**
	 *  this function takes a given key, the input file scanner and output file printwriter and 
	 *  encrypts the input file's characters based on the given key into the file being written to.
	 * */
	public static void encrypt(int key, Scanner fileIn, PrintWriter encWriter)
	{
		while (fileIn.hasNext())
		{
			String nxtLine = fileIn.nextLine();
			String encrNxtLine = "";
			for (int n = 0; n < nxtLine.length(); n++) 
			{
				int charAscii = (int)nxtLine.charAt(n);
				int newAscii = charAscii;
				if (charAscii >= 65 && charAscii <= 90) // capital letters
				{
					newAscii = (charAscii + (key));
					if (newAscii > 90)
					{
						newAscii = newAscii - 26;
					}
				}
				else if (charAscii >= 97 && charAscii <= 122) // lowercase letters
				{
					newAscii = (charAscii + (key));
					if (newAscii > 122)
					{
						newAscii = newAscii - 26;
					}
				}
				char encChar = (char)(newAscii);
				encrNxtLine += encChar;				
			}
			encWriter.println(encrNxtLine);
		}
	}
	
	/**
	 * this function takes user input of an integer Key and returns it
	 * */
	public static int getKey()
	{
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter an Integer Key: ");
		int key = userIn.nextInt() % 26; // for key to wrap around alphabet
		userIn.close();
		return key;
	}
	
	/**
	 * Main calls to get key and creates the scanners for input file and output file (via PrintWriter).
	 * Then the encrypt function is called and the file contents are output to another file with
	 * encrypted characters based on the key.
	 * 
	 * args[0] is the string name of the input file
	 * args[1] is the string name of the output file
	 * */
	public static void main(String[] args) 
	{
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		int key = getKey();
		
		Scanner fileIn = null; // initializes fileIn to empty
		try
		{
			// Attempt to open the file
			fileIn = new Scanner( new FileInputStream(inputFileName)); //assumes text file is in same directory as Encrypt.java file FOR LINUX
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found, this code is executed
			// and then the program exits
			System.out.println("File not found.");
			System.exit(0);
		}
		
		PrintWriter encWriter = null;
		try 
		{
			encWriter = new PrintWriter(outputFileName, "UTF-8"); // create output file
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}

		encrypt(key, fileIn, encWriter);

		encWriter.close();
	}
}