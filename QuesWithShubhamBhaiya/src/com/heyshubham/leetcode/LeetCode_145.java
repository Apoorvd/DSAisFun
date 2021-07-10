package com.heyshubham.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_145 {

    //https://leetcode.com/problems/binary-tree-postorder-traversal/

    List<Integer>l =new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)return l;
        postorderTraversal(root.left);

        postorderTraversal(root.right);

        l.add(root.val);

        return l;
    }
}

/* my way
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> list =new ArrayList<>();
        postorder(list, root);
        return list;
    }
    void postorder(List<Integer> list, TreeNode tree)
    {
        if(tree == null)
            return;
        postorder(list, tree.left);
        postorder(list, tree.right);
        list.add(tree.val);
    }
 */

/* Iterative
public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> tovisit = new Stack<>();
		tovisit.push(root);
		while(!tovisit.empty()){
			TreeNode cur = tovisit.pop();
			res.add(0, cur.val);
			if(cur.left != null) tovisit.push(cur.left);
			if(cur.right != null) tovisit.push(cur.right);
		}
		return res;
	}
 */

/* Iterative 2
public List<Integer> postorderTraversal(TreeNode root) {
        HashSet<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur == null){
                TreeNode popNode = stack.pop();
                if(visited.contains(popNode)){
                    res.add(popNode.val);
                }else{
                    visited.add(popNode);
                    stack.push(popNode);
                    cur = popNode.right;
                }
            }else{
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
 */