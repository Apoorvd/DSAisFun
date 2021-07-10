package com.heyshubham.leetcode;

import java.util.Stack;

public class LeetCode_234 {

    //https://leetcode.com/problems/palindrome-linked-list/
        public boolean isPalindrome(ListNode head) {
            if( head == null || head.next == null)
                return true;
            Stack<Integer> stack = new Stack<>();
            ListNode iter = null;
            boolean odd = false;
            iter= head;
            int c = 0;
            while( iter != null)
            {
                iter = iter.next.next;
                c++;
                if( iter != null && iter.next ==  null)
                {
                    odd =  true;
                    break;
                }
            }

            iter = head;

            while( c != 0)
            {
                stack.push(iter.val);
                iter = iter.next;
                c--;
            }
            if( odd )
                iter = iter.next;

            while( iter != null)
            {
                if( iter.val == stack.peek())
                {
                    stack.pop();
                    iter = iter.next;
                }
                else
                    return false;
            }
            return true;
        }

    /*
    without extra space

    public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;

    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
     */

    /* using recursion
     ListNode ref;
    public boolean isPalindrome(ListNode head) {

        ref = head;
        return check(head);
    }

    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false;
        ref = ref.next;
        return ans && isEqual;
    }

     */

    /* best time complexity solution
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode next = null;
        ListNode prev = null;
        while (true) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            if (fast == null) {
                break;
            }
            if (fast.next == null) {
                next = next.next;
                break;
            }
            slow = next;
        }
        while (slow != null) {
            if (slow.val != next.val) {
                return false;
            }
            slow = slow.next;
            next = next.next;
        }
        return true;
    }
     */

    /*
    similar approach
    public ListNode reverseList(ListNode head){
        ListNode prev = null, tail = head;
        while(tail != null){
            ListNode nn = tail.next;
            tail.next = prev;
            prev = tail;
            tail = nn;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;

        while(slow != null){
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
     */
}
