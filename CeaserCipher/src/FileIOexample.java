import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOexample
{
	public static void main(String[] args)
	{
		String str = "one\n" + "two\n" + "three\n";
		
		writeFile("whatever.txt", str);
		
		/*
		ArrayList<String> text = readInFromFile("paulRevere.txt");
		
		for(int i = 0; i < text.size(); i++)
		{
			System.out.println(i + " " + text.get(i) + "\n");
		}
		*/
	}
	
	
	/**
	 * readInFromFile takes a string that is the filename as the parameter
	 * and will return the file contents in an arraylist with each line
	 * of text on 1 string in the arraylist
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readInFromFile( String fileName)
	{
		ArrayList<String> linesOfText = new ArrayList<String>();
		String line, word;
		
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(input.hasNext())
		{
			line = input.nextLine();
			linesOfText.add(line.toUpperCase());
		}	
		
		
		return linesOfText;
	}
	
	/*
	 * write out to a file of the name that is specified by the method
	 * oFileName is the name of the file to be written
	 * including the extension
	 * data is the string to be written to file
	 */
	public static void writeFile(String oFileName, String data) 
	{
	    try
	    {
	        BufferedWriter out = new BufferedWriter(new FileWriter(oFileName));
	        out.write(data + "\n");
	        out.close();
	    } catch (IOException e) {}
	}

}
