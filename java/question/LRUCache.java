package com.huang.question;

import java.util.*;

class LRUCache {
    List<Integer> list;
    int[] sum;
    int cap;

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        int key=lruCache.get(1);
        System.out.println(key);
    }

    public LRUCache(int capacity) {
        sum=new int[capacity];
        list=new ArrayList<Integer>(capacity);
        cap=capacity;
    }

    public int get(int key){
        int i=0;
        while (i<list.size()&&list.get(i)!=key){
            i++;
            continue;
        }
        if(i>=list.size()){
            return 0;
        }
        sum[i]++;
        return list.get(key-1);
    }

    public void put(int key, int value) {
        if(list.size()<cap){
            list.add(value);
        }
    }
}