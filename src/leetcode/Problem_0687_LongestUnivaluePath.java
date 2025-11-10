package leetcode;

/**
 * 二叉树的递归套路
 * 在这道题中，最终结果max分为以下情况
 * 1）与头结点x无关
 *    a. 左树最大
 *    b. 右树最大
 * 2）与头节点x有关
 *    c. x单独
 *    d. x沿着左树往下
 *    e. x沿着右树往下
 *    f. 左树、右树、头结点连起来了
 *
 * */
public class Problem_0687_LongestUnivaluePath {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        return process(root).max - 1;
    }

    // 建设以x节点为头的树，返回两个信息
    public static class Info{

        // 在一条路径上：要求每个节点通过且只通过一遍
        public int len; // 路径必须从x出发且只能往下走的情况下，路径的最大距离
        public int max; // 路径不要求必须从x出发的情况下，整棵树的合法路径最大距离

        public Info(int len, int max) {
            this.len = len;
            this.max = max;
        }
    }

    public Info process(TreeNode x){
        if(x == null){
            return new Info(0, 0);
        }
        TreeNode l = x.left;
        TreeNode r = x.right;
        Info lInfo = process(l);
        Info rInfo = process(r);
        // 求len
        int len = 1;
        if(l != null && x.val == l.val){
            len = lInfo.len + 1;
        }
        if(r != null && x.val == r.val){
            len = Math.max(len, rInfo.len + 1);
        }
        // 求max
        int max = Math.max(Math.max(lInfo.max, rInfo.max), len);
        if(l != null && r != null && l.val == x.val && r.val == x.val){
            max = Math.max(max, lInfo.len + rInfo.len + 1);
        }
        return new Info(len, max);
    }
}
