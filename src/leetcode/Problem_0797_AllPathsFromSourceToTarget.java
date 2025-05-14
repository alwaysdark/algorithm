package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_0797_AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int cur, int target, List<Integer> path, List<List<Integer>> ans) {
        path.add(cur);
        if (cur == target) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int next : graph[cur]) {
                dfs(graph, next, target, path, ans);
            }
        }
        path.remove(path.size() - 1);
    }
    
}
