package balanced.treenode;

public class Main {
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

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else {
            int heightLeft =maxDepth(root.left);
            int heightRight=maxDepth(root.right);
            return Math.max(heightLeft,heightRight)+1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return true;

    }
}