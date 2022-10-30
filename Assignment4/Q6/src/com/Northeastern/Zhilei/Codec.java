package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        // sb.append("[");
        preOrder(root);
        sb.deleteCharAt(sb.length() - 1);
        // sb.append("]");
        return sb.toString();
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public List<String> list;
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        list = new ArrayList<>(Arrays.asList(str));
        return dfs(list);
    }

    public TreeNode dfs(List<String>list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = dfs(list);
        node.right = dfs(list);
        return node;
    }
}
