class Solution {
    public boolean isMatch(String s, String p) {
        
    }

    public static void main(String[] args){
        String input1 = "aa";
        String input2 = "ab";
        String input3 = "aab";
        String input4 = "mississippi";
        String input5 = "abcde";
        String input6 = "b";
        String input7 = "ab";
        String input8 = "aaa";
        String input9 = "hello";
        
        String pattern1 = "a*";
        String pattern2 = ".*";
        String pattern3 = "c*a*b";
        String pattern4 = "mis*is*ip*.i";
        String pattern5 = "a.*e";
        String pattern6 = "a*b";
        String pattern7 = ".*..";
        String pattern8 = "ab*a*c*a";
        String pattern9 = "hel*o";
    }
}
1 2 3

11,12,13
21,22,23
31,32,33
/*
"aa"                    "a*"
"ab"                    ".*"
"aab"                   "c*a*b"
"mississippi"           "mis*is*ip*.i"
"abcde"                 "a.*e"
"b"                     "a*b"
"ab"                    ".*.."
"aaa"                   "ab*a*c*a"
"hello"                 "hel*o"
*/