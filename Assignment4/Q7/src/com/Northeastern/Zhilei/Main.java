package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(inorderSuccessor(root, root.left).val);

    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if(root == null) {
            return ans;
        }
        while(root != null) {
            if(root.val > p.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
