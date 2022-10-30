package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int sum = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return sum;
        }
        if(root.val < low) {
            rangeSumBST(root.right, low, high);
        } else if(root.val > high) {
            rangeSumBST(root.left, low, high);
        } else {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
