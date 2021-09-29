package com.huang.question;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(4,new ListNode(2,
                new ListNode(1,new ListNode(3))));
        ListNode l2=insertionSortList(l1);
        while (l2!=null){
            System.out.print(l2.val +" ");
            l2=l2.next;
        }

    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode pre=preHead;
        ListNode cur=head;
        ListNode succ = cur.next;
        while (succ!=null) {
            if (succ.val < preHead.next.val) {
                pre=preHead;
                while (pre.next!=succ){
                    pre=pre.next;
                }
                head=preHead.next;
                ListNode node=succ.next;
                preHead.next=succ;
                succ.next=head;
                pre.next=node;
                succ=node;
            }

        }
        return preHead.next;
    }

}
