package com.huang.question;
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//        你应当 保留 两个分区中每个节点的初始相对位置
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/partition-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SplitList {
    public static void main(String[] args) {
        ListNode l1= new ListNode(1,new ListNode(2,new ListNode(4,new ListNode(2,new ListNode(0,new ListNode(1))))));
        ListNode l2=new ListNode(1,new ListNode(1));
        ListNode result=partition(l2,2);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode insert=new ListNode(0,head);
        ListNode pre=insert;
        ListNode cur=head;
        head=insert;
        if(cur==null||cur.next==null){
            return head.next;
        }
        while (cur.next!=null&&cur.val<x){
            cur=cur.next;
            insert=insert.next;
            pre=pre.next;
        }
        if(cur.next==null){
            return head.next;
        }
        while (cur!=null){
            if(cur.val>=x){
                cur=cur.next;
                pre=pre.next;
            }else{
                pre.next=cur.next;
                cur.next=insert.next;
                insert.next=cur;
                cur=pre.next;
                insert=insert.next;
            }
        }
        return head.next;
    }
}
