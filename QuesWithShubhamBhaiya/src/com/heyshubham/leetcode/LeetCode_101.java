package com.heyshubham.leetcode;

public class LeetCode_101 {

    //https://leetcode.com/problems/symmetric-tree/

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}

/* Iterative
public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(true) {
        	if(left == null || right == null) {
        		if(left == right) {
        			if(!leftStack.isEmpty() && !rightStack.isEmpty()) {
        				left = leftStack.pop().right;
        				right = rightStack.pop().left;
        			} else if(leftStack.isEmpty() && rightStack.isEmpty()) {
        				return true;
        			} else
        				return false;
        		} else
            		return false;
        	}else {
		        if(left.val != right.val)
		        	return false;
		        leftStack.push(left);
		        left = left.left;
		        rightStack.push(right);
		        right = right.right;
        	}
        }
    }
 */