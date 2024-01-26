import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encrypts and Decrypts with the Ceaser Cipher.
 * Cannot include punctuation.
 * @author 23dmatisoff
 *
 */

public class CeaserEncrypt 
{
	private ArrayList<String> plaintext = new ArrayList<String>();
	private ArrayList<String> encryptedText = new ArrayList<String>();
	private ArrayList<String> decryptedText = new ArrayList<String>();
	
	/**
	 * Constructor; inputs an ArrayList and makes sure each ArrayList item is a word
	 * @param input ArrayList<String> Lines of plaintext
	 */
	public CeaserEncrypt(ArrayList<String> input)
	{
		for (int i = 0; i < input.size(); i++)
		{ // Iterates for every item in the input string (lines)
			String temp = input.get(i); // Temporary Variable
			Scanner inputScan = new Scanner(temp); // Scans the line
			while (inputScan.hasNext())
			{ // While there are more tokens (words) in the line
				plaintext.add(inputScan.next()); // Adds token to plaintext Array
			}
		}
	}
	
	/**
	 * Set Plaintext; runs Constructor code outside of the constructor
	 * @param input ArrayList<String> Lines of plaintext
	 */
	public void setFile(ArrayList<String> input)
	{
		plaintext.clear();
		for (int i = 0; i < input.size(); i++)
		{ // Iterates for every item in the input string (lines)
			String temp = input.get(i); // Temporary Variable
			Scanner inputScan = new Scanner(temp); // Scans the line
			while (inputScan.hasNext())
			{ // While there are more tokens (words) in the line
				plaintext.add(inputScan.next()); // Adds token to plaintext Array
			}
		}
	}
	
	/**
	 * Encrypts the stored Plaintext
	 */
	public void encryptFile()
	{
		encryptedText.clear(); // Clears the arraylist if there was already an encrypted text
		for (int i = 0; i < plaintext.size(); i++)
		{ // Iterates for every item in plaintext ArrayList
			String word = plaintext.get(i); // Item in plaintext Arraylist
			String tempWord = ""; // temporary string storage
			word = word.toUpperCase(); // Ensures that the string is uppercase
			for (int x = 0; x < word.length(); x++)
			{ // Iterates for every character in the word
				char letter = word.charAt(x); // Character at x
				int charNum = (int) letter; // ASCII value
				if (charNum < 65 || charNum > 90)
				{ // Checks if character is a letter
					charNum = 0; // Flags character as non-alpha
				}
				charNum -= 3; // Applys Ceaser Shift
				if (charNum < 65)
				{ // If it goes below the Alphabet
					charNum += 26; // Set it back within the range of the alphabet
				}
				if (charNum >= 65 && charNum <= 90)
				{ // If it is a character
					tempWord += (char) charNum; // Add to tempword
				}
				
			}
			encryptedText.add(tempWord); // Add tempword to encryptedText Array
		}
	}
	
	/**
	 * decrypts a Cesarian Shift Cipher
	 * @return ArrayList<String> The Decrypted File
	 */
	public ArrayList<String> decryptFile()
	{
		decryptedText.clear(); // Clears the arraylist if there was already an encrypted text
		for (int i = 0; i < encryptedText.size(); i++)
		{ // Iterates for every item in encryptedText ArrayList
			String word = encryptedText.get(i); // Item in encrypted Arraylist
			String tempWord = ""; // temporary string storage
			word = word.toUpperCase(); // Ensures that the string is uppercase
			for (int x = 0; x < word.length(); x++)
			{ // Iterates for every character in the word
				char letter = word.charAt(x); // Character at x
				int charNum = (int) letter; // ASCII value
				charNum += 3; // Undoes Ceaser Shift
				if (charNum > 90)
				{ // If it goes above the Alphabet
					charNum -= 26; // Set it back within the range of the alphabet
				}
				tempWord += (char) charNum; // Add to tempword
				
			}
			decryptedText.add(tempWord); // Add tempword to decryptedText Array
		}
		return decryptedText;
	}
	
	/**
	 * decrypts inserted cipher
	 * @return
	 */
	public ArrayList<String> decryptFile(ArrayList<String> input)
	{
		decryptedText.clear(); // Clears the arraylist if there was already an encrypted text
		for (int i = 0; i < input.size(); i++)
		{ // Iterates for every item in encryptedText ArrayList
			String word = input.get(i); // Item in encrypted Arraylist
			String tempWord = ""; // temporary string storage
			word = word.toUpperCase(); // Ensures that the string is uppercase
			for (int x = 0; x < word.length(); x++)
			{ // Iterates for every character in the word
				char letter = word.charAt(x); // Character at x
				int charNum = (int) letter; // ASCII value
				charNum += 3; // Undoes Ceaser Shift
				if (charNum > 90)
				{ // If it goes above the Alphabet
					charNum -= 26; // Set it back within the range of the alphabet
				}
				else if (charNum == 35)			// THIS ELSE IF LOOP WAS ADDED 2024
				{ // If it's a space
					charNum -= 3;	// Make it a space again
				}
				tempWord += (char) charNum; // Add to tempword
				
			}
			decryptedText.add(tempWord); // Add tempword to decryptedText Array
		}
		return decryptedText;
	}
	
	public String toString()
	{
		String temp = "";
		for (int i = 0; i < encryptedText.size(); i++)
		{
			temp += encryptedText.get(i) + " ";
		}
		return temp;
	}
}
