package com.lpu.java.dsa.linked_list;

public class ReverselinkedList {
    //    https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
//    https://www.youtube.com/watch?v=jhm2pYGFIos
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printSinglyLinkedList(head);
        ListNode newHead = reverseLinkedList(head);
        printSinglyLinkedList(newHead);
    }

    private static void printSinglyLinkedList(ListNode head) {
        ListNode cur = head;


        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
//            1. breaking links
            next = curr.next;//save next
            curr.next = prev;//reverse the link

            // advancing prev & curr
            prev = curr;
            curr = next;//eventually curr will become null
        }

        return prev;
    }


    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
