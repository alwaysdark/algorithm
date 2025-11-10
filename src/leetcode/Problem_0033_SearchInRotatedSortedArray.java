package leetcode;

public class Problem_0033_SearchInRotatedSortedArray {
    /**
     * 这个题说明了一个很重要的场景，即：二分的前提条件不是整个数组必须有序
     *                               在数组旋转一次的条件下，只需要[L] [M] [R]不都一样就可以二分
     */
    public static int search(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L <= R){
            M = (L + R) / 2;
            if(arr[M] == num) {
                return M;
            }
            // arr[M] != num
            if(arr[L] == arr[M] && arr[M] == arr[R]){
                while (L != M && arr[L] == arr[M]){
                    L++;
                }
                // 代表两种含义：1、L和M撞上, L一路和M相等，直接二分去另一半去查找 2、L和M没撞上，说明[L]!=[M]，走26行[L] [M] [R] 不都一样的情况的逻辑
                // L和M没撞上，[L]!=[M] L,.....M
                if(L == M){
                    L = M + 1;
                    continue;
                }
            }
            // arr[M] != num
            // [L] [M] [R] 不都一样的情况
            if(arr[L] != arr[M]){
                if(arr[M] > arr[L]){
                    if(num >=arr[L] && num < arr[M]){
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else { //  [L]  >  [M]
                    if(num > arr[M] && num <= arr[R]){
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            } else { // [L] === [M] ->  [M]!=[R]
                if(arr[M] < arr[R]){
                    if(num > arr[M] && num <= arr[R]){
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if(num >= arr[L] && num < arr[M]){
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }
}
