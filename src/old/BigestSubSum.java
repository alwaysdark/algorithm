package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/25 13:58
 * @Description:最大子序和 leetcode53
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 **************************************/
public class BigestSubSum {

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sum(arr));

    }

    public static int sum(int[] arr){

        int[] dp = new int[arr.length+1];
        dp[0] = 0;
        for(int i=0;i<arr.length;i++){
            dp[i+1] = Math.max(dp[i]+arr[i],arr[i]);
        }
        int sum = dp[1];
        for(int i=1;i<dp.length;i++){
            if(dp[i]>sum){
                sum = dp[i];
            }
        }
        return sum;
    }
}
