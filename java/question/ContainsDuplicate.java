package com.huang.question;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        boolean result=containsDuplicate(nums);
        System.out.println(result);
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }
        return nums.length== set.size()?false:true;
    }
}
/*
方法一：
Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
方法二：
List<Integer> list = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(list.contains(nums[i]))
                return true;
            list.add(nums[i]);
        }
        return false;
 */