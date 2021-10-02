package com.huang.question;

//还需掌握二分查找法
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null&&nums2==null){
            return 0;
        }else if(nums1==null){
            double median=(double) (1+nums2.length)/2;
            if(judge(median)){
                return nums2[(int)median-1];
            }else {
                return (double)(nums2[(int)median-1]+nums2[(int)median])/2;
            }
        }else if(nums2==null){
            double median=(double) (1+nums1.length)/2;
            if(judge(median)){
                return nums1[(int)median-1];
            }else {
                return (double)(nums1[(int)median-1]+nums1[(int)median])/2;
            }
        }else {
            double median = (double) (1+nums1.length + nums2.length) / 2;
//            System.out.println(median);
            int k = 0;
            int temp1 = 0;
            int temp2 = 0;
            int i = 0;
            int j = 0;
            boolean flag=true;
            while (k < (int) median) {
                if (nums1[i] < nums2[j]) {
                    temp1 = nums1[i];
                    i++;
                    flag=true;
                } else {
                    temp1 = nums2[j];
                    j++;
                    flag=false;
                }
                k++;
            }
            if(judge(median)){
                return flag?nums1[i-1]:nums2[j-1];
            }
//            System.out.println(temp1);
//            System.out.println(k);
//            System.out.println(i);
//            System.out.println(j);
            if(nums1.length==i){
                temp2=nums2[j];
                System.out.println("if");
            }else if(nums2.length==j){
                temp2=nums1[i];
                System.out.println("else if");
            }else {
                temp2=nums1[i]<nums2[j]?nums1[i] :nums2[j];
            }
//            System.out.println(temp1);
//            System.out.println(temp2);
            median=(double) (temp1+temp2)/2;
            return median;
        }

//        if(nums1==null&&nums2==null){
//            return 0;
//        }else if(nums1==null){
//            return getMedian(nums2);
//        }else if(nums2==null){
//            return getMedian(nums1);
//        }else {
//            int[] nums = new int[nums1.length + nums2.length];
//            int k = 0;
//            int i = 0;
//            int j = 0;
//            while (i < nums1.length && j < nums2.length) {
//                if (nums1[i] < nums2[j]) {
//                    nums[k] = nums1[i];
//                    i++;
//                } else {
//                    nums[k] = nums2[j];
//                    j++;
//                }
//                k++;
//            }
//            while (i < nums1.length) {
//                nums[k] = nums1[i];
//                i++;
//                k++;
//            }
//            while (j < nums2.length) {
//                nums[k] = nums2[j];
//                j++;
//                k++;
//            }
//            double median = getMedian(nums);
//            return median;
//        }
//    }
//    public static double getMedian(int[] nums){
//        double median= (double)(1+nums.length)/2;
////        for (int l = 0; l < nums.length; l++) {
////            System.out.println(nums[l]);
////        }
////        System.out.println(median);
////        System.out.println((int)median);
//        if(Math.round(median)==median){
//            median=nums[(int)median];
//        }else{
//            median=(double)(nums[(int)median-1]+nums[(int)median])/2;
//            System.out.println(nums[(int)median]);
//        }
//        return median;
//    }
    }
    public static boolean judge(double median){
        if(Math.round(median)==median){
            return true;
        }else {
            return false;
        }
    }
}
