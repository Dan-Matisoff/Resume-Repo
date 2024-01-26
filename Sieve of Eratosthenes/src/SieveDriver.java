import java.util.Scanner;

// Use the Sieve of Eratosthenes to find all primes between 0 and n

public class SieveDriver 
{

	public static void main(String[] args) 
	{
		System.out.println("Please Input a length n of the sieve: ");
		Scanner scanInt = new Scanner(System.in); // Scanner to get Input
		int input = scanInt.nextInt(); // Place output into a variable
		SieveArray theArray = new SieveArray(input); // Create Array Object
		System.out.println("\n*************************************\n"); // Separator
		System.out.println(theArray); // Print Array Object
		System.out.println("\n*************************************\n"); // Separator
		SieveAList theList = new SieveAList(input); // Create ArrayList Object
		System.out.println(theList); // Print ArrayList Object
		System.out.println("\n*************************************\n"); // Separator
		System.out.println("The Array was easier to work with due to familiarity,"			// Which was easier to work with?
				+ " but the ArrayList was simpler and worked better for the task at hand."
				+ " \nIt was also more flexible and dynamic."); // Findings
	}

}
