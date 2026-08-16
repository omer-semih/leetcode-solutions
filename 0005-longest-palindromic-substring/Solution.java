// LeetCode 5: Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    public String longestPalindrome(String s) {

        // best palindrome found so far
        int longestStart = 0, longestEnd = 0, longestLength = 0;
        int lastIndex = s.length() - 1;
        int left = 0, right = lastIndex;

        // try every starting index; prune if remaining window can't beat the record
        while (right - left + 1 >= longestLength) {
            int currentLeft = left;

            while (right > left && (right - left + 1 >= longestLength)) {

                // found a matching outer pair, try expanding inward
                if (s.charAt(left) == s.charAt(right)) {
                    int matchLeft = left;
                    int matchRight = right;

                    // expand toward the middle while chars keep matching
                    while (++left < --right && s.charAt(left) == s.charAt(right));

                    if (s.charAt(left) == s.charAt(right)) {
                        // valid palindrome, update record
                        if (matchRight - matchLeft + 1 > longestLength) {
                            longestStart = matchLeft;
                            longestEnd = matchRight;
                            longestLength = longestEnd - longestStart + 1;
                        }
                        break;
                    } else {
                        // false alarm, retry with a smaller right bound
                        left = matchLeft;
                        right = matchRight - 1;
                    }
                } else {
                    right--;
                }
            }

            // next starting index
            left = currentLeft + 1;
            right = lastIndex;
        }

        // +1 since substring's end index is exclusive
        return s.substring(longestStart, longestEnd + 1);
    }



    public static void main(String[] args)  {
        Solution sol = new Solution();

        System.out.println("cbbd -> " + sol.longestPalindrome("cbbd"));
        System.out.println("babad -> " + sol.longestPalindrome("babad"));
        System.out.println("a -> " + sol.longestPalindrome("a"));
        System.out.println("aa -> " + sol.longestPalindrome("aa"));
        System.out.println("ab -> " + sol.longestPalindrome("ab"));
        System.out.println("racecar -> " + sol.longestPalindrome("racecar"));
        System.out.println("abba -> " + sol.longestPalindrome("abba"));
        System.out.println("abcde -> " + sol.longestPalindrome("abcde"));
        System.out.println("aaaa -> " + sol.longestPalindrome("aaaa"));
        System.out.println("forgeeksskeegfor -> " + sol.longestPalindrome("forgeeksskeegfor"));
        System.out.println("abacdfgdcaba -> " + sol.longestPalindrome("abacdfgdcaba"));
        System.out.println("aaaaaaaaaa -> " + sol.longestPalindrome("aaaaaaaaaa"));

    }
}