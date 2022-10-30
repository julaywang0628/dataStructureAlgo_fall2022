package com.Northeastern.Zhilei;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(3);
	    root.left.right = new TreeNode(2);

	    recoverTree(root);
        System.out.println(treeToString(root));

    }
    public static TreeNode error1, error2, pre;
    public static void recoverTree(TreeNode root) {
        error1 = null;
        error2 = null;
        pre = null;
        inorder(root);
        if(error1 != null && error2 != null) {
            int temp = error1.val;
            error1.val = error2.val;
            error2.val = temp;
        }
    }

    public static void inorder(TreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);

        if(pre != null &&pre.val >= node.val) {
            if(error1 == null) {
                error1 = pre;
            }
            error2 = node;
        }

        pre = node;
        inorder(node.right);
    }
    public static String treeToString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("[]");
            return sb.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                TreeNode cur = q.poll();
                if(cur != null) {
                    sb.append(cur.val + ",");
                    if(cur.left == null && cur.right == null) {
                        continue;
                    }
                    q.offer(cur.left);
                    q.offer(cur.right);
                } else {
                    sb.append("null" +",");
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
