// LeetCode 8: String to Integer (atoi)
// https://leetcode.com/problems/string-to-integer-atoi/description/

public class Solution {

    public int myAtoi(String s) {
        // Base check for empty input
        if(s==null || s.length()==0) return 0;
        int i = 0, length = s.length();
        
        // Skip leading whitespace
        while(i<length && s.charAt(i) == ' ') i++;

        // Check the sign
        boolean isPositive = true;
        if(i<length && (s.charAt(i)== '-' || s.charAt(i) == '+')) {
            if(s.charAt(i) == '-') {
                isPositive = false;
            }
            i++;
        }

        // Build the number digit by digit
        int total = 0;
        while(i<length && Character.isDigit(s.charAt(i))) {
            // Handle overflow before adding the next digit
            if( (total > Integer.MAX_VALUE/10) || 
                (total == Integer.MAX_VALUE/10) && s.charAt(i)-'0' > 7 ) {
                    return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            total = total * 10 + (s.charAt(i)-'0');
            i++;
        }

        // Return final result with correct sign
        return (isPositive) ? total : total*(-1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // [Input, Expected Output] pairs
        Object[][] testCases = {
            {"42", 42},
            {"   -042", -42},
            {"1337c0d3", 1337},
            {"0-1", 0},
            {"words and 987", 0},
            {"-91283472332", Integer.MIN_VALUE}, // Underflow
            {"91283472332", Integer.MAX_VALUE},  // Overflow
            {"+-12", 0},                         // Invalid signs
            {"+1", 1},
            {"", 0},                             // Empty string
            {"   ", 0},                          // Only whitespace
            {"2147483647", Integer.MAX_VALUE},   // Edge value (2^31 - 1)
            {"-2147483648", Integer.MIN_VALUE}   // Edge value (-2^31)
        };

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            String input = (String) testCases[i][0];
            int expected = (int) testCases[i][1];
            int actual = solution.myAtoi(input);

            boolean passed = (actual == expected);
            if (!passed) {
                allPassed = false;
            }

            System.out.printf("Test %-2d | %s | Input: \"%s\" -> Expected: %d, Got: %d%n",
                    (i + 1),
                    passed ? "PASS" : "FAIL",
                    input,
                    expected,
                    actual
            );
        }

        System.out.println("\nResult: " + (allPassed ? "All tests passed!" : "Some tests failed."));
    }
}