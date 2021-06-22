package com.heyshubham.leetcode;

public class LeetCode_141 {

    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {

        ListNode tortoise= head;
        ListNode hare= head;
        while(hare!=null && hare.next != null)
        {
            tortoise=tortoise.next;
            hare=hare.next.next;
            if(tortoise == hare)
                return true;
        }
        return false;
    }
}
