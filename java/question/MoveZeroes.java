package com.huang.question;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        for (int num:nums) {
            System.out.print(num+" ");
        }
    }
    public static void moveZeroes(int[] nums) {
        /*int i=0;
        while (i< nums.length&&nums[i]!=0) {
            i++;
        }
        int j=i+1;
        while (j< nums.length){
            if(nums[j]==0){
                j++;
            }else{
                nums[i]=nums[j];
                j++;
                i++;
            }
        }
        while (i< nums.length){
            nums[i]=0;
            i++;
        }*/
        int i=0;
        int j=0;
        while (j< nums.length){
            if(nums[j]!=0){
                nums[i++]=nums[j];
            }
            ++j;
        }
        for(int k=i;k< nums.length;k++){
            nums[k]=0;
        }
    }
}
