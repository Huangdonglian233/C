package com.huang.question;
/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums={-4,-1,0,3,10};
        int[] results=sortedSquares(nums);
        System.out.println();
        for (int result:results) {
            System.out.print(result+" ");
        }
    }
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        sortArray(nums,l,r);
        for (int num: nums) {
            System.out.print(num+" ");
        }
        for (int i = 0; i < nums.length; i++) {
            result[i]=nums[i]*nums[i];
        }
        return result;

    }
    public static void sortArray(int[] nums,int l,int r) {
        if (l > r) {
            return;
        }
        int i = l;
        int j = r;
        int temp = nums[i];
        while (i < j) {
            while (i < j && Math.abs(nums[j]) >= Math.abs(temp)) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && Math.abs(nums[i]) <= Math.abs(temp)) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
//            for (int num: nums) {
//                System.out.print(num+",");
//            }
//            System.out.println();
        }
        nums[i] = temp;
        sortArray(nums, l, i - 1);
        sortArray(nums, i + 1, r);
    }
}
