package com.Northeastern.Zhilei;

public class Node <T> {
    public int data;
    public Node<T> left;
    public Node<T> right;

    public Node<T> parent;

    public Node(int data){
        this.data = data;
    }
}
