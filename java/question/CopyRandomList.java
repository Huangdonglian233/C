package com.huang.question;


import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    Map<Node,Node> hashMap=new HashMap<Node,Node>();
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
          if(head==null){
              return null;
          }
          if(!hashMap.containsKey(head)){
              Node headNew=new Node(head.val);
              hashMap.put(head,headNew);
              headNew.next=copyRandomList(head.next);
              headNew.random=copyRandomList(head.random);
          }
          return hashMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val=val;
        this.next=null;
        this.random=null;
    }
}