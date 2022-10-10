package com.Northeastern.Zhilei;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    TreeNode root = new TreeNode(3);
	    root.left = new TreeNode(9);
	    root.right = new TreeNode(20);
	    root.right.left = new TreeNode(15);
	    root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int path = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size -- > 0) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.right != null) {
                    q.offer(cur.right);
                }
                if(cur.left != null) {
                    q.offer(cur.left);
                }
            }
            path ++;
            if (path % 2 != 0) {
                Collections.reverse(list);
            }
            answer.add(list);
        }
        return answer;
    }
}
