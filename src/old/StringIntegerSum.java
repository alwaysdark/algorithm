package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/9 11:05
 * @Description:
 **************************************/
public class StringIntegerSum {

    public static void main(String[] args) {

    }

    public String addStrings(String num1, String num2) {

        String max = num1.length() > num2.length() ? num1 : num2;
        String min = max.equals(num1) ? num2 : num1;
        if("".equals(min)){
            return max;
        }
        String sum = "";
        int x = 0;
        for(int i=0;i<max.length();i++){
            char a = max.charAt(max.length() -1 - i);
            char b;
            if(i >= min.length()){
                b = '0';
            }else{
                b = min.charAt(min.length() -1 -i);
            }
            int tmp = (a - '0')+(b - '0') + x;
            if(tmp >= 10){
                sum =  (tmp - 10) + sum;
                x = 1;
            }else{
                sum = tmp + sum;
                x = 0;
            }

        }
        if(x == 1){
            return '1' + sum;
        }
        return  sum;

    }

}
