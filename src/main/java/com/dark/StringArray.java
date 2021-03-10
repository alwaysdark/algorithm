package com.dark;

import java.util.ArrayList;
import java.util.List;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/10 17:21
 * @Description: leetcode 567
 **************************************/
public class StringArray {

    public static void main(String[] args) {

        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1,s2));


    }

    public static boolean checkInclusion(String s1, String s2) {


        char[] chars = s1.toCharArray();
        int[] base = new int[26];
        for(char o:chars){
            base[o-'a'] = 1+base[o-'a'];
        }

        for(int i=s1.length();i<=s2.length();i++){
            String sub = s2.substring(i - s1.length(), i);
            if(getArrange(sub,base)){
                return true;
            }
        }
        return false;
    }

    public static boolean getArrange(String sub,int[] base){

        char[] chars = sub.toCharArray();
        int[] b = new int[26];
        for(char o:chars){
            b[o-'a'] = 1+b[o-'a'];
        }
        for(int i=0;i<26;i++){
            if(base[i] != b[i]){
                return false;
            }
        }
        return true;

    }
}
