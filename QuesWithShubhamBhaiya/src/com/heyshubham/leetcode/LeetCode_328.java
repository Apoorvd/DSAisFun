package com.heyshubham.leetcode;

public class LeetCode_328 {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null || head.next.next ==null)
                return head;
            ListNode iterOdd = head;
            ListNode iterEven = head.next;
            ListNode evenHead = head.next;
            ListNode tempOdd = null;
            ListNode tempEven = null;
            while ( iterOdd.next != null && iterEven.next != null)
            {
                tempOdd = iterOdd.next.next;
                tempEven = iterEven.next.next;
                iterOdd.next = tempOdd;
                iterEven.next = tempEven;
                iterOdd = iterOdd.next;
                iterEven = iterEven.next;

            }
            tempOdd.next = evenHead;

            return head;
        }
}

/* Second and good way of doing
public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
 */
