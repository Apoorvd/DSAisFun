package com.heyshubham.leetcode;

public class LeetCode_206 {

    //https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode iter = head;
        ListNode newHead = head;
        ListNode prev = null;
        while (iter.next != null)
        {
            prev=newHead;
            newHead = iter.next;
            iter.next = iter.next.next;
            newHead.next = prev;
        }
        return newHead;
    }
}
