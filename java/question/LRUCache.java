package com.huang.question;

import java.util.*;

//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
//实现 LRUCache 类：
//
//LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
// 
//
//进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lru-cache
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class LRUCache {
//    ListNode listNode=new ListNode(null);
//    Map<Integer,ListNode> map=new HashMap<Integer,ListNode>();
//    Map<Integer,Integer> flagMap=new HashMap<Integer,Integer>();
//    int cap=0;
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        DLinkedNode(){

        }
        DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private Map<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public static void main(String[] args) {
//        LRUCache lruCache=new LRUCache(2);
//        lruCache.put(2,1);
//        System.out.println("1"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        lruCache.put(2,2);
//        System.out.println("2"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        System.out.println(lruCache.get(2));
//        System.out.println("3"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        lruCache.put(1,1);
//        System.out.println("4"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        lruCache.put(4,1);
//        System.out.println("5"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        System.out.println(lruCache.get(2));
//        System.out.println("6"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        System.out.println(lruCache.get(1));
//        System.out.println("7"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        System.out.println(lruCache.get(3));
//        System.out.println("8"+lruCache.map);
//        System.out.println(lruCache.flagMap);
//        int key=lruCache.get(4);
////        System.out.println(key);
//        System.out.println(lruCache.get(2));
//        lruCache.put(2,6);
//        System.out.println(lruCache.get(1));
//        lruCache.put(1,5);
//        lruCache.put(1,2);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
    }

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.pre=head;
//        ListNode cur=listNode;
//        for (int i = 0; i < capacity; i++) {
//            ListNode temp=new ListNode(MIN_VALUE,null);
//            cur.next=temp;
//            cur=cur.next;
//        }
//        cap=capacity;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
//        if(map.containsKey(key)){
//            //System.out.println(flagMap);
//            int value=flagMap.get(key);
//            if(flagMap.size()>1) {
//                int max=getMax(flagMap);
//                flagMap.replace(key, value, max + 1);
//            }else {
//                flagMap.replace(key,value,value+1);
//            }
//            //System.out.println(flagMap);
//            return map.get(key).val;
//        }
//        return -1;
    }
    public void addToHead(DLinkedNode node){
        DLinkedNode hNext=head.next;
        head.next=node;
        node.pre=head;
        node.next=hNext;
        hNext.pre=node;
    }

    public DLinkedNode removeToTail(){
        DLinkedNode node=tail.pre;
        DLinkedNode tPre=tail.pre.pre;
        tail.pre=tPre;
        tPre.next=tail;
        return node;
    }

    public void removeNode(DLinkedNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    //    public int getMax(Map map){
//        int max=MIN_VALUE;
//        for(int k: flagMap.keySet()){
//            int tempValue=flagMap.get(k);
//            if(max<tempValue){
//                max=tempValue;
//            }
//        }
//        return max;
//    }
    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkedNode tail=removeToTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
//        if (map.containsKey(key)) {
//            map.get(key).val = value;
//            flagMap.replace(key, flagMap.get(key), flagMap.get(key) + 1);
//        } else {
//            ListNode temp = listNode;
//            if (map.size() < cap) {
//                while (temp != null && temp.val != MIN_VALUE) {
//                    temp = temp.next;
//                }
//                if (temp == null) {
//                    temp = new ListNode(MIN_VALUE, null);
//                }
//                temp.val = value;
//                map.put(key, temp);
//                if (map.size() == 1) {
//                    flagMap.put(key, 1);
//                } else {
//                    int max = getMax(flagMap);
//                    flagMap.put(key, max + 1);
//                }
//            } else {
//                int min = MAX_VALUE;
//                int tempKey = 0;
//                int max = MIN_VALUE;
//                for (int k : flagMap.keySet()) {
//                    //System.out.println(k);
//                    System.out.println(flagMap.keySet());
//                    //System.out.println(flagMap.get(k));
//                    int tempValue = flagMap.get(k);
//                    if (min > tempValue) {
//                        min = tempValue;
//                        tempKey = k;
//                    }
//                    if (max < tempValue) {
//                        max = tempValue;
//                    }
//                }
//                map.get(tempKey).val = value;
//                map.put(key, map.remove(tempKey));
//                flagMap.remove(tempKey);
//                flagMap.put(key, max + 1);
//            }
//        }
//    }
    }
}