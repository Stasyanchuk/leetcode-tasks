package ru.burdakov.medium;

/**
 * SOLVED
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
    }

    /**
     * Given a string s, find the length of the longest
     * substring without repeating characters.
     *
     * @param s input string
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int length = 1;

        a:
        for (int i = 0; i < s.length(); i++) {
            int currentChar = i;
            for (int j = i + 1; j < s.length(); j++) {
                currentChar++;
                char aChar = chars[currentChar];
                String sub = s.substring(i, currentChar);

                if (!sub.contains(String.valueOf(aChar))) {
                    if (length < sub.length() + 1)
                        length = sub.length() + 1;
                } else {
                    continue a;
                }
            }
        }

        return length;
    }

}
