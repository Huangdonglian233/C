package com.huang.question;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//        进阶：你能尝试使用一趟扫描实现吗？
//

public class DeleteEndN {

      public static ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode p=head;
          ListNode q=head;
          if(head.next==null&&n==1){
              return null;
          }
          for(int i=1;i<=n;i++){
                p=p.next;
          }
          if(p==null){
              head=head.next;
              return head;
          }
          while(p.next!=null){
              p=p.next;
              q=q.next;
          }
          if(p.next==null){
              q.next=q.next.next;
          }
          return head;
      }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,null)));
        int n=3;
        ListNode result=removeNthFromEnd(head,n);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}
