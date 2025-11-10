package leetcode;

public class Problem_0045_JumpGameII {

    /**
     * 定义三个变量：
     * step 当前最少跳几步能到i
     * cur 跳的步数不超过step,最右能跳到哪
     * next 跳的步数不超过step+1,最右能跳到哪，用来给cur准备数据
     * 根据题意，初始位置在i==0，所以step初始值0，cur初始值0，next为nums[0]，从1开始遍历
     * 1) i> cur,step步不足以到i，step++，更新cur，看是否需要更新next
     * 2) i<= cur,step步可以到达i，看是否需要更新next
     *
     * */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int step = 0;
        int cur = 0;
        int next = nums[0];
        for(int i=1; i< nums.length; i++){
            if(i > cur){
                step++;
                cur = next;
            }
            next = Math.max(next, i + nums[i]);
        }
        return step;
    }




}
