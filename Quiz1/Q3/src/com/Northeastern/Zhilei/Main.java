package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        preOrder(root);
        System.out.println(preList);

        inOrder(root);
        System.out.println(inList);

        postOrder(root);
        System.out.println(postList);
    }
    public static List<Integer> preList = new ArrayList<>();
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static List<Integer> inList = new ArrayList<>();
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        inList.add(root.val);
        inOrder(root.right);
    }

    public static List<Integer> postList = new ArrayList<>();
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        postList.add(root.val);
    }
}
