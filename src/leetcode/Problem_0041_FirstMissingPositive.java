package leetcode;

public class Problem_0041_FirstMissingPositive {
    /**
     * 两个变量的含义，需要在移动过程中严格保证:
     * 1.L代表[0, L-1]范围上所有i满足[i]位置数是（i+1）, 初始L=0,代表没有范围符合要求
     * 2.R代表最好预期下（所有数都没看过）可以得到的最大数，最好预期是得到1~R连续正整数
     *
     * [L] == L+1，L++ 这是正常情况
     * 需要和R交换的三种情况：
     * 1、[L]> R ,L和R前一个元素交互，R--;
     * 2、[L]<= L ,L和R前一个元素交互，R--;
     * 3、[L] == V, 应该将V放到V-1位置，如果V-1位置也为V,将L和R前一个元素交互，R--;
     *
    */
    public int firstMissingPositive(int[] nums) {
        int L = 0;
        int R = nums.length;
        while (L < R){
            if(nums[L] == L + 1){
                L++;
            } else if (nums[L] <= L || nums[L] > R || nums[nums[L] - 1] == nums[L]){
                swap(nums, L, --R);
            } else {
                swap(nums, L, nums[L] - 1);
            }
        }
        return L + 1;
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
