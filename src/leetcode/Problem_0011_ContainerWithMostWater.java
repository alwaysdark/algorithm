package leetcode;

public class Problem_0011_ContainerWithMostWater {
    /*
    * 思路是这样的，从左右两边往中间尝试，谁小结算谁，虽然做了可能性舍弃，可能不是当前位置的最优解，但是，最好的解在整个过程中不会丢失
    */
    public static int maxArea(int[] h) {
        int max = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if (h[l] > h[r]){
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
