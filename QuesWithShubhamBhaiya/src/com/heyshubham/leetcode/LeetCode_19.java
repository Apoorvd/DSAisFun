package com.heyshubham.leetcode;

public class LeetCode_19 {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) { return null; }
        ListNode offset = head;
        while (offset != null && n > 0) {
            offset = offset.next;
            n--;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(offset != null) {
            prev = curr;
            curr = curr.next;
            offset = offset.next;
        }
        if (prev != null)
            prev.next = curr.next;
        return prev == null? head.next: head;

    }
    /* my way
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=head;
        int countElmnt=0;
        while(dummy!=null)
        {
            dummy=dummy.next;
            countElmnt++;
        }

        dummy=head;
        if(n==countElmnt)
        {
            return head.next;
        }
        while(countElmnt!=(n+1) && countElmnt > 0)
        {
            dummy=dummy.next;
            countElmnt--;
        }
        if(n==1)
        {
            dummy.next=null;
            return head;
        }
        dummy.next=dummy.next.next;
        return head;

    }
     */

    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0)
            return head;

        ListNode currNode = head, trackNode = null;
        int currPos = 1;
        while(currNode.next != null){
            currNode = currNode.next;
            if(trackNode != null)
                trackNode = trackNode.next;
            if(currPos == n)
                trackNode = head;
            currPos++;
        }
        if (trackNode == null)
            return head.next;
        else {
            trackNode.next = trackNode.next.next;
            return head;
        }

    }
     */
}
