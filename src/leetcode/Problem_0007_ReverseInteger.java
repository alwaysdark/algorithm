package leetcode;

/*
 * 有几点需要注意：
 * 1、int中，负数的范围比正数多一位，所以统一使用负数进行操作
 * 2、需要判断溢出的情况
*/
public class Problem_0007_ReverseInteger {
    public static int reverse(int x) {
		boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        while(x != 0){
            if (res < m || (res == m && x % 10 < o)){
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return neg ? res : Math.abs(res);
	}
}
