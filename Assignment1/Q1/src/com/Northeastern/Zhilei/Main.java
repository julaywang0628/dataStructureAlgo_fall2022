package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        //Q1 Rotate List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Rotate List Test:");
        printList(RotateList(head, 2));
    }

    public static ListNode RotateList(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode p1 = head;
        while(p1 != null) {
            len ++;
            p1 = p1.next;
        }
        int count = k % len;
        if(count == 0) {
            return head;
        }
        int step = len - count - 1;
        ListNode p2 = head;
        while(step -- > 0){
            p2 = p2.next;
        }

        ListNode rotatePart = p2.next;
        p2.next = null;

        ListNode p3 = rotatePart;
        while(p3.next != null) {
            p3 = p3.next;
        }
        p3.next = head;
        return rotatePart;
    }

    public static void printList(ListNode head) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode temp = head;
        while(temp != null) {
            System.out.printf(temp.val + "->");
            temp = temp.next;
        }

        System.out.println("Null");
    }
}
