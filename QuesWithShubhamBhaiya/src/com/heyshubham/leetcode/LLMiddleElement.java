package com.heyshubham.leetcode;

public class LLMiddleElement {
    public int MiddleElement(ListNode head)
    {
        ListNode slowhead=head;
        ListNode fasthead=head;
        while(fasthead!=null && fasthead.next !=null)
        {
            fasthead=fasthead.next.next;
            slowhead=slowhead.next;
        }
        return slowhead.val;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1,null);
        ListNode a2=new ListNode(2,a1);
        ListNode a3=new ListNode(3,a2);
        ListNode a4=new ListNode(4,a3);
        LLMiddleElement obj=new LLMiddleElement();
        System.out.println(obj.MiddleElement(a4));
    }
}
