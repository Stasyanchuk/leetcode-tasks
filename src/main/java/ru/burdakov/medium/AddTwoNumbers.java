package ru.burdakov.medium;

import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(3, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode l2 = new ListNode(7);

        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <br>
     *
     * <img src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" />
     *
     * <br>
     * Input: l1 = [2,4,3], l2 = [5,6,4]<br>
     * Output: [7,0,8]<br>
     * Explanation: 342 + 465 = 807.<br>
     *     <br>
     *
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0] <br>
     * Output: [0] <br>
     *
     *     <br>
     * Example 3: <br>
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]<br>
     * Output: [8,9,9,9,0,0,0,1]<br>
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num = new StringBuilder();
        while (l1 != null) {
            num.append(l1.val);
            l1 = l1.next;
        }

        BigInteger n1 = new BigInteger(num.reverse().toString());

        num = new StringBuilder();
        while (l2 != null) {
            num.append(l2.val);
            l2 = l2.next;
        }
        BigInteger n2 = new BigInteger(num.reverse().toString());

        BigInteger sum = n1.add(n2);

        String ssum = sum.toString();

        ListNode startListNode = new ListNode(Integer.parseInt(String.valueOf(ssum.charAt(ssum.length() - 1))));
        ListNode nextNode;
        ListNode prevNode = startListNode;
        for (int i = ssum.length() - 2; i >= 0; i--) {
            nextNode = new ListNode(Integer.parseInt(String.valueOf(ssum.charAt(i))));
            prevNode.next = nextNode;
            prevNode=nextNode;
        }

        return startListNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
