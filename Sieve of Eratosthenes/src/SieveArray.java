/**
 * The Sieve of Eratosthenes, using an Array
 * @author 23dmatisoff
 *
 */
public class SieveArray 
{
	private int[] sieve;
	
	/**
	 * Runs the Sieve of Eratosthenes
	 * @param n largest number in the Array / Size of Array
	 */
	public SieveArray(int n)
	{
		if (n < 0)
		{
			n = n / (-1);
		}
		sieve = new int[(n + 1)];
		for (int i = 0; i < sieve.length; i++)
		{
			sieve[i] = i;
		}
		sieve[0] = 0;
		sieve[1] = 0;
		
		for (int x = 2; x < sieve.length; x++)
		{
			if (x*x >= n)
			{
				break;
			}
			for (int k = (x + 1); k < sieve.length; k++)
			{
				if (sieve[k] % x == 0)
				{
					sieve[k] = 0;
				}
			}
		}
		
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < sieve.length; i++)
		{
			if (sieve[i] != 0)
			{
				str += sieve[i] + ",";
			}
		}
		return str;
	}
}
