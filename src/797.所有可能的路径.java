/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int cur, int target, List<Integer> path, List<List<Integer>> ans) {
        if (cur == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[cur]) {
            path.add(next);
            dfs(graph, next, target, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

