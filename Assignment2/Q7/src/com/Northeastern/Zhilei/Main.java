package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	    TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

	    root.left = new TreeNode(5);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(6);
	    root.left.right = new TreeNode(2);
	    root.left.right.left = new TreeNode(7);
	    root.left.right.right = new TreeNode(4);
	    root.right.left = new TreeNode(0);
	    root.right.right = new TreeNode(8);



        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
}
