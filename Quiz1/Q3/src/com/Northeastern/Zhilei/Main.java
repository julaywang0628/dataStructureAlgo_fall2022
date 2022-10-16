package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return answer;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            while(size -- > 0) {
                TreeNode curNode = queue.poll();
                cur.add(curNode.val);
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            answer.add(cur);
        }
        return answer;
    }
}
