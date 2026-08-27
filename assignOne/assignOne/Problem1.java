package assignOne;

/*
 * Write the code to implement the stringToInt() method. This method should
 *  parse the string argument as a signed decimal integer. The characters in
 *  the string must all be decimal digits, except that the first character
 *  may be an ASCII minus sign '-' to indicate a negative value or an ASCII
 *  plus sign '+' to indicate a positive value. The resulting integer value
 *  is returned.
 *  
 * public static int stringToInt(String str)
 * Parameters:
 *  str - a String containing the int representation to be parsed
 * Returns:
 *  The integer value represented by the argument in decimal.
 *   
 * This method should perform the same as the Integer.parseInt() method in
 *  the Java library. For this problem, the only Java classes/methods that
 *  can be used are String.length(), String.charAt(), and String.equals().
 *  You cannot use any of the other classes or methods for this problem.
 */

public class Problem1 
{
	public static void main(String[] args) 
	{
		String str = "123";
		String str1 = "123a";
		String str2 = "1.0";
		String str3 = "1.0.";
		String str4 = "-321";
		String str5 = "+312";
		String str6 = " 123";		
		
		System.out.printf("%s, Returned %d\n", str, stringToInt(str));
		System.out.printf("%s, Returned %d\n", str1, stringToInt(str1));
		System.out.printf("%s, Returned %d\n", str2, stringToInt(str2));
		System.out.printf("%s, Returned %d\n", str3, stringToInt(str3));
		System.out.printf("%s, Returned %d\n", str4, stringToInt(str4));
		System.out.printf("%s, Returned %d\n", str5, stringToInt(str5));
		System.out.printf("%s, Returned %d\n", str6, stringToInt(str6));
	}
	
	public static final int[] NUMS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	public static final char[] CHAR_NUMS = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static int stringToInt(String str) 
	{
		str = removeWhiteSpace(str);
		int strLength = str.length();
		int sign = 1;
		int startPosition = 0;
		
		for (int i = 0; i < strLength; i++)
		{
			char ch = str.charAt(i);
			if (ch == '+' || ch == '-')
			{
				if (ch == '-' && startPosition == 0)
				{
					sign = -1;
					startPosition = i + 1;
				}
				else
				{
					if (startPosition != 0)
					{
						return 0;
					}
					startPosition = i + 1;
				}
			}
		}
		
		int endPosition = strLength;
		for (int i = startPosition; i < strLength; i++)
		{
			if (str.charAt(i) == '.')
			{
				return 0;
			}
			endPosition = i;
		}
	}
	
	public static int charIsNum(char ch)
	{
		for (int i = 0; i < CHAR_NUMS.length; i++)
		{
			if (ch == CHAR_NUMS[i])
				return i;
		}
		return -1;
	}
	
	public static String removeWhiteSpace(String str)
	{
		int leadingIndex = 0;
		int trailingIndex = str.length();
		
		for (; leadingIndex < trailingIndex; leadingIndex++)
		{
			char currChar = str.charAt(leadingIndex);
			if (currChar != ' ')
				break;
			leadingIndex = leadingIndex + 1;
		}
		
		for (trailingIndex--; trailingIndex >= 0; trailingIndex--)
		{
			char currChar = str.charAt(leadingIndex);
			if (currChar != ' ')
				break;			
		}
		
		String newString = "";
		
		for (int i = leadingIndex; i < trailingIndex; i++)
		{
			newString += str.charAt(i);
		}
		return newString;
	}

}
