package com.apoorv.linkedlist;

public class LLdemo {
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.next=null;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void printList(ListNode head){
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}