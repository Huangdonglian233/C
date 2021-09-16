package com.huang.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HasCircle {
    public static void main(String[] args) {
        ListNode l1=new ListNode(3,new ListNode(2,new ListNode(0,new ListNode(-4))));
        ListNode pos=l1;
        ListNode tail=l1;
        for(int i=0;i<1;i++){
            pos=pos.next;
        }
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=pos;
        boolean result=hasCycle(l1);
        System.out.println(result);
    }
    public static boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
//        Map<ListNode,ListNode> map=new HashMap<ListNode,ListNode>();
//        map.put(cur,cur);
//        while (!map.containsKey(cur.next)&&cur.next!=null){
//            cur=cur.next;
//            map.put(cur,cur);
//        }
//        if(cur.next==null){
//            return false;
//        }
//        return true;
        while(fast.next!=null){
            fast=fast.next;
            if(fast.next!=null){
                fast=fast.next;
            }
            if(fast==slow){
                return true;
            }
            slow=slow.next;
        }
        return false;
    }
}
