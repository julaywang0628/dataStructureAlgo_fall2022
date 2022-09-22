package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        //Q2 Remove Linked List Elements
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Linked List Elements Test:");
        printList(RemoveElements(head2, 6));
    }

    public static ListNode RemoveElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        while(p1.next != null) {
            if(p1.next.val != val) {
                p1 = p1.next;
            } else {
                p1.next = p1.next.next;
            }
        }
        return dummy.next;
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
