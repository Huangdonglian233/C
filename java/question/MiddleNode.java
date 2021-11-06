package com.huang.question;

import java.util.ArrayList;
/*
给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode temp=middleNode(listNode);
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
    public static ListNode middleNode(ListNode head) {
        ArrayList<ListNode> nodeArrayList=new ArrayList<>();
        ListNode node=head;
        while (node!=null) {
            nodeArrayList.add(node);
            node = node.next;
        }
        int len=nodeArrayList.size();
        int position=len/2;
        return nodeArrayList.get(position);
    }
}
