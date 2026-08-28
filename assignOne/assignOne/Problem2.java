package assignOne;

public class Problem2 
{	
    public static final int[] TEST_CASES = {
        0,
        952413,
        123,
        1,
        -1,
        -321,
        321,
        2147483647,
		-2147483647,
    };
	public static final String[] EXPECTED_RESULTS = {
        "0",
        "952413",
        "123",
        "1",
        "-1",
        "-321",
        "321",
        "2147483647", // 2^31 - 1
		"-2147483647", // -2^31 - 1
    };

	public static void main(String[] args) 
	{
		int value = -12345;
		System.out.printf("Inputed %d Returned \"%s\"", value, intToString(value));

		for (int i = 0; i < TEST_CASES.length; i++) 
		{
            int str = TEST_CASES[i];
			String result = intToString(str);
			String expectedResult = EXPECTED_RESULTS[i];
			if (result.equals(expectedResult))
				System.out.printf("PASS:    '%d' returned %s\n", str, result, expectedResult);
			else
				System.out.printf("FAILURE: '%d', returned %s - should have been %s\n", str, result, expectedResult);
		}
	}
	
	public static String intToString(int value) 
	{
        char[] result = new char[11];
		int position = 0;
		int remainder = Math.abs(value);
			
		for (; position < 11 && remainder > 0; position++)
		{
			int modulus = remainder % 10;
			result[10 - position] = (char)('0' + modulus);
			remainder /= 10;
		}

		if (value < 0)
		{
			result[10 - position] = '-';
			position++;
		}
		
		return new String(result, 11 - position, position);
	}
}
