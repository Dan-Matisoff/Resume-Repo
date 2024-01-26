import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class AnagramExtraCredit 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Hashtable<String, ArrayList<String>> dictionary = new Hashtable<String, ArrayList<String>>();
		Scanner dScan = new Scanner(new File("words.txt"));
		while(dScan.hasNext())
		{
			String process = dScan.next();
			String sig = getSignature(process);
			if (dictionary.get(sig) == null) dictionary.put(sig, new ArrayList<String>());
			dictionary.get(sig).add(process);
		}
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a word (or q to quit):");
		String input = scn.next();
		// Looping until a "q" is input
		while (!input.equals("q"))
		{	// Get the ArrayList from the Dictionary
			ArrayList<String> anag = dictionary.get(getSignature(input));
			// If there is a set of anagrams
			if (anag == null)
			{
				System.out.println("That word isn't in our dictionary.");
			}
			else if (anag.size() > 1) 
			{
				for (String s : anag)	//Print all but the one given
				{
					if (!s.equals(input)) System.out.print(s + " ");
				}
			}
			else	// If there is no set of anagrams
			{
				System.out.println("What? There are no Anagrams there!");
			}
			System.out.println("\nPlease enter a word (or q to quit):");
			input = scn.next();
		}
	}
	
	public static String getSignature(String input)
	{
		char[] arr = input.toLowerCase().toCharArray();
		Arrays.sort(arr);
		return String.copyValueOf(arr);
	}
}
