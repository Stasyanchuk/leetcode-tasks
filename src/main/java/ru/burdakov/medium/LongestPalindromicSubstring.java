package ru.burdakov.medium;

/**
 * NOT RESOLVED
 * <p>
 * Time Limit Exceeded
 * Test 95/141
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

//        String s = "aacabdkacaa";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s = "abb";

        new LongestPalindromicSubstring().longestPalindrome(s);
    }

    /**
     * Given a string s, return the longest
     * palindromic substring in s.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: s = "cbbd"
     * Output: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        long start = System.nanoTime();

        if (s.length() == 1)
            return s;

        String reverseS = new StringBuilder(s).reverse().toString();

        if (s.equals(reverseS))
            return s;

        String longest = "";

        int i = 0, j = 0;

        a:
        for (i = 0; i < s.length(); i++) {
            String substring = s.substring(i);
            if (substring.length() < longest.length())
                break;

            for (j = s.length(); j > i; j--) {
                substring = s.substring(i, j);
                if (substring.length() < longest.length())
                    continue a;

                if (reverseS.contains(substring)) {
                    if (substring.equals(new StringBuilder(substring).reverse().toString()) && substring.length() > longest.length()) {
                        longest = substring;
                    }
                }
            }
        }

        long finish = System.nanoTime();
        System.out.println("Time = " + (finish - start));

        System.out.println(longest);
        System.out.println(i + " " + j);

        return longest;
    }

}
