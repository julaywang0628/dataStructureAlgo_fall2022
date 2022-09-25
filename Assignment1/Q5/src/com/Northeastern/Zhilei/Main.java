package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        //Q5 Insert into a Sorted Circular Linked List
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);

        printList(insert(head, 2));

    }

    public static Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }

        if(head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }

        Node max = head, min = head.next;
        while(min.next != head.next && min.val >= max.val) {
            max = max.next;
            min = min.next;
        }

        Node p1 = min;
        if(insertVal <= min.val || insertVal >= max.val) {
            max.next = newNode;
            newNode.next = min;
        } else {
            while(p1.next != null && p1.next.val < insertVal) {
                p1 = p1.next;
            }
            newNode.next = p1.next;
            p1.next = newNode;
        }

        return head;
    }

    public static void printList(Node head) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.printf(temp.val + "->");
            temp = temp.next;
        }

        System.out.println("Null");
    }
}
