package com.heyshubham.leetcode;

public class LeetCode_876 {

    //https://leetcode.com/problems/middle-of-the-linked-list/

    public ListNode middleNode(ListNode head) {
        ListNode fastptr=head;
        ListNode slowptr=head;
        while(fastptr!=null && fastptr.next!=null)
        {
            slowptr=slowptr.next;
            fastptr= fastptr.next.next;
        }
        return slowptr;
    }
}
