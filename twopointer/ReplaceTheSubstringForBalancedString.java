package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class ReplaceTheSubstringForBalancedString {

    public int balancedString(String s) {
        int n = s.length(), k = n / 4, l = 0, res = n;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);

        for (int r = 0; r < n; r++) {
            count.put(s.charAt(r), count.get(s.charAt(r)) - 1);
            while (l < n && count.getOrDefault('Q', 0) <= k && count.getOrDefault('W', 0) <= k && count.getOrDefault('E', 0) <= k 
            && count.getOrDefault('R', 0) <= k) {
                res = Math.min(res, r - l + 1);
                count.put(s.charAt(l), count.get(s.charAt(l)) + 1);
                l++;
            }
        }
        return res;
    }
    // QQWE
    // 1. l=1, r=0,
    // 2. l 

    public static void main(String[] args) {
        
    }
}
