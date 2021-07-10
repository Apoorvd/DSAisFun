package com.heyshubham.leetcode;

public class LeetCode_1019 {

    //https://leetcode.com/problems/next-greater-node-in-linked-list/

    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return new int[00];

        ListNode prev = null;
        ListNode cur = head;
        int size = 0;

        while(cur!=null){
            size++;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        int[] ans = new int[size];
        int top = -1;
        int[] stack = new int[size];
        ListNode ptr = prev;

        int i = size-1;
        while(ptr!=null){

            while(top>=0 && stack[top] <= ptr.val)
                top--;

            if(top<0) ans[i] = 0;
            else ans[i] = stack[top];
            stack[++top] = ptr.val;
            i--;
            ptr = ptr.next;
        }
        return ans;
    }
}

/*
public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
 */

/*
public int[] nextLargerNodes(ListNode head) {
   int count = 0;
    ListNode len = head;
    while(len!=null){
      count++;
      len = len.next;
    }
   int[] arr=new int[count];
   int index=0;
    while(head!=null){
      arr[index++]=head.val;
      head=head.next;
    }
   int[] arr1=new int[count];
   for(int i=0;i<count-1;i++)
   {
     if(arr[i]<arr[i+1])
     {
      arr1[i]=arr[i+1];
     }
     else
     {
       for(int j=i+1;j<count;j++)
       {
         if(arr[j]>arr[i])
         {
           arr1[i]=arr[j];
           break;
         }
       }
     }
   }
      System.gc();
   return arr1;
    }
}


 */