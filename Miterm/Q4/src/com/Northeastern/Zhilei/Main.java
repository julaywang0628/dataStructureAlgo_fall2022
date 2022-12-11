package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	    LinkList list = new LinkList();
	    list.insert(2);
	    list.insert(3);
	    list.insert(4);
	    list.insert(5);
		list.insert(1);
	    Node p = list.head;
	    while(p != null) {
            System.out.print(p.data + ",");
            p = p.next;
        }
    }
}
