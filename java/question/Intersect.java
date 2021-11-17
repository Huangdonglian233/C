package com.huang.question;

import java.util.ArrayList;
import java.util.List;

/*
给定两个数组，编写一个函数来计算它们的交集。
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result=intersect1(nums1,nums2);
        for (int num: result) {
            System.out.print(num+" ");
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int num:nums1) {
            list.add(num);
        }
        List<Integer> list1 = new ArrayList<>();
        for (int num:nums2) {
            if(list.contains(num)){
                list1.add(num);
                list.remove(list.indexOf(num));
            }
        }
        int[] result = new int[list1.size()];
        int k=0;
        for (int num:list1) {
            result[k] = num;
            k++;
        }
        return result;
    }
    public static int[] intersect1(int[] nums1, int[] nums2){
        SortArray.sortArray(nums1);
        SortArray.sortArray(nums2);
        List<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<nums1.length&&j< nums2.length){
            if(nums1[i]==nums2[j]){
                System.out.println(1);
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                System.out.println(2);
                i++;
            }else {
                System.out.println(3);
                j++;
            }
        }
        int[] result = new int[list.size()];
        int k=0;
        for (int num:list) {
            result[k]=num;
            k++;
        }
        return result;
    }
}
