package com.huang.question;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
public class SwapNode {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,
                new ListNode(5,new ListNode(6,new ListNode(7)))))));
        ListNode result=swapPairs(l1);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode first;
        ListNode second;
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        second=temp.next;
        temp.next=second.next;
        second.next=head;
        head=second;
        first=temp;
        while (first.next!=null){
            if(first.next.next==null){
                return head;
            }
            first=first.next;
            second=first.next;
            temp.next=second;
            first.next=second.next;
            second.next=first;
            if(first.next==null){
                return head;
            }
            temp=first;
        }
        return head;
    }
}
