package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144 {

    //https://leetcode.com/problems/binary-tree-preorder-traversal/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        preorder(list, root);
        return list;
    }
    void preorder(List<Integer> list, TreeNode tree)
    {
        if(tree == null)
            return;
        list.add(tree.val);
        preorder(list, tree.left);
        preorder(list, tree.right);
    }
}

/* Iterative
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null)
            return l;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.pop();
            l.add(cur.val);
            if (cur.right!= null)
                q.push(cur.right);
            if (cur.left!=null)
                q.push(cur.left);
        }
        return l;
    }
 */

/*Iterative 2
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        TreeNode curr=root;
        if(root==null){
            return list;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                list.add(curr.val);
                if(curr.right!=null){
                    st.push(curr.right);
                }
                curr=curr.left;
            }
            if(!st.isEmpty()){
                curr=st.pop();
            }
        }
        return list;
    }
 */