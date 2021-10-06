package com.huang.question;

//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
//返回转换后的单向链表的头节点。
//
//注意：本题相对原题稍作改动
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binode-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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
    private static TreeNode pre=null;
    public static TreeNode convertBiNode(TreeNode root) {
        if(root==null){
            return null;
        }
        convertBiNode(root.left);
        if(root1==null){
            root1=root;
        }else{
            pre.right=root;
        }
        pre=root;
        root.left=null;
        convertBiNode(root.right);
        return root1;
    }
}
