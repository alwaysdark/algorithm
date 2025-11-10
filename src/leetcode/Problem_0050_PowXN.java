package leetcode;


public class Problem_0050_PowXN {

    /**
     * 系统最小不能转绝对值，单独讨论，当|x|>1，结果为0，当|x|<1，溢出，也记为0
     * 正常大小统一转绝对值计算
     * 可以将指数转二进制计算，这样时间复杂度O(logN)
     *
     * */
    public double myPow(double x, int n) {
        if(n == 0){
            return 1D;
        }
        if(n == Integer.MIN_VALUE){
            return (x == 1D || x== -1D) ? 1 : 0;
        }
        int pow = Math.abs(n);
        double t = x;
        double ans = 1D;
        while(pow != 0){
            if((pow & 1) != 0){
                ans *= t;
            }
            t *= t;
            pow >>= 1;
        }
        return n < 0 ? 1D / ans : ans;
    }
}
