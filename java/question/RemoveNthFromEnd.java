package com.huang.question;

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,
                new ListNode(5)))));
        int n=1;
        ListNode result=removeNthFromEnd(head,n);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null&&n==1){
            return null;
        }
        int i=0;
        ListNode later=head;
        ListNode before=head;
        while (i<n){
            later=later.next;
            i++;
        }
        if(later==null){
            head=head.next;
            return head;
        }
        while (later.next!=null){
            before=before.next;
            later=later.next;
        }
        before.next=before.next.next;
        return head;
    }
}
