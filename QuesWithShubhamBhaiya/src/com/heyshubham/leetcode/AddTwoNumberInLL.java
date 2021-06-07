package com.heyshubham.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumberInLL {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1, l1);
        ListNode previous = null;
        int c = 0;
        while (l1 != null && l2 != null) {
            l1.val = (l1.val + l2.val + c);
            c = l1.val / 10;
            l1.val = l1.val % 10;
            previous = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = (l1 == null ? previous.next = l2 : l1);
        while (l1 != null) {
            l1.val = l1.val + c;
            c = l1.val / 10;
            l1.val = l1.val % 10;
            previous = l1;
            l1 = l1.next;
        }
        // System.out.println(c + " " + previous.val);
        ListNode list = new ListNode(c);
        list.next = null;
        previous.next = (c > 0 ? list : null);
        return head.next;
    }
    public void insertNode(int val){

    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(9);
        ListNode a2=new ListNode(9);
        AddTwoNumberInLL obj=new AddTwoNumberInLL();
        ListNode sum= obj.addTwoNumbers(a1,a2);
        while(sum!=null)
        {
            System.out.println(sum.val);
            sum=sum.next;
        }


    }
}
