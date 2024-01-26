import java.util.ArrayList;
import java.util.Scanner;

/**
 * Initial Project Driver circa 2021-2022
 */

public class CeaserDriver 
{
	public static void main(String[] args)
	{
		System.out.println("Enter either \"File\" or \"Console\": "); // Print Instructions
		Scanner strScan = new Scanner(System.in); // Create String Scanner
		String choice = strScan.next(); // User Input: Input Type
		ArrayList<String> text = new ArrayList<String>(); // Create Plaintext Array
		if (choice.equalsIgnoreCase("file")) 
		{	// User Choice: Input File
			System.out.println("Enter Text File Name: "); // Print Instructions
			String name = strScan.next(); // User Input: Name of the File
			if (name.charAt(name.length()-4) != '.' || name.charAt(name.length()-3) != 't' || name.charAt(name.length()-2) != 'x' || name.charAt(name.length()-1) != 't')
			{	// Check for a '.txt' ending 
				name += ".txt"; // Append .txt if missing
			}
			text = FileIOexample.readInFromFile(name);
		}
		else if (choice.equalsIgnoreCase("console"))
		{	//User Choice: Input to Console
			System.out.println("Enter Plaintext (Click Enter again to Finish): "); // Print Instructions
			Scanner wordScan = new Scanner(System.in);
			String word = wordScan.nextLine(); // Get next line
			while (!word.equals(""))
			{	// While the user inputs data
				text.add(word); // Add the line to the text ArrayList
				word = wordScan.nextLine(); // Get another line of data
			}
		}
		else
		{ // Failsafe
			System.out.println("Try Again. (Re run the program)");
		}
		CeaserEncrypt file = new CeaserEncrypt(text); // Run CeaserEncrypt Constructor
		file.encryptFile(); // Run encrypt function
		System.out.println("Encrypted Text: " + file); // Print Results
		ArrayList<String> decrypted = file.decryptFile(); // Run decrypt function
		String message = ""; // Initialize Message Variable
		for (int i = 0; i < decrypted.size(); i++)
		{ // Iterates for each item in decrypted
			message += decrypted.get(i) + " "; // Place item in message variable
		}
		System.out.println("Decrypted Text: " + message); // Print Results
	
		// Frequency Analysis
		System.out.println("Frequency Analysis\n\nEnter either \"File\" or \"Console\": "); // Print Instructions
		choice = strScan.next(); // User Input: Input Type
		text.clear(); // Clear the text
		if (choice.equalsIgnoreCase("file")) 
		{	// User Choice: Input File
			System.out.println("Enter CIPHERtext File Name: "); // Print Instructions
			String name = strScan.next(); // User Input: Name of the File
			if (name.charAt(name.length()-4) != '.' || name.charAt(name.length()-3) != 't' || name.charAt(name.length()-2) != 'x' || name.charAt(name.length()-1) != 't')
			{	// Check for a '.txt' ending 
				name += ".txt"; // Append .txt if missing
			}
			text = FileIOexample.readInFromFile(name);
		}
		else if (choice.equalsIgnoreCase("console"))
		{	//User Choice: Input to Console
			System.out.println("Enter CIPHERtext (Click Enter again to Finish): "); // Print Instructions
			Scanner wordScan = new Scanner(System.in);
			String word = wordScan.nextLine(); // Get next line
			while (!word.equals(""))
			{	// While the user inputs data
				text.add(word); // Add the line to the text ArrayList
				word = wordScan.nextLine(); // Get another line of data
			}
		}
		else
		{ // Failsafe
			System.out.println("Try Again. (Re run the program)");
		}
		
		FrequencyAnalysis freqA = new FrequencyAnalysis(text); // Make the Object
		ArrayList<String> decodedText = freqA.decode(); // Run the Decode Function
		System.out.println("\n***********************\n\nIS THIS YOUR TEXT?\n");
		for (int i = 0; i < decodedText.size(); i++)
		{
			System.out.println(decodedText.get(i) + "");
		}
	}
}
