package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
        System.out.println(findLeaves(root));
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, answer);
        return answer;
    }

    public static int dfs(TreeNode root, List<List<Integer>> answer) {
        if(root == null) {
            return -1;
        }
        int left = dfs(root.left, answer);
        int right = dfs(root.right, answer);
        int cur = Math.max(left, right) + 1;
        if(answer.size() == cur) {
            answer.add(new ArrayList<>());
        }
        answer.get(cur).add(root.val);
        return cur;
    }
}
