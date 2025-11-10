package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Problem_0056_MergeIntervals {

    public static class Range{
        public int start;
        public int end;
        public Range(int s, int e){
            start = s;
            end = e;
        }
    }

    public static class RangeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o1[1];
        }
    }



//    public int[][] merge(int[][] intervals) {
//
//        Range[] arr = new Range[intervals.length];
//        for(int i=0; i< intervals.length; i++){
//            arr[i] = new Range(intervals[i][0], intervals[i][1]);
//        }
//        Arrays.sort(arr, new RangeComparator());
//        for(int i=0; i<arr.length ;i++){
//            int curL = intervals[i][0];
//            //需要合并
//            if(curL <= preR){
//                int[] n = new int[]{intervals[i-1][0], intervals[i][1]};
//                ans[index++] = n;
//            }
//            preR = intervals[i][1];
//        }
//    }
}
