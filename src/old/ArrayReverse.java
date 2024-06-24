package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/24 10:23
 * @Description:
 **************************************/
public class ArrayReverse {

    public static void main(String[] args) {

        char[] arr = {'h','e','l','l','o','c','e'};

        int i = 0;
        int j = arr.length - 1;
        reverse(arr,i,j);
        for(char o:arr){
            System.out.println(o);
        }


    }

    public static void reverse(char[] arr,int lo,int hi){
        if(lo >= hi){
            return;
        }
        char tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
        reverse(arr,++lo,--hi);
    }

//    public static void reverse(char[] arr){
//
//        int l = arr.length;
//        for(int i=0;i<=(l-1)/2;i++){
//            char tmp = arr[i];
//            arr[i] = arr[l-1-i];
//            arr[l-1-i] = tmp;
//        }
//    }
}
