package leetcode;

public class Problem_0028_ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        return getIndexOf(haystack, needle);
    }

    public static int getIndexOf(String s, String m) {
        if(s == null || m == null || s.length() < m.length()){
            return -1;
        }
        if (m.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(match);
        while ((x < str.length) && (y < match.length)){
            if(str[x] == match[y]){
                x++;
                y++;
            } else if(next[y] == -1){
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }

    public static int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{ -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // cn代表，cn位置的字符，是当前和i-1位置比较的字符
        int cn = 0;
        while (i < next.length){
            if(ms[i - 1] == ms[cn]){
                next[i++] = ++cn;
            } else if(cn > 0){
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
