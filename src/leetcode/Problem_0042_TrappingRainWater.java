package leetcode;

public class Problem_0042_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int N = height.length;
        int L = 1;
        int leftMax = height[0];
        int R = N - 2;
        int rightMax = height[N - 1];
        int water = 0;
        while (L <= R) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - height[L]);
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                water += Math.max(0, rightMax - height[R]);
                rightMax = Math.max(rightMax, height[R--]);
            }
        }
        return water;
    }
}
