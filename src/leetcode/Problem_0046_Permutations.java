package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, ans, 0);
        return ans;
    }

    public void process(int[] nums, List<List<Integer>> ans, int index){
        if(index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for(int o: nums){
                cur.add(o);
            }
            ans.add(cur);
        } else {
            for(int i = index; i < nums.length; i++){
                swap(nums, index, i);
                process(nums, ans, index+1);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
