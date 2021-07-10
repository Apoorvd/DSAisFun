package com.heyshubham.leetcode;

public class LeetCode_543 {
        //https://leetcode.com/problems/diameter-of-binary-tree/
        int max = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max, leftDepth + rightDepth);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}


/* same as above
 int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getLength(root);
        return max;
    }

    private int getLength(TreeNode root) {
        if (root == null)
            return 0;
        int left = getLength(root.left);
        int right = getLength(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
 */

/*
public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> maxLengths = new ArrayList<Integer>();
        findMaxLen(root, maxLengths);
        int largest = 0;
        for (int l : maxLengths) {
            if (l > largest) {
                largest = l;
            }
        }

        return largest;
    }

    private int findMaxLen(TreeNode n, List<Integer> m) {
        int l = 0;
        int r = 0;
        if (n.left != null) {
            l = findMaxLen(n.left, m) + 1;
        }
        if (n.right != null) {
            r = findMaxLen(n.right, m) + 1;
        }
        int maxLen = l + r;
        m.add(maxLen);
        return Math.max(l, r);
    }

/*
DFS on left and right to return longest length
if no left: l = 0
else: l = search(left) + 1
if no right: r = 0
else: r = search(right) + 1
*/


/* Iterative
public int diameterOfBinaryTree(TreeNode root) {
        if( root == null){
            return 0;
        }
        if(root == null){
            return 0;
        }
        int overallNodeMax = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode,Integer> nodePathCountMap = new HashMap<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.peek();
            if(node.left != null && !nodePathCountMap.containsKey(node.left)){
                nodeStack.push(node.left);
            }else if(node.right!=null && !nodePathCountMap.containsKey(node.right)){
                nodeStack.push(node.right);
            }else {
                TreeNode rootNodeEndofPostOrder = nodeStack.pop();
                int leftMax = nodePathCountMap.getOrDefault(rootNodeEndofPostOrder.left,0);
                int rightMax = nodePathCountMap.getOrDefault(rootNodeEndofPostOrder.right,0);
                int nodeMax = 1 + Math.max(leftMax,rightMax);
                nodePathCountMap.put(rootNodeEndofPostOrder,nodeMax);
                overallNodeMax = Math.max(overallNodeMax,leftMax + rightMax );
            }

        }
        return overallNodeMax;

    }
 */

/*
public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
       int dia = depth(root.left) + depth(root.right);
       int ldia = diameterOfBinaryTree(root.left);
       int rdia = diameterOfBinaryTree(root.right);
       return Math.max(dia,Math.max(ldia,rdia));

    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(depth(root.left), depth(root.right));
    }

 */

/* with deque
 public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        Map<TreeNode, Integer> map = new HashMap<>();

        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                deque.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                deque.push(node.right);
            } else {
                node = deque.pop();

                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);

                int nodeMax = 1 + Math.max(left, right);

                max = Math.max(left + right, max);

                map.put(node, nodeMax);
            }
        }

        return max;
    } */