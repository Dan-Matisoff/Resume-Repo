import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to run Frequency Analysis on an inputted coded Arraylist
 * @author 23dmatisoff
 *
 */
public class FrequencyAnalysis 
{
	private ArrayList<String> encodedText; // Encoded Text
	private ArrayList<String> decodedText; // Decoded Text
	private int[] analyzeArray; // Array of every letter in the alphabet
	private final ArrayList<String> DICTIONARY = FileIOexample.readInFromFile("Dictionary1.txt");
	private ArrayList<String> wordText; // placeholder Decoded Text in word format
	
	/**
	 * Default Constructor;
	 * Initializes variables to their default states
	 */
	public FrequencyAnalysis()
	{
		encodedText = new ArrayList<String>();
		decodedText = new ArrayList<String>();
		analyzeArray = new int[26];
		wordText = new ArrayList<String>();
	}
	
	/**
	 * Constructor;
	 * Initializes with an Input as encoded text.
	 * @param input ArrayList<String> Encoded Text
	 */
	public FrequencyAnalysis(ArrayList<String> input)
	{
		encodedText = input;
		decodedText = new ArrayList<String>();
		analyzeArray = new int[26];
		wordText = new ArrayList<String>();
	}
	
	/**
	 * Sets the Encoded Text
	 * @param input ArrayList<String> Encoded Text
	 */
	public void setEncodedText(ArrayList<String> input)
	{
		encodedText = input;
	}
	 /**
	  * Runs frequency analysis, and decodes the Encoded Text
	  * @return
	  */
	public ArrayList<String> decode()
	{
		for (int i = 0; i < encodedText.size(); i++) // Creates Alphabet Frequency Array
		{ // Iterates for every token in Encoded Text
			String line = encodedText.get(i); // Grabs the line of encoded text
			Scanner wordScan = new Scanner(line); // Scans the line
			while (wordScan.hasNext())
			{ // While there are more words
				String word = wordScan.next(); // get Next Word
				wordText.add(word);
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every letter in the Encoded Word
					char letter = word.toUpperCase().charAt(x); // Gets the Letter of the Encoded Word
					int letterNum = (int) letter; // Gets ASCII Value
					letterNum -= 65; // Gets the number of the alphabet it is
					if (letterNum >= 0 && letterNum < 27)
					{
						//analyzeArray[letterNum] += String.valueOf(word.toUpperCase().charAt(x)); //Adds the letter to its slot in an array
						analyzeArray[letterNum] ++;
					}
				}
			}
		}
		int mFreq = 0;
		for (int i = 0; i < analyzeArray.length; i++) // Bubble Sort Frequency Array
		{ // For every item in the alphabet
			if (analyzeArray[i] > analyzeArray[mFreq])
			{ // if the i value is more frequent than the mostFrequent value
				mFreq = i;
			}
		}
		
		mFreq++; // Increment due to zero based indexing, becomes number not letter
		
		//String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String cAlpha = "";
		// REMEMBER E = INDEX 4, NUMBER 5
		// RECODE THIS
		int shift = mFreq - 5; // Find the distance between the Most Frequent Letter and E
		if (shift < 0)
		{ // Test for if it goes below the alphabet
			shift += 26;
		}
		
