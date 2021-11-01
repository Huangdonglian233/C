package com.huang.question;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums={1,3};
        int target=4;
        int result=searchInsert(nums,target);
        System.out.println(result);
    }
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        int mid=0;
        while (left+1<right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(nums[left]>=target)
            return left;
        if(nums[right]<target)
            return right+1;
        return right;
    }
}
