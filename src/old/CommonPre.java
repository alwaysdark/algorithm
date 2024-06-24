package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/25 10:40
 * @Description:
 **************************************/
public class CommonPre {

    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","flight"};

        int min = strs[0].length();
        for(int i=1;i<strs.length;i++){
            min = Math.min(min,strs[i].length());
        }
        String common = "";
        flag:for(int i=0;i < min;i++){
            common = strs[0].substring(0,i+1);
            for(String o: strs){
                if(!o.substring(0,i+1).equals(common)){
                    common = strs[0].substring(0,i);
                    break flag;
                }
            }
        }
        System.out.println(common);
    }


}
