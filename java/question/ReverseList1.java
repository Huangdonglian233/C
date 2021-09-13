package com.huang.question;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class ReverseList1 {
    public static void main(String[] args) {
        ListNode l1= new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3))))));
        ListNode result=reverseList(l1);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head.next;
        ListNode pre=head.next;
        head.next=null;
        while (cur!=null){
            cur=cur.next;
            pre.next=head;
            head=pre;
            pre=cur;
        }
        return head;
    }
}
