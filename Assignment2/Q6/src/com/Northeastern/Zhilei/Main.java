package com.Northeastern.Zhilei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int answer = 1;
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Deque<Integer> index = new LinkedList<>();
        index.offer(1);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                TreeNode cur = q.poll();
                int curIndex = index.pollFirst();
                if(cur.left != null) {
                    q.offer(cur.left);
                    index.offer(2 * curIndex);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    index.offer(2 * curIndex + 1);
                }
            }
            if(index.size() > 1) {
                answer = Math.max(answer, index.getLast() - index.getFirst() + 1);
            }
        }
        return answer;
    }
}
