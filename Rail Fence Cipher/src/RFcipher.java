/**
 * Encodes and Decodes a string with a Rail Fence Cipher
 * @author 23dmatisoff
 *
 */
public class RFcipher 
{

	private String input;
	private String encrypt;
	private String decrypt;
	
	/**
	 * Default Constructor,
	 * Sets 'input', 'encrypt', and 'decrypt' to empty strings
	 */
	public RFcipher()
	{
		input = "";
		encrypt = "";
		decrypt = "";
	}
	
	/**
	 * Constructor with String parameter,
	 * Initializes variables and runs the Encrypt and Decrypt methods
	 * @param str String plaintext
	 */
	public RFcipher(String str)
	{
		input = str;
		encrypt = "";
		decrypt = "";
		encrypt = encrypt(str);
		decrypt = decrypt(encrypt);
	}
	
	/**
	 * Encrypts Plaintext
	 * @param str String plaintext to encode
	 * @return Encrypted ciphertext
	 */
	public String encrypt(String str)
	{
		if (input == "")
		{
			input = str;
		}
		str = str.replace(" ", "");
		str = str.toUpperCase();
		String part1 = ""; // Initialize String
		String part2 = "";
		for (int i = 0; i <= str.length() - 1; i++) // Split the two strings into the two rows
		{
			if (i % 2 == 0) // Even
			{
				part1 += str.charAt(i);
			}
			else // Odd
			{
				part2 += str.charAt(i);
			}
		}
		encrypt = part1 + part2; // Concatenate
		return encrypt; // Return
	}
	
	/**
	 * Decrypts the Ciphertext
	 * @param str String ciphertext to decode
	 * @return recovered plaintext
	 */
	public String decrypt(String str)
	{
		String part1 = ""; // Initialize Strings
		String part2 = "";
		int half = (str.length() / 2); // Get the point to split the strings
		if (str.length() % 2 == 0)
		{
			half--;
		}
		for (int i = 0; i <= str.length() - 1; i++) // Split the strings
		{
			if (i <= half) // First half of the string (the even numbered ones)
			{
				part1 += str.charAt(i);
			}
			else // Second half of the string (the odd ones)
			{
				part2 += str.charAt(i);
			}
		}
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i <= str.length() - 1; i++) // Put them back together
		{
			if (i % 2 == 0) // If it's Even
			{
				decrypt += part1.charAt(count1);
				count1++;
				
			}
			else // If it's Odd
			{
				decrypt += part2.charAt(count2);
				count2++;
			}
		}
		return decrypt;
	}
	public String toString()
	{
		String temp = "Initial String: " + input + "\nEncrypted: " + encrypt + "\nDecrypted: " + decrypt;
		return temp;
	}
}
