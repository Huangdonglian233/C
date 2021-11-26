package com.huang.question;

import java.util.Arrays;
/*
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m>n){
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < m; i++) {
            ++count1[s1.charAt(i)-'a'];
            ++count2[s2.charAt(i)-'a'];
        }

        if(Arrays.equals(count1,count2)){
            return true;
        }

        for (int i = m; i < n; i++) {
            ++count2[s2.charAt(i)-'a'];
            --count2[s2.charAt(i-m)-'a'];
            if(Arrays.equals(count1,count2))
                return true;
        }

        return false;
    }
}
