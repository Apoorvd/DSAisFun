package com.apoorv.btree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public static void BFS(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.printf("%d ", node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    public static void DFS_inorder(Node root)
    {
        if(root == null)
            return;
        DFS_inorder(root.left);
        System.out.printf("%d ", root.data);
        DFS_inorder(root.right);
    }
    public static void DFS_preorder(Node root)
    {
        if(root == null)
            return;
        System.out.printf("%d ", root.data);
        DFS_preorder(root.left);
        DFS_preorder(root.right);
    }
    public static void DFS_postorder(Node root)
    {
        if(root == null)
            return;
        DFS_postorder(root.left);
        DFS_postorder(root.right);
        System.out.printf("%d ", root.data);
    }
}
