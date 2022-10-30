package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    public static long max = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(isValidBST(root.left)) {
            if(max < root.val) {
                max = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
