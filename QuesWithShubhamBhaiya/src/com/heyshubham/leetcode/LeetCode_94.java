package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94 {
    //https://leetcode.com/problems/binary-tree-inorder-traversal/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        inorder(list, root);
        return list;
    }
    void inorder(List<Integer> list, TreeNode tree)
    {
        if(tree == null)
            return;
        inorder(list, tree.left);
        list.add(tree.val);
        inorder(list, tree.right);
    }

}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  /* Iterative
  public static class Pair{
       TreeNode node;
       int state;
       public Pair(TreeNode node , int state){
           this.node = node;
           this.state = state;
       }
   }

    public List<Integer> inorderTraversal(TreeNode node) {
         List<Integer> in = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node,1));

        while(st.size()>0){
            Pair top  =st.peek();
            if(top.state==1){


                top.state++;
                if(top.node!=null && top.node.left!=null){
                    st.push(new Pair(top.node.left,1));
                }
            }
            else if(top.state == 2){
                if(top.node!=null){
                     in.add(top.node.val);
                }
                top.state++;
                if(top.node!=null &&  top.node.right!=null){
                    st.push(new Pair(top.node.right,1));
                }
            }
            else if(top.state==3){
                st.pop();
            }
        }

        return in;
    }
   */

/* Iterative 2
public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;

    }
 */

/* different
public List<Integer> inorderTraversal(TreeNode root) {
        return traverse(root).boxed().collect(Collectors.toList());
    }
    private IntStream traverse(TreeNode node) {
        if (node == null)
            return IntStream.empty();

        Stream.Builder<IntStream> builder = Stream.builder();

        if (node.left != null)
            builder.add(traverse(node.left));

        builder.add(IntStream.of(node.val));

        if (node.right != null)
            builder.add(traverse(node.right));

        return builder.build().flatMapToInt(Function.identity());
    }
 */