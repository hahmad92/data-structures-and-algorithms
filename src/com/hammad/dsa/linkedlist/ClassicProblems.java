package com.hammad.dsa.linkedlist;

import com.hammad.dsa.array.ArraysQuestions;

public class ClassicProblems {

    public static void main(String[] args) {
        ArraysQuestions demo = new ArraysQuestions();
        int [] data = {1,2,1};

        ListNode list = makeLinkedList(data);
        boolean res = isPalindrome(list);
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode newHead = head;
        ListNode head1 = head;
        ListNode temp;
        head = head.next;
        while(head != null){
            temp = head.next;
            head.next = newHead;
            newHead= head;
            head = temp;
        }
        head1.next = null;
        return newHead;
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode previous = head;
        ListNode newHead = head;

        while(head.next != null){
            if(head.next.val == val){
                previous.next = head.next.next;
                head = head.next.next;
            }else{
                head = head.next;
                previous = previous.next;
            }
        }
        if(newHead.val == val){
            newHead = newHead.next;
        }
        return newHead;
    }

    public static  ListNode makeLinkedList(int [] data){
        ListNode result = new ListNode(data[0]);
        ListNode head = result;
        for(int i = 1; i < data.length; i++){
            result.next = new ListNode(data[i]);
            result = result.next;
        }
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode evenHead = head;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = head.next;
        head = head.next.next;
        odd.next = null;
        even.next = null;
        while(head!=null){
            even.next = head;
            even = even.next;

            head = head.next;
            if(head != null){
                odd.next = head;
                odd = odd.next;
                head = head.next;
                odd.next = null;
            }
            even.next = null;
        }
        even.next = oddHead;
        return evenHead;
    }


    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;
        while (odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return head;
    }

    public static boolean isPalindrome(ListNode head) {

        if(head == null)
            return false;
        if(head.next == null)
            return true;
        int length = 0;
        ListNode curser = head;
        while(curser != null){
            curser = curser.next;
            length++;
        }

        int halfLength = length / 2;

        curser = head;
        for (int i = 0; i < halfLength - 1; i++) {
            curser = curser.next;
        }

        ListNode temp = curser;
        curser = curser.next;
        temp.next = null;

        if(length%2 != 0){
            curser = curser.next;
        }
        head =  reverseList(head);

        while (head != null){
            if (head.val != curser.val)
                return false;
            curser = curser.next;
            head = head.next;
        }
        return true;
    }


    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head!= null){
            result *= 2;
            result +=head.val;
            head= head.next;
        }
        return result;
    }

    public ListNode middleNode(ListNode head) {
        return head;

    }

}
