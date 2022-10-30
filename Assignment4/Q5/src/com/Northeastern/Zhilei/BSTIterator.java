package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    public static List<Integer> list = new ArrayList<>();
    int index = 0;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}

