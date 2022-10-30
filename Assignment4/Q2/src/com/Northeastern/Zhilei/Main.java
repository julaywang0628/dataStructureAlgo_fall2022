package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        treeToDoublyList(root);
    }

    public static Node dummy = new Node();
    public static Node pre = dummy;
    public static Node treeToDoublyList(Node root) {
        if(root == null) {
            return root;
        }
        dummy.right = root;
        pre.right = root;
        dfs(root);
        pre.right = dummy.right;
        dummy.right.left = pre;
        return dummy.right;
    }

    public static void dfs(Node cur) {
        if(cur == null) {
            return;
        }
        dfs(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
