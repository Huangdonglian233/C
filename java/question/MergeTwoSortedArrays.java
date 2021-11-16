package com.huang.question;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge1(nums1,3,nums2,3);
        for (int num:nums1) {
            System.out.print(num+" ");
        }
    }

    //方法一：
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while (i<m&&j<n){
            if(nums1[i]<nums2[j]){
                nums[k]=nums1[i];
                i++;
            }else {
                nums[k]=nums2[j];
                j++;
            }
            k++;
        }
        while (i<m){
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while (j<n){
            nums[k]=nums2[j];
            j++;
            k++;
        }
        i=0;
        for (int num:nums) {
            nums1[i]=num;
            i++;
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int tail=m+n-1;
        while (i>=0||j>=0){
            if(i==-1){
                nums1[tail]=nums2[j];
                j--;
            } else if(j==-1){
                nums1[tail]=nums1[i];
                i--;
            } else if(nums1[i]<nums2[j]){
                nums1[tail]=nums2[j];
                j--;
            }else {
                nums1[tail]=nums1[i];
                i--;
            }
            tail--;
        }
    }
}
