package ru.burdakov.hard;

import java.util.Arrays;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7, 8});
    }


    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     *
     * Example 1:
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] concatArr = new int[m + n];

        int mi = 0, ni = 0;
        for (int i = 0; i < concatArr.length; i++) {

            if (mi == nums1.length) {
                int[] num2Remainder = Arrays.copyOfRange(nums2, ni, nums2.length);
                System.arraycopy(num2Remainder, 0, concatArr, i, num2Remainder.length);
                break;
            } else if (ni == nums2.length) {
                int[] num1Remainder = Arrays.copyOfRange(nums1, mi, nums1.length);
                System.arraycopy(num1Remainder, 0, concatArr, i, num1Remainder.length);
                break;
            }

            if (nums1[mi] <= nums2[ni]) {
                concatArr[i] = nums1[mi];
                mi++;
            } else if (nums2[ni] < nums1[mi]) {
                concatArr[i] = nums2[ni];
                ni++;
            }
        }

        double res = 0;

        if (concatArr.length % 2 == 0) {
            int startIndex = concatArr.length / 2;
            res = (double) (concatArr[startIndex] + concatArr[startIndex - 1]) / 2;
        } else {
            res = concatArr[concatArr.length / 2 + 5 % 2 - 1];
        }

        return res;
    }

}
