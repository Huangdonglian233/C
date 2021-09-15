package com.huang.question;

import java.util.Arrays;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Remove {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int sum=removeDuplicates(nums);
        for(int i=0;i<sum;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int sum=0;
        if(nums.length==0){
            return 0;
        }
        int temp=nums[nums.length-1]+1;
        for(int i=0;i< nums.length-1;i++){
            for(int j=0;j< nums.length-1;j++)
            if(nums[j+1]==nums[j]){
                nums[j+1]=temp;
            }
            Arrays.sort(nums);
        }
        for(int i=0;i< nums.length;i++){
            if(nums[i]<temp){
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
