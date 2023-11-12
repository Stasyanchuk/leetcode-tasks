package ru.burdakov.medium;


/**
 * SOLVED
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion z = new ZigzagConversion();
        System.out.println(z.convert("PAYPALISHIRING", 2));
    }

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     *
     * @param s       input sting
     * @param numRows number rows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        char[][] result = new char[numRows][chars.length];

        int row = 1;
        byte mode = 0;

        for (int i = 0; i < s.length(); i++) {
            result[row - 1][i] = chars[i];
            if (mode == 0) {
                if (row < numRows) {
                    row++;
                } else if (row == numRows) {
                    mode = 1;
                    row--;
                }
            } else {
                if (row > 1) {
                    row--;
                } else {
                    mode = 0;
                    row++;
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for (char[] ch : result) {
            for (char c : ch) {
                if (c != 0)
                    res.append(c);
            }
        }

        return res.toString();
    }

}
