package com.huang.question;
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/remove-element
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class removeElement {
    public static void main(String[] args) {
        int[] nums={3,2,3,3};
        int sum=remove(nums,3);
        for(int i=0;i<sum;i++){
            System.out.print(nums[i]+" ");
        }

    }
    public static int remove(int[] nums,int val){
        int left=0,right=nums.length;
        while (left<right){
            if(nums[left]!=val){
                left++;
            }
            else{
               nums[left]=nums[right-1];
               right--;
            }
        }
        return left;
    }
}
