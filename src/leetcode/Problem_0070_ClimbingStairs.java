package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Problem_0070_ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;
        climbStairs(n, cache);
        return cache[n];
    }
    public int climbStairs(int n, int[] cache) {
        if(cache[n] > 0){
            return cache[n];
        }
        int ans1 = climbStairs(n - 1, cache);
        int ans2 = climbStairs(n - 2, cache);
        cache[n] = ans1 + ans2;
        return cache[n];

    }

}
