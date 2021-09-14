package com.huang.question;

public class ReverseList2 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode l2=new ListNode(3,new ListNode(5));
        ListNode result=reverseBetween(l1,4,5);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumpyNode=new ListNode(-1,head);
        ListNode pre=dumpyNode;

        for(int i=1;i<left;i++){
            pre=pre.next;
        }
        ListNode rightNode=pre;
        for(int i=left;i<right+1;i++){
            rightNode=rightNode.next;
        }

        ListNode leftNode=pre.next;
        ListNode cur=rightNode.next;

        pre.next=null;
        rightNode.next=null;

        reverseList(leftNode);

        pre.next=rightNode;
        leftNode.next=cur;
        return dumpyNode.next;
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
