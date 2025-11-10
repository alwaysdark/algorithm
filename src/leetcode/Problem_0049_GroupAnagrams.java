package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for(String s: strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!m.containsKey(key)){
                m.put(key, new ArrayList<>());
            }
             m.get(key).add(s);
        }
        for(List<String> v: m.values()){
            ans.add(v);
        }
        return ans;
    }
}
