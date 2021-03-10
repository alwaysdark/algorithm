package com.dark;

import java.util.HashSet;
import java.util.Set;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/10 17:15
 * @Description:
 **************************************/
public class LengthOfLongestSubstring {

    public static void main(String[] args) throws Exception{

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));


    }
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet();
        int l=0,r=0,max=0;
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            max = Math.max(r-l,max);
        }
        return max;
    }
}
