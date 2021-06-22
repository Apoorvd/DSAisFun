package com.heyshubham.leetcode;

public class LeetCode_61 {

    //  https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy=head;
        ListNode tail=null;
        int countElmnt=0;
        if(head==null)
            return null;
        while(dummy!=null)
        {
            tail=dummy;
            dummy=dummy.next;
            countElmnt++;
        }

        k=k%countElmnt;
        if(k==0)
            return head;
        int x=countElmnt-k;
        dummy=head;
        while(x!=1)
        {
            dummy=dummy.next;
            x--;
        }
        ListNode temp=dummy.next;
        dummy.next=null;
        tail.next=head;
        head=temp;
        return head;

    }
}
