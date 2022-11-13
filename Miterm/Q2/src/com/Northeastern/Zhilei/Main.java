package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<>();

        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);


        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);

        populateParent(tree.root);

    }

    public static void populateParent(Node root) {
        if(root == null) {
            return;
        }
        if(root.left != null || root.right != null) {
            System.out.println(root.data);
            if(root.left != null) {
                root.left.parent = root;
            }
            if(root.right != null) {
                root.right.parent = root;
            }
        }
        populateParent(root.left);
        populateParent(root.right);
    }
}
