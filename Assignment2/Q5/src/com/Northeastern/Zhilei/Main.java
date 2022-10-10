package com.Northeastern.Zhilei;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalOrder(root));
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        Map<TreeNode, Integer> nodeToIndex = new HashMap<>();
        Map<Integer, List<Integer>> indextoGroup = new HashMap<>();
        nodeToIndex.put(root, 0);
        int minIndex = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                TreeNode cur = q.poll();
                int curIndex = nodeToIndex.get(cur);
                minIndex = Math.min(minIndex, curIndex);
                indextoGroup.put(curIndex, indextoGroup.getOrDefault(curIndex, new ArrayList<>()));
                indextoGroup.get(curIndex).add(cur.val);

                if(cur.left != null) {
                    q.offer(cur.left);
                    nodeToIndex.put(cur.left, curIndex - 1);
                }

                if(cur.right != null) {
                    q.offer(cur.right);
                    nodeToIndex.put(cur.right, curIndex + 1);
                }
            }
        }

        for(int i = minIndex; i < indextoGroup.size(); i ++) {
            if(indextoGroup.get(i) != null) {
                answer.add(indextoGroup.get(i));
            }
        }
        return answer;
    }
}
