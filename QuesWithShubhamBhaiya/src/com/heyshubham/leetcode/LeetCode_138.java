package com.heyshubham.leetcode;

public class LeetCode_138 {

        // https://leetcode.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node iter = head;
        Node prev = null;
        while(iter != null)
        {
            prev=iter;
            Node addNewNode = new Node(iter.val);
            iter=iter.next;
            prev.next=addNewNode;
            addNewNode.next=iter;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        iter = head.next;
        Node odd = head;
        Node even = head.next;

        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        if(odd != null)
        {
            odd.next = null;
        }
        return iter;
    }
    /*
    Using extra space

    public RandomListNode copyRandomList(RandomListNode head) {
  if (head == null) return null;

  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

  // loop 1. copy all the nodes
  RandomListNode node = head;
  while (node != null) {
    map.put(node, new RandomListNode(node.label));
    node = node.next;
  }

  // loop 2. assign next and random pointers
  node = head;
  while (node != null) {
    map.get(node).next = map.get(node.next);
    map.get(node).random = map.get(node.random);
    node = node.next;
  }

  return map.get(head);
 }
     */
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
