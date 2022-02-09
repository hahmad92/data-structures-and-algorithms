package com.hammad.dsa.linkedlist;


import com.hammad.algorithm.dp.NumArray;

import java.util.HashSet;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = null;
        if (null != head) {
            fast = head.next;
        }
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (null != fast) {
                fast = fast.next;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head)
            return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head = headA;
        int lengthA = 0;
        int lengthB = 0;

        while (head != null) {
            lengthA++;
            head = head.next;
        }

        head = headB;
        while (head != null) {
            lengthB++;
            head = head.next;
        }

        if (lengthA > lengthB) {
            int differ = lengthA - lengthB;
            for (int i = 0; i < differ; i++) {
                headA = headA.next;
            }
        } else {
            int differ = lengthB - lengthA;
            for (int i = 0; i < differ; i++) {
                headB = headB.next;
            }
        }

        while (headB != null) {
            if (headB == headA) {
                return headB;
            }

            headB = headB.next;
            headA = headA.next;
        }
        return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode current = head;

        while (current != null) {
            int i = 1;
            while (i <= n) {
                if (current.next == null)
                    break;
                current = current.next;
                i++;
            }
            first = second;
            second = current;

        }

        return null;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println(one.hashCode());
        System.out.println(one);

    }

}
