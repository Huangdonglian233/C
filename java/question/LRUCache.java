package com.huang.question;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

class LRUCache {
    ListNode listNode=new ListNode(null);
    Map<Integer,ListNode> map=new HashMap<Integer,ListNode>();
    Map<Integer,Integer> flagMap=new HashMap<Integer,Integer>();
    int cap=0;

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
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
//        System.out.println(key);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    public LRUCache(int capacity) {
        ListNode cur=listNode;
        for (int i = 0; i < capacity; i++) {
            ListNode temp=new ListNode(MIN_VALUE,null);
            cur.next=temp;
            cur=cur.next;
        }
        cap=capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            //System.out.println(flagMap);
            int value=flagMap.get(key);
            if(flagMap.size()>1) {
                int max=getMax(flagMap);
                flagMap.replace(key, value, max + 1);
            }else {
                flagMap.replace(key,value,value+1);
            }
            //System.out.println(flagMap);
            return map.get(key).val;
        }
        return -1;
    }
    public int getMax(Map map){
        int max=MIN_VALUE;
        for(int k: flagMap.keySet()){
            int tempValue=flagMap.get(k);
            if(max<tempValue){
                max=tempValue;
            }
        }
        return max;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            flagMap.replace(key, flagMap.get(key), flagMap.get(key) + 1);
        } else {
            ListNode temp = listNode;
            if (map.size() < cap) {
                while (temp != null && temp.val != MIN_VALUE) {
                    temp = temp.next;
                }
                if (temp == null) {
                    temp = new ListNode(MIN_VALUE, null);
                }
                temp.val = value;
                map.put(key, temp);
                if (map.size() == 1) {
                    flagMap.put(key, 1);
                } else {
                    int max = getMax(flagMap);
                    flagMap.put(key, max + 1);
                }
            } else {
                int min = MAX_VALUE;
                int tempKey = 0;
                int max = MIN_VALUE;
                for (int k : flagMap.keySet()) {
                    //System.out.println(k);
                    System.out.println(flagMap.keySet());
                    //System.out.println(flagMap.get(k));
                    int tempValue = flagMap.get(k);
                    if (min > tempValue) {
                        min = tempValue;
                        tempKey = k;
                    }
                    if (max < tempValue) {
                        max = tempValue;
                    }
                }
                map.get(tempKey).val = value;
                map.put(key, map.remove(tempKey));
                flagMap.remove(tempKey);
                flagMap.put(key, max + 1);
            }
        }
    }
}