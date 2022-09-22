package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        //Q3 Swapping Nodes in a Linked List
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);

        System.out.println("Swapping Nodes in a Linked List:");
        printList(SwapNodes(head3, 3));
    }

    public static ListNode SwapNodes(ListNode head, int k) {
        int len = 0;
        ListNode p1 = head;
        while(p1 != null) {
            len ++;
            p1 = p1.next;
        }
        int step = len - k;
        ListNode p2 = head, p3 = head;
        while(-- k > 0) {
            p2 = p2.next;
        }
        while(step -- > 0) {
            p3 = p3.next;
        }
        int temp = p2.val;
        p2.val = p3.val;
        p3.val = temp;
        return head;
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
