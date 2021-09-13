package com.huang.question;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
//        返回同样按升序排列的结果链表。
public class DelReNums {
    public static void main(String[] args) {
        ListNode l1= new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3))))));
        ListNode result=deleteDuplicates1(l1);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode deleteDuplicates1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            if(cur.val== pre.val){
                cur=cur.next;
                pre.next=cur;
            }else{
                cur=cur.next;
                pre=pre.next;
            }
        }
        return head;
    }
}
