package assignOne;

public class Problem2 
{

	public static void main(String[] args) 
	{
		int value = -12345;
		System.out.printf("Inputed %d Returned \"%s\"", value, intToString(value));
	}
	
	public static String intToString(int value) 
	{
		return new String() + value;
	}

}
