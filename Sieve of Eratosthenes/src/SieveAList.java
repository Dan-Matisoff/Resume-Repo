import java.util.ArrayList;

/**
 * Runs the Sieve of Eratosthenes, using an ArrayList.
 * @author 23dmatisoff
 *
 */
public class SieveAList 
{
	private ArrayList<Integer> numList;
	
/**
 * Runs the Sieve of Eratosthenes
 * @param n largest number in ArrayList / Number Cap
 */
	public SieveAList(int n)
	{
		numList = new ArrayList<Integer>();
		if (n < 0)
		{
			n = n / (-1);
		}
		for (int i = 2; i <= n; i++)
		{
			numList.add(i);
		}
		
		for (int x = 0; x < numList.size(); x++)
		{
			int num = numList.get(x);
			boolean flag = false;
			if (num*num >= n)
			{
				x = numList.size();
			}
			for (int k = 0; k < numList.size(); k++)
			{
				int value = 0;
				if (numList.get(k) % num == 0)
				{
					value = numList.remove(k);
				}
				if (value == num)
				{
					numList.add(k,value);
				}
			}
		}
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < numList.size(); i++)
		{
			str += numList.get(i) + ",";
		}
		return str;
	}
}
