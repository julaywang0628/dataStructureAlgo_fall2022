package com.Northeastern.Zhilei;

public class LinkList {
    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){
        // Insert in sorted manner
        Node cur = new Node(data);
        if(head == null) {
            head = cur;
            length ++;
            return;
        }

        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = head;
        Node pre = dummy;
        boolean inserted = false;
        while(pre.next != null ) {
            if(data >= pre.data && data < pre.next.data) {
                cur.next = pre.next;
                pre.next = cur;
                inserted = true;
                break;
            } else {
                pre = pre.next;
            }
        }
        if(!inserted) {
            pre.next = cur;
        }
        head = dummy.next;
        length ++;
    }
}
