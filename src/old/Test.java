package com.dark;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/4 11:13
 * @Description:
 **************************************/
public class Test {

    public static void main(String[] args) throws Exception{

//        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
//
//        System.out.println("排序之前：");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        System.out.println("排序之后：");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        

        Integer[] nums = {1,2,3};

        //nums = {2};

        List<List<Integer>> list = new ArrayList<>();
        HashSet<String> set = new HashSet();

        for(List<Integer> integers:list){
            String str = "";
            for(Integer ss: integers){
                str += ss;
            }
            set.add(str);
        }
        list.clear();
        for(String aa:set){
            String[] split = aa.split("");
            List<Integer> cc = new ArrayList<>();
            for(String bb: split){
                cc.add(Integer.valueOf(bb));
            }
            list.add(cc);
        }

        ConcurrentHashMap m = new ConcurrentHashMap();
        m.put("","");

        Map map = new HashMap();
        map.put("","");


        LinkedList l = new LinkedList();

        AtomicInteger i = new AtomicInteger();






    }








}



