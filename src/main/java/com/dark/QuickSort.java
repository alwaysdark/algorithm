package com.dark;


/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/23 16:43
 * @Description:
 **************************************/
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        quickSort(arr,0,arr.length-1);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void quickSort(int[] arr,int lo,int hi) {

        if(lo >= hi){
            return;
        }
        int base = arr[lo];
        int i = lo, j = hi+1;
        while(true){
            while(arr[++i] < base){
                if(i == hi){
                    break;
                }
            }
            while(arr[--j] > base){
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
        arr[lo] = arr[j];
        arr[j] = base;
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);

    }


}
