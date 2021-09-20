package com.apoorv.linkedlist;

public class Josepher {

    public static void main(String args[])
    {
        int i;
        ListNode head  = new ListNode(1,null);
        ListNode dummy = head;
        ListNode temp = null;
        for(i= 2; i <= 1001; i++)
        {
            ListNode newNode = new ListNode(i);
            temp = newNode;
            dummy.next = newNode;
            dummy = dummy.next;
        }

//        head.printList(head);
        temp.next = head;
        temp = head;
        while( temp.next.val != temp.next.next.val){
            temp.next = temp.next.next;
            temp = temp.next;
        }

        System.out.println(josephersMath(8,1, 3));
        System.out.println(temp.val);
    }
    static int josephersMath(int people, int starting_point, int skipStep) // skipStep is taken such that when 1 will kill 3 , skipStep =3, when 1 will kill 2. skipStep = 2 as u can see after skip step u find a new pointer.
    {
        if( people <= 0)
            return -1;
        if(people == 1)
            return 1;
        int n ;
        for(n = skipStep; n <= people/skipStep;)
        {
            if(people/n > n)
            {
                n = n*n;
            }
            else
            {
                n = n*skipStep;
            }
        }
//        n=n/2;
//        System.out.println(setBitNumber(people));
        // using formula that people = 2^n + remainder;   and output is always (remainder*2 +1)
        if((skipStep*(people-n)+starting_point)%people == 0)
            return people;
        return (skipStep*(people-n)+starting_point)%people;

    }
    static int setBitNumber(int n) // Finds leftmostbit of a number .. MSB of a number
    {

        // Below steps set bits after
        // MSB (including MSB)

        // Suppose n is 273 (binary
        // is 100010001). It does following
        // 100010001 | 010001000 = 110011001
        n |= n >> 1;

        // This makes sure 4 bits
        // (From MSB and including MSB)
        // are set. It does following
        // 110011001 | 001100110 = 111111111
        n |= n >> 2;

        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        // Increment n by 1 so that
        // there is only one set bit
        // which is just before original
        // MSB. n now becomes 1000000000
        n = n + 1;

        // Return original MSB after shifting.
        // n now becomes 100000000
        return (n >> 1);
    }
}
// with this I can do this problem in O(1) space( only when skipStep is 2)
