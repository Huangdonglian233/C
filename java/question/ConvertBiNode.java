package com.huang.question;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConvertBiNode {
    public static void main(String[] args) {
        //[4,2,5,1,3,null,6,0]
        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1,
                      new TreeNode(0),null),
                      new TreeNode(3)),new TreeNode(5,null,new TreeNode(6)));
        TreeNode root1=convertBiNode(root);
        while (root1!=null){
            System.out.print(root1.val+" ");
            root1=root1.right;
        }
    }
    private static TreeNode root1=null;
    private static TreeNode newRight=root1;
    public static TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if(root.right==null&&root.left==null){
            newRight=new TreeNode(root.val);
            newRight=newRight.right;
        }
        if(root.left != null){
           convertBiNode(root.left);
            newRight = new TreeNode(root.left.val);
            newRight=newRight.right;
        }
        if(root.right != null){
            convertBiNode(root.right);
            newRight = new TreeNode(root.right.val);
            newRight=newRight.right;
        }
        return root1;
    }
}
