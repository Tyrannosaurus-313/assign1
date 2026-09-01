package assignOne;

public class Problem1 {
    public static final String[] TEST_CASES = {
        " 952413",
        "-321",
        "+321",
        "  0123 ",
        "123 ",
        "2147483647", // 2^31 - 1
		"-2147483647", // -2^31 - 1
        "123a",
        "1.0",
        "-",
        "--300",
		"2147483648", // 2^31
		"2147483649", // 2^31 + 1
		"-2147483648", // -2^31
		"-2147483649" // -2^31 - 1
    };
    public static final int[] EXPECTED_RESULTS = {
        952413,
        -321,
        321,
        123,
        123,
        2147483647,
		-2147483647,
        0,
		0,
		0,
		0,
        0,
        0,
        0,
		0
    };

    public static void main(String[] args) {
    	for (int i = 0; i < TEST_CASES.length; i++) {
            String str = TEST_CASES[i];
			int result = stringToInt(str);
			int expectedResult = EXPECTED_RESULTS[i];
			if (result == expectedResult)
	            System.out.printf("PASS:    '%s' returned %d\n", str, result, expectedResult);
			else
	            System.out.printf("FAILURE: '%s', returned %d - should have been %d\n", str, result, expectedResult);
        }
    }

    public static int stringToInt(String str) {
        str = trim(str);

        int sign = 1;
        int start = 0;
        char firstCh = str.charAt(0);
        if (firstCh == '-') {
            start += 1;
            sign = -1;
        }
		else if (firstCh == '+') {
            start += 1;
        }

        int num = 0;
        boolean overflow = false;
		int end = str.length() - 1;
		int digit = 0;
		char ch = ' ';
        for (; start <= end; start++) {
            ch = str.charAt(start);
            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
                num = num * 10 + digit;
				
                if (num < 0) //less than 0 due to an int overflow
                    overflow = true;
            }
			else {
                num = 0;
                break;
            }
        }

        if (overflow) {
            num = 0;
        }

        return num * sign;
    }

    public static String trim(String str) {
		int strLength = str.length();
		int start = 0;
		int end = strLength - 1;

        for (; start < strLength && str.charAt(start) == ' '; start++) { }

        for (; end >= start && str.charAt(end) == ' '; end--) { }

        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
}