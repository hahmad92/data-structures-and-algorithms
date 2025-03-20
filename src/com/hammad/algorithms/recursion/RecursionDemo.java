package com.hammad.algorithms.recursion;

public class RecursionDemo {

    public static void main(String[] args) {
        RecursionDemo demo = new RecursionDemo();
        demo.testReverseLinkedList();
    }

    public void testReverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char ch : s) {
            System.out.print(ch);
        }
    }

    public void reverseString(char[] s) {
        printReverseString(s, 0);
    }

    public void printReverseString(char[] s, int index) {
        if (null == s || index >= s.length / 2) {
            return;
        }
        char ch = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = ch;
        printReverseString(s, index + 1);
    }

    public void reverseStringUsingLoop(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char s1 = s[i];
            s[i] = s[j];
            s[j] = s1;
            i++;
            j--;
        }
    }
    public void testSwapPairs(){
        ListNode head = new ListNode(1);
        ListNode newHead = head;
        for(int i= 2; i < 6;i++){
            newHead.next = new ListNode(i);
            newHead = newHead.next;
        }

        head = swapPairs(head);
        newHead = head;
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if(null != head && head.next != null){
            ListNode subhead = swapPairs(head.next.next);
            ListNode newHead = head.next;
            head.next = subhead;
            newHead.next = head;
            return newHead;
        }else{
            return head;
        }
    }
    public int pascalTriangle(int i, int j) {

        if( j == 1 || j == i)
            return 1;
        else {
            return pascalTriangle(i-1,j-1) + pascalTriangle(i-1,j);
        }
    }



    public void testReverseLinkedList() {
        ListNode head = new ListNode(1);
        ListNode newHead = head;
        for(int i= 2; i < 6;i++){
            newHead.next = new ListNode(i);
            newHead = newHead.next;
        }

        head = reverseLinkedList(head);
        newHead = head;
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public ListNode reverseLinkedList(ListNode head) {
        if(head.next != null){
            ListNode temp = reverseLinkedList(head.next);
            temp.next = head;
            head.next= null;
            return head;
        }else{
            return head;
        }
    }


}

class ListNode {
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
