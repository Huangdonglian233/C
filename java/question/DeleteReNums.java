package com.huang.question;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
//        返回同样按升序排列的结果链表。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class DeleteReNums {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3)))));
        ListNode result=deleteDuplicates(l1);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre= new ListNode(0,head);
        ListNode cur=pre;
        while (cur.next!=null&&cur.next.next!=null) {
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return pre.next;
    }
}
