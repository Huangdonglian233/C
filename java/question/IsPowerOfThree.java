package com.huang.question;
//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//
//        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/power-of-three
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class IsPowerOfThree {
    public static void main(String[] args) {
        boolean b=isPowerOfThree(45);
        System.out.println(b);
    }
    public static boolean isPowerOfThree(int n) {
//        double sum=0;
//        int i=0;
//        while (sum<n){
//            sum=Math.pow(3,i);
//            i++;
//        }
//        if(sum==n){
//            return true;
//        }
//        return false;
        double temp=0;
        temp=n;
        while (temp>1){
            temp=temp/3;
            System.out.println(temp);
        }

        if(temp==1){
            return true;
        }
        return false;
    }
}
