package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590 {

    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/

    public List<Integer> postorder(NodeTree root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }
    public void postOrder(NodeTree root, List<Integer> list)
    {
        if( root == null)
            return;
        for(int i=0; i < root.children.size() ; i++)
        {
            postOrder(root.children.get(i), list);
        }
        list.add(root.val);
    }
}

// Definition for a Node.
class NodeTree {
    public int val;
    public List<NodeTree> children;

    public NodeTree() {}

    public NodeTree(int _val) {
        val = _val;
    }

    public NodeTree(int _val, List<NodeTree> _children) {
        val = _val;
        children = _children;
    }
};

/* Iterative

public List<Integer> postorder(Node root) {
        if (root == null) {
            return List.of();
        }
        var stack = new Stack<Node>();
        var result = new ArrayList<Integer>();
        stack.push(root);
        while (stack.size()>0) {
            var node = stack.pop();
            result.add(node.val);
            for (int i=0; i<node.children.size();i++) {
                stack.push(node.children.get(i));
            }
        }
        var finalResult = new ArrayList<Integer>();
        for (int i=result.size()-1;i>=0;i--) {
            finalResult.add(result.get(i));
        }
        return finalResult;
    }
 */