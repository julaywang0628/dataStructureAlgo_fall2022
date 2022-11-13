package com.Northeastern.Zhilei;

public class BinTree <T> {
    public Node<T> root;

    public BinTree() {
    }

    public void populateNextLeft(Node root){
        if(root == null || root.right == null) {
            return;
        }

        root.right.nextLeft = root.left;
        if(root.nextLeft != null) {
            root.left.nextLeft = root.nextLeft.right;
        }
        populateNextLeft(root.right);
        populateNextLeft(root.left);

    }
}
