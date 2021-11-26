package com.huang.question;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
