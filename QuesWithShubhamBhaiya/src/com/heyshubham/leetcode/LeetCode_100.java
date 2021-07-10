package com.heyshubham.leetcode;

public class LeetCode_100 {

    //https://leetcode.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p== null && q==null){
            return true;
        }
        if(p== null){
            return false;
        }
        if(q== null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return ( isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}
/* Iterative
public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        TreeNode temp1=p,temp2=q;
        s1.push(temp1);
        s2.push(temp2);
        int n1=0,n2=0;
        if(p==null && q==null)
            return true;
        else if((p==null ||q==null) && (p!=null || q!=null))
            return false;
        while( !s1.isEmpty() || !s2.isEmpty())
        {
                  if(temp1!=null && !s1.isEmpty() )
                  {
                      temp1=temp1.left;

                      if(temp1!=null)
                      s1.push(temp1);
                  }else{
                      if(!s1.isEmpty()){
                      temp1=s1.pop();
                     n1=temp1.val;
                      if(temp1.right!=null)
                      {
                          s1.push(temp1.right);
                      }
                      temp1=temp1.right;
                      }
                  }

                  if(temp2!=null && !s2.isEmpty())
                  {
                      temp2=temp2.left;
                      if(temp2!=null)
                      s2.push(temp2);
                  }else{
                      if(!s2.isEmpty()){
                      temp2=s2.pop();
                     n2=temp2.val;
                       if(temp2.right!=null)
                      {
                          s2.push(temp2.right);
                      }
                      temp2=temp2.right;
                      }
                  }

            System.out.println(n1+" "+n2 );
            if(n1!=n2)
            {
                return false;
            }
        }
        return true;
    }
 */