package com.heyshubham.leetcode;

public class LeetCode_142 {
    //https://leetcode.com/problems/linked-list-cycle-ii/

    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while( hare != null && hare.next != null)
        {
            hare=hare.next.next;
            tortoise=tortoise.next;
            if(hare == tortoise)
                break;
        }
        if(hare == null || hare.next == null)
            return null;
        tortoise = head;
        while( hare != tortoise)
        {
            hare= hare.next;
            tortoise = tortoise.next;
        }
        return hare;
    }
}
/* Using map
public ListNode detectCycle(ListNode head) {
         Map<ListNode, ListNode> map = new HashMap();
        ListNode current = head;
        ListNode cycleNode = null;
        while(current != null){
            if (map.get(current) == null) {
                map.put(current,current);
                current = current.next;
            }else {
                cycleNode = current;
                break;
            }
        }
        return cycleNode;
    }
 */