package com.huang.question;

import java.util.HashMap;
import java.util.Map;

public class HasCircle2 {
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
        ListNode result=detectCycle(l1);
        System.out.println(result);
    }
    public static ListNode detectCycle(ListNode head) {
        //方法一：
//        ListNode cur=head;
//        Map<ListNode,ListNode> map=new HashMap<ListNode,ListNode>();
//        map.put(cur,cur);
//        while (!map.containsKey(cur.next)&&cur.next!=null){
//            cur=cur.next;
//            map.put(cur,cur);
//        }
//        if(cur.next==null){
//            return null;
//        }
//        return cur.next;
        //方法二：
//        ListNode pos=head;
//        Map<ListNode,ListNode> map=new HashMap<ListNode,ListNode>();
//
//        while (pos!=null){
//            map.put(pos,pos);
//            if(!map.containsKey(pos)){
//                pos=pos.next;
//            }else{
//                return pos;
//            }
//        }
//        return null;
        //方法三
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=null){
                fast=fast.next;
            }else {
                return null;
            }
            if(fast==slow){
                ListNode cur=head;
                while (cur!=slow){
                    slow=slow.next;
                    cur=cur.next;
                }
                return cur;
            }
        }
        return null;
    }
}
