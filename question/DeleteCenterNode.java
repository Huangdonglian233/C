package com.huang.question;
//若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
//
//        假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
//
//        例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class DeleteCenterNode {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
