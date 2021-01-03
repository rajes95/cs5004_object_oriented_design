import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This program is run via command-line, with the file to be decrypted, and name of the decrypted copy of the file passed
 * as arguments for the program, for example:
 *     java Decrypt encryptedFile.txt decryptedFile.txt
 *     
 * The decryption key provided by user input in the console is used to decrypt the characters in the file.
 * The key should be the same as the one used to encrypt the file in the first place. 
 * 
 * @author Rajesh Sakhamuru
 * @version 5/22/2019 
 * 
 */
public class Decrypt 
{
	/**
	 *  this function takes a given key, the input file scanner and output file printwriter and 
	 *  decrypts the input file's characters based on the given key into the file being written to.
	 * */
	public static void decrypt(int key, Scanner fileIn, PrintWriter decWriter)
	{
		while (fileIn.hasNext())
		{
			String nxtLine = fileIn.nextLine();
			String decrLine = "";
			for (int n = 0; n < nxtLine.length(); n++) 
			{
				int charAscii = (int)nxtLine.charAt(n);
				int newAscii = charAscii;
				if (charAscii >= 65 && charAscii <= 90) // Capital Letters
				{
					newAscii = (charAscii - (key));
					if (newAscii < 65)
					{
						newAscii = newAscii + 26;
					}
				}
				else if (charAscii >= 97 && charAscii <= 122) // Lowercase Letters
				{
					newAscii = (charAscii - (key));
					if (newAscii < 97)
					{
						newAscii = newAscii + 26;
					}
				}
				char decrChar = (char)(newAscii);
				decrLine += decrChar;				
			}
			decWriter.println(decrLine);
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
	 * Then the decrypt function is called and the file contents are output to another file with
	 * decrypted characters based on the key.
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
			fileIn = new Scanner( new FileInputStream(inputFileName)); //assumes text file is in same directory as Decrypt.java FOR LINUX
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found, this code is executed
			// and then the program exits
			System.out.println("File not found.");
			System.exit(0);
		}
		
		PrintWriter decWriter = null;
		try 
		{
			decWriter = new PrintWriter(outputFileName, "UTF-8");
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
		
		decrypt(key, fileIn, decWriter);

		decWriter.close();
	}
}