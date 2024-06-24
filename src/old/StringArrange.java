package com.dark;

import java.util.ArrayList;
import java.util.TreeSet;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/9 22:43
 * @Description:
 **************************************/
public class StringArrange {

    public static void main(String[] args) {
        String str = "abc";
        char[] data = str.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        permutation(data, 0, result);
        for(String s: result){
            System.out.println(s);
        }
        System.out.println("===================");
        //利用TreeSet进行排序和去除重复的元素
        TreeSet<String> set = new TreeSet<String>();
        set.addAll(result);
        result.clear();
        result.addAll(set);
        for(String s: result){
            System.out.println(s);
        }

    }

    public static void permutation(char[] data, int beginIndex, ArrayList<String> result) {

        if(beginIndex == data.length-1){
            result.add(new String(data));
        }else{
            for(int i=beginIndex;i<data.length;i++){
                if(i != beginIndex && data[i] == data[beginIndex]){
                    continue;
                }
                char tmp = data[beginIndex];
                data[beginIndex] = data[i];
                data[i] = tmp;
                permutation(data,beginIndex+1,result);
                tmp = data[beginIndex];
                data[beginIndex] = data[i];
                data[i] = tmp;

            }
        }
    }


}
