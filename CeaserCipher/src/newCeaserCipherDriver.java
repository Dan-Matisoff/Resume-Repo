import java.util.ArrayList;
import java.util.Scanner;

public class newCeaserCipherDriver 
{

	public static void main(String[] args) 
	{
		System.out.println("Please enter either \"Encode,\" \"Decode,\" or \"Frequency Analysis\" :"); // Print Instructions
		Scanner strScan = new Scanner(System.in); // Create String Scanner
		String choice = strScan.next();			// Get Choice
		choice = choice.toLowerCase();			// Standardize choice
		
		switch (choice)
		{
		case "encode":
		case "e":
		// Encode
		ArrayList<String> text = new ArrayList<String>(); // Create Plaintext Array
		System.out.println("Enter Plaintext (Click Enter twice to Finish): "); // Print Instructions
		Scanner wordScan = new Scanner(System.in);
		String word = wordScan.nextLine(); // Get next line
		while (!word.equals(""))
		{	// While the user inputs data
			text.add(word); // Add the line to the text ArrayList
			word = wordScan.nextLine(); // Get another line of data
		}	
		CeaserEncrypt file = new CeaserEncrypt(text); // Run CeaserEncrypt Constructor
		file.encryptFile(); // Run encrypt function
		System.out.println("Encrypted Text: " + file); // Print Results
		break;
		
		case "decode":
		case "d":
		// Decode
			ArrayList<String> dtext = new ArrayList<String>(); // Create Ciphertext Array
			System.out.println("Enter Encrypted (Click Enter twice to Finish): "); // Print Instructions
			Scanner dwordScan = new Scanner(System.in);
			String dword = dwordScan.nextLine(); // Get next line
			while (!dword.equals(""))
			{	// While the user inputs data
				dtext.add(dword); // Add the line to the text ArrayList
				dword = dwordScan.nextLine(); // Get another line of data
			}	
			CeaserEncrypt dfile = new CeaserEncrypt(dtext); // Run CeaserEncrypt Constructor
			ArrayList<String> decrypted = dfile.decryptFile(dtext); // Run decrypt function
			String message = ""; // Initialize Message Variable
			for (int i = 0; i < decrypted.size(); i++)
			{ // Iterates for each item in decrypted
				message += decrypted.get(i) + " "; // Place item in message variable
			}
			System.out.println("Decrypted Text: " + message); // Print Results
		break;
		
		}
	}

}
