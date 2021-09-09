package com.huang.question;

//给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
//
//        ans[i] == nums[i]
//        ans[i + n] == nums[i]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/concatenation-of-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class ConnectedArrays {
    public static void main(String[] args) {
        int[] nums = {};
        int[] ans=getConcatenation(nums);
        for (int i=0;i< ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] getConcatenation(int[] nums){
        int[] ans=new int[nums.length*2];
        int right=nums.length;
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
            ans[right+i]=nums[i];
        }
        return ans;
    }
}
