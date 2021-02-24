package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/2/24 14:08
 * @Description:
 **************************************/
public class NumIslands {

    public static void main(String[] args) {

        String[][] arr = {{"1","1","0","0","0"},{"1","1","0","0","0"},{"0","0","1","0","0"},{"0","0","0","1","1"}};

        System.out.println(solution(arr));

    }

    static int m,n;
    public static int solution(String[][] arr){

        m = arr.length;
        if(m==0){
            return 0;
        }
        n = arr[0].length;
        int sum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if("1".equals(arr[i][j])){
                    dfsMarking(arr,i,j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void dfsMarking(String[][] arr,int i,int j) {

        if(i>=m || i<0 || j>=n || j<0 || "0".equals(arr[i][j])){
            return;
        }
        arr[i][j] = "0";
        dfsMarking(arr,i+1,j);
        dfsMarking(arr,i-1,j);
        dfsMarking(arr,i,j-1);
        dfsMarking(arr,i,j+1);
    }
}
