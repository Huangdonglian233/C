package com.huang.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }

    //方法一
    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int temp = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            j = i;
            while (j< chars.length&&!list.contains(chars[j])){
                list.add(chars[j]);
                j++;
            }
            System.out.println(list);
            if(list.size() > temp)
                temp = list.size();
            if(j == chars.length){
                break;
            }
            list.clear();
        }
        return temp;
    }

    //方法二
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int maxLen = -1;
        int rk = -1;
        for (int j = 0; j < len; j++) {
            if(j != 0){
                set.remove(s.charAt(j-1));
            }
            while (rk+1 < len && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            maxLen = Math.max(maxLen,rk-j+1);
        }
        return maxLen;
    }
}
