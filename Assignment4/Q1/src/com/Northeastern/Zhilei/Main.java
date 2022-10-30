package com.Northeastern.Zhilei;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    ListNode head = new ListNode(-10);
	    head.next = new ListNode(-3);
	    head.next.next = new ListNode(0);
	    head.next.next.next = new ListNode(5);
	    head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);

        System.out.println(treeToString(root));

    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode p = head, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            p = slow;
            slow = slow.next;
        }

        p.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static String treeToString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("[]");
            return sb.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                TreeNode cur = q.poll();
                if(cur != null) {
                    sb.append(cur.val + ",");
                    if(cur.left == null && cur.right == null) {
                        continue;
                    }
                    q.offer(cur.left);
                    q.offer(cur.right);
                } else {
                    sb.append("null" +",");
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
