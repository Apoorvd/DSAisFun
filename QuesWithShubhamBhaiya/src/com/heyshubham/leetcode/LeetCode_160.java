package com.heyshubham.leetcode;

public class LeetCode_160 {

    //https://leetcode.com/problems/intersection-of-two-linked-lists/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA=length(headA), lengthB=length(headB);
        int diff=0;
        ListNode iterA=null, iterB=null;
        if(lengthA > lengthB)
        {
            iterA=pass(headA, lengthA - lengthB);
            iterB=headB;
        }
        else
        {
            iterB=pass(headB, lengthB - lengthA);
            iterA=headA;
        }
        while(iterA!=null)
        {
            if(iterA == iterB)
                return iterA;
            iterA = iterA.next;
            iterB = iterB.next;
        }

        return null;

    }

    public int length(ListNode head)
    {
        int length=0;
        ListNode iter=head;
        while(iter!=null)
        {
            length++;
            iter=iter.next;
        }
        return length;
    }

    public ListNode pass(ListNode head, int diff)
    {
        ListNode iter = head;
        while(diff != 0)
        {
            iter=iter.next;
            diff--;
        }
        return iter;
    }

    // This was more worthy solution. I read it in description

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
