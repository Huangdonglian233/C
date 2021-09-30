package com.huang.question;

//对链表进行插入排序。
//
//
//        插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//        每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//         
//
//        插入排序算法：
//
//        插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//        每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//        重复直到所有输入数据插入完为止。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/insertion-sort-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(4,new ListNode(2,
                new ListNode(1,new ListNode(3))));
        // -1->5->3->4->0
        ListNode l3=new ListNode(-1,new ListNode(5,new ListNode(3,
                    new ListNode(4,new ListNode(0)))));
        ListNode l2=insertionSortList(l3);
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
        ListNode lastSorted=head;
        ListNode curr=head.next;
        while (curr!=null) {
            if(curr.val>= lastSorted.val){
                lastSorted=lastSorted.next;
            }else {
                ListNode pre=preHead;
                while (pre.next.val<=curr.val){
                    pre=pre.next;
                }
                lastSorted.next=curr.next;
                curr.next=pre.next;
                pre.next=curr;
            }
            curr=lastSorted.next;
        }
        return preHead.next;
    }

    public static ListNode removeNode(ListNode pre){
        ListNode node=pre.next;
        pre.next=pre.next.next;
        return node;
    }

    public static void insertList(ListNode preHead,ListNode node){
        ListNode cur=preHead;
        while (cur.next!=null) {
            if (node.val < cur.next.val) {
                ListNode succ = cur.next;
                cur.next = node;
                node.next = succ;
                break;
            } else {
                cur = cur.next;
            }
        }
        if(cur.next==null){
            cur.next=node;
            node.next=null;
        }
    }
}
