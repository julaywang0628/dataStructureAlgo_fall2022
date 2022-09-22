package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        //Q4 Split Linked List in Parts
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);

        System.out.println("Split Linked List in Parts:");
        ListNode[] output = SplitListToParts(head4, 5);
        for(ListNode l : output) {
            printList(l);
        }
    }

    public static ListNode[] SplitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];
        int len = 0;
        ListNode p1 = head;
        while(p1 != null) {
            len++;
            p1 = p1.next;
        }

        int mod = len % k;
        int size = len / k;
        p1 = head;
        for(int i = 0; p1 != null && i < k; i++) {
            answer[i] = p1;
            int per = size;
            if(mod -- > 0) {
                per += 1;
            }
            for(int j = 0; j < per - 1; j++) {
                p1 = p1.next;
            }
            ListNode p2 = p1.next;
            p1.next = null;
            p1 = p2;
        }
        return answer;
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
