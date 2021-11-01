package com.huang.question;

public class Search {
    public static void main(String[] args) {
        int[] nums={-1};
        int target=-1;
        int result=search(nums,target);
        System.out.println(result);
    }
    public static int search(int[] nums, int target) {
        int k=halfSearch(nums,0, nums.length-1, target);
        return k;
    }
    public static int halfSearch(int[] nums,int i,int j,int target){
        if(i>j){
            return -1;
        }
        int half=(i+j)/2;
        if(nums[half]==target){
            return half;
        }
        if(nums[half]<target){
            return halfSearch(nums,half+1,j,target);
        }
        if(nums[half]>target){
            return halfSearch(nums,i,half-1,target);
        }
        return -1;
    }
}
