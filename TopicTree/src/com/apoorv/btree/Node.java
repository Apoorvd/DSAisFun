package com.apoorv.btree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.left = null;
        this.right = null;
    }

    public static Node createNode(int number) {
        return new Node(number);
    }
}