package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/24 16:08
 * @Description:
 **************************************/

/**
 * leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,8,8};
        int key = 8;
        int[] res = new BinarySearch().searchRange(arr,key);
        System.out.println();
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (null == nums || nums.length == 0) {
            return result;
        }
        int pos = findPos(nums, target, 0, nums.length-1);
        if (pos == -1) {
            return result;
        }
        result[0] = testPosL(nums, target, 0, pos);
        result[1] = testPosR(nums, target, pos, nums.length - 1);
        return result;
    }

    public int findPos(int[] nums, int target, int start, int end) {
        int pos = (start + end) / 2;
        if (null == nums || nums.length == 0 || start > end) {
            return -1;
        }
        int m = nums[pos];
        if (m == target) {
            return pos;
        }
        if (m > target) {
            return findPos(nums, target, start, pos-1);
        } else {
            return findPos(nums, target, pos + 1, end);
        }

    }

    private int testPosL(int[] nums, int target, int l, int r) {
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l < 0 || l > nums.length - 1 || nums[l] != target)
            return -1;
        return l;
    }

    private int testPosR(int[] nums, int target, int l, int r) {
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (r < 0 || r > nums.length - 1 || nums[r] != target)
            return -1;
        return r;
    }


    /**
     * 二分查找 递归
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
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
