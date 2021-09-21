package com.huang.question;

import java.util.ArrayList;
import java.util.List;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//         L0 → L1 → … → Ln-1 → Ln 
//        请将其重新排列后变为：
//
//        L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//
//        不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reorder-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ReorderList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3)));
        reorderList(l1);
        while (l1!=null){
            System.out.print(l1.val+" ");
            l1=l1.next;
        }
    }
    public static void reorderList(ListNode head) {
        ListNode cur=head;
        List<ListNode> list=new ArrayList<ListNode>();
        while (cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        int i=0;
        int j=list.size()-1;
        while (i<j){
            list.get(i).next= list.get(j);
            if(i==j) {
                break;
            }
            i++;
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
//        if(head==null||head.next==null){
//            return;
//        }
//        ListNode temp=head;
//        ListNode  pre=reverse(head);
//        if(pre==null||pre.next==null){
//            return;
//        }
//        ListNode cur=head;
//        ListNode successor=head.next;
//        ListNode cur1=pre.next;
//        int sum=0;
//
//        while (successor!=null){
//            cur.next=pre;
//            pre.next=successor;
//            pre=cur1;
//            cur=successor;
//            successor=successor.next;
//            cur1=cur1.next;
//            sum++;
//        }
//        pre=head;
//        for(int i=0;i<sum;i++){
//            pre=pre.next;
//        }
//        pre.next=null;
//        return;
//    }
//
//    public static ListNode reverse(ListNode head){
//        ListNode temp=head;
//        ListNode head1=null;
//        head1=new ListNode(temp.val);
//        ListNode tt=head1;
//        while(temp.next!=null){
//            temp=temp.next;
//            ListNode temp1=new ListNode(temp.val);
//            tt.next=temp1;
//            tt=tt.next;
//        }
//        ListNode cur=head1.next;
//        ListNode succ = cur;
//        if(cur!=null) {
//            succ = cur.next;
//        }
//        head1.next=null;
//        while(cur!=null){
//            cur.next=head1;
//            head1=cur;
//            cur=succ;
//            if(succ!=null)
//                succ=succ.next;
//        }
//        return head1;
//    }
}

