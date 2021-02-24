package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/24 16:08
 * @Description:
 **************************************/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int key = 4;
        System.out.println(binarySearch(arr,key,0,arr.length-1));
    }

    public static int binarySearch(int[] array,int key,int low,int high){

        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        int middle = (low+high)/2;
        if(array[middle]>key){
            //大于关键字
            return binarySearch(array,key,low,middle-1);
        }else if(array[middle]<key){
            //小于关键字
            return binarySearch(array,key,middle+1,high);
        }else{
            return middle;
        }
    }
}