		// mFreq = E
		for (int i = 0; i < wordText.size(); i++)
		{ // Iterates for every item in encodedText ArrayList
			String word = wordText.get(i); // Item in encoded Arraylist
			String tempWord = ""; // temporary string storage
			word = word.toUpperCase(); // Ensures that the string is uppercase
			for (int x = 0; x < word.length(); x++)
			{ // Iterates for every character in the word
				char letter = word.charAt(x); // Character at x
				int charNum = (int) letter; // ASCII value
				charNum -= shift; // Undoes Shift
				if (charNum < 65)
				{ // If it goes below the Alphabet
					charNum += 26; // Set it back within the range of the alphabet
				}
				tempWord += (char) charNum; // Add to tempword
				
			}
			decodedText.add(tempWord); // Add tempword to decryptedText Array
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum += shift; // Undoes Shift
					if (charNum > 90)
					{ // If it goes above the Alphabet
						charNum -= 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq - 20; // Check for T
			if (shift < 0)
			{ // Test for if it goes below the alphabet
				shift += 26;
			}
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum -= shift; // Undoes Shift
					if (charNum < 65)
					{ // If it goes above the Alphabet
						charNum += 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum += shift; // Undoes Shift
					if (charNum > 90)
					{ // If it goes above the Alphabet
						charNum -= 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq; // Check for A
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum -= shift; // Undoes Shift
					if (charNum < 65)
					{ // If it goes above the Alphabet
						charNum += 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq; // Check for A
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum += shift; // Undoes Shift
					if (charNum > 90)
					{ // If it goes above the Alphabet
						charNum -= 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq - 15; // Check for O
			if (shift < 0)
			{ // Test for if it goes below the alphabet
				shift += 26;
			}
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum -= shift; // Undoes Shift
					if (charNum < 65)
					{ // If it goes above the Alphabet
						charNum += 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq - 15; // Check for O
			if (shift < 0)
			{ // Test for if it goes below the alphabet
				shift += 26;
			}
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum += shift; // Undoes Shift
					if (charNum > 90)
					{ // If it goes above the Alphabet
						charNum -= 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq - 20; // Check for I
			if (shift < 0)
			{ // Test for if it goes below the alphabet
				shift += 26;
			}
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum -= shift; // Undoes Shift
					if (charNum < 65)
					{ // If it goes above the Alphabet
						charNum += 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{ // If the first two are not words
			decodedText.clear();
			shift = mFreq - 20; // Check for I
			if (shift < 0)
			{ // Test for if it goes below the alphabet
				shift += 26;
			}
			for (int i = 0; i < wordText.size(); i++)
			{ // Iterates for every item in encodedText ArrayList
				String word = wordText.get(i); // Item in encoded Arraylist
				String tempWord = ""; // temporary string storage
				word = word.toUpperCase(); // Ensures that the string is uppercase
				for (int x = 0; x < word.length(); x++)
				{ // Iterates for every character in the word
					char letter = word.charAt(x); // Character at x
					int charNum = (int) letter; // ASCII value
					charNum += shift; // Undoes Shift
					if (charNum > 90)
					{ // If it goes above the Alphabet
						charNum -= 26; // Set it back within the range of the alphabet
					}
					tempWord += (char) charNum; // Add to tempword
					
				}
				decodedText.add(tempWord); // Add tempword to decryptedText Array
			}
		}
		
		/*
		int mostFrequent = (int) analyzeArray[analyzeArray.length - 1].charAt(0); // Initializes the mostFrequent variable at the most Frequent number
		int shift = mostFrequent - 5; // Gets the shift from E
		decodedText.clear(); // Clears the arraylist if there was already an encrypted text
		for (int i = 0; i < encodedText.size(); i++)
		{ // Iterates for every item in encodedText ArrayList
			String word = encodedText.get(i); // Item in encoded Arraylist
			String tempWord = ""; // temporary string storage
			word = word.toUpperCase(); // Ensures that the string is uppercase
			for (int x = 0; x < word.length(); x++)
			{ // Iterates for every character in the word
				char letter = word.charAt(x); // Character at x
				int charNum = (int) letter; // ASCII value
				charNum += shift; // Undoes Shift
				if (charNum > 90)
				{ // If it goes above the Alphabet
					charNum -= 26; // Set it back within the range of the alphabet
				}
				tempWord += (char) charNum; // Add to tempword
				
			}
			decodedText.add(tempWord); // Add tempword to decryptedText Array
		}
		
		if (!DICTIONARY.contains(decodedText.get(0)) || !DICTIONARY.contains(decodedText.get(1)))
		{
			mostFrequent = 0;
			for (int i = 0; i < analyzeArray.length; i++)
			{ // For every item in the alphabet
				if (analyzeArray[mostFrequent].length() < analyzeArray[i].length())
				{ // if the i value is more frequent than the mostFrequent value
					mostFrequent = i; // Sets mostFrequent as i
				}
			}
			mostFrequent = mostFrequent - 1;
		}
		*/
		return decodedText;
		
		
	}
	
	public String toString()
	{
		String temp = "The encoded file is: \n";
		for (int i = 0; i < encodedText.size(); i++)
		{
			temp += encodedText.get(i) + " ";
		}
		temp += "\n\nAnd the Decoded File (if available) is: \n";
		for (int i = 0; i < decodedText.size(); i++)
		{
			temp += decodedText.get(i);
		}
		return temp;
	}
}
