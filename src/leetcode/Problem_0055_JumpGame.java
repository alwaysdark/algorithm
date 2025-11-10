package leetcode;

public class Problem_0055_JumpGame {

    /**
     * 思路是这样：
     * 定义max变量，代表能跳到的最大位置
     * 题意是：最初位于数组的第一个下标，所以0位置必能到，同时最初的max是nums[0]，从1开始测试
     * 每次迭代先判断之前的max能不能保证跳到i位置，能到达再根据当前的nums[i]看能不能调大max值
     * */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int max = nums[0];
        for(int i=1; i < nums.length; i++){
            if(i > max){
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
