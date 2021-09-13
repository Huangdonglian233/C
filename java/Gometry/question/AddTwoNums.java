package com.huang.question;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/add-two-numbers
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class AddTwoNums {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode l3=addTwoNumbers(l1,l2);
        while (l3!=null){
            System.out.print(l3.val);
            l3=l3.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int temp = 0;
        int temp2 = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            temp2 = (n1 + n2 + temp) / 10;
            if (head == null) {
                head = tail = new ListNode((n1 + n2 + temp) % 10);
            } else {
                tail.next = new ListNode((n1 + n2 + temp) % 10);
                tail=tail.next;
            }
            temp = temp2;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(temp!=0){
            tail.next=new ListNode(temp);
        }
        return head;
    }
}
